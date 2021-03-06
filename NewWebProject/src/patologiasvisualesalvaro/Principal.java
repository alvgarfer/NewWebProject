package patologiasvisualesalvaro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Principal
{
	private final static String S_PATH_FILE_PRIVATE_KEY = "id_rsa.ppk"; //\\windows absolut path of our ssh private key locally saved
	private final static String S_PATH_FILE_KNOWN_HOSTS = "known_hosts";
	private final static String S_PASS_PHRASE = "mypassphrase";
	private final static int LOCAl_PORT = 3309; 
	private final static int REMOTE_PORT = 3306; 
	private final static int SSH_REMOTE_PORT = 22; 
	private final static String SSH_USER = "587fca0889f5cf057100004b";
	private final static String SSH_REMOTE_SERVER = "femxa-ebtm.rhcloud.com";
	private final static String MYSQL_REMOTE_SERVER = "127.11.220.2";
	private static Session sesion; //represents each ssh session
	private final static String cadena_conexion = "jdbc:mysql://localhost:3309/femxa";
	private final static String user = "adminGXjlxzG";
	private final static String password = "QBShkFDW_69e";
	
	private static void connect_A_SSH () throws Throwable
	{
		JSch jsch = new JSch();
        jsch.setKnownHosts(S_PATH_FILE_KNOWN_HOSTS);
        jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY, S_PASS_PHRASE.getBytes());

        sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
        sesion.connect(); //ssh connection established!

        //by security policy, you must connect through a fowarded port          
        sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);
	}
	
	private static void disconnect_D_SSH ()
	{
		sesion.disconnect();
	}

	public static Patologia buscarPatologiaID(int id, List<Patologia> lista)
	{
		Patologia pato = null;
		int i = 0;
		
		do
		{
			pato = lista.get(i);
			i++;
		}
			while(pato.getId() != id);
		
		return pato;
	}
	
	public static void main(String[] args) throws Throwable
	{
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		
		try
		{
			connect_A_SSH();
			DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());
			
			conn = DriverManager.getConnection (cadena_conexion, user, password);
  	        stmt = conn.createStatement();
  	        
  	      List<Patologia> lista_patologias = null;
  	      List<Sintoma> lista_sintomas = null;
  	      lista_patologias = Consultas.listarPatologias(stmt, conn);
  	      HashMap<Patologia, List<Sintoma>> hmap = new HashMap<Patologia, List<Sintoma>>();
  	      
  	      for (Patologia patologia : lista_patologias)
  	      {
  	    	  lista_sintomas = Consultas.buscarSintomasPorPatologia(stmt, conn, patologia.getId());
  	    	  hmap.put(patologia, lista_sintomas);
  	    	  System.out.println(patologia + " = " + hmap.get(patologia));
  	      }
  	      
  	      int id = 0;
  	      id = 9;
  	      Patologia patologg = null;
  	        
  	      long tiempo_inicial = System.currentTimeMillis();
  	      
  	      patologg = buscarPatologiaID(id, lista_patologias);
  	      
  	      System.out.println(patologg.getNombre());
	        
	      long tiempo_final = System.currentTimeMillis();
	      double milisegundos = (tiempo_final - tiempo_inicial);
	      System.out.println("Tard� " + milisegundos + " milisegundos");			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e) { e.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
		  	disconnect_D_SSH(); 
		} 
	}
}
