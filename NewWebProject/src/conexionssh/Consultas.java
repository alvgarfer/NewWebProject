package conexionssh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Consultas {
	
	
	public static int EjecutarMenu()
	{
		int opcion = 0;
		
		EntradaSalida.mostrarMenu();
		opcion = EntradaSalida.recogerOpcion();
		return opcion;
	}
	
	
//	1. --- Buscar patologias por nombre ---
//
//	    Select nom_patol From Patologias Where id_patol IN (Select id_patol from Patologias Where nom_patol = 'Queratocono');
//	    // Busca patologias por nombre (en este caso solo Queratocono)
//
	
	public static void buscarPatologiasNombre(ResultSet rset, Statement stmt) throws SQLException
	{
		String patologia =null;
		patologia = EntradaSalida.recogerPatologia();
		rset = stmt.executeQuery("Select nom_patol From Patologias Where id_patol IN "
				+ "(Select id_patol from Patologias Where nom_patol = '" + patologia + "')");
		
		String nombre = null;
//		Integer id = null;
		while (rset.next())
			
		    {
				nombre = rset.getString(1);
				
				System.out.println("Patología  = "+nombre);
			 }
	}
	
	
	public static void buscarSintomas()
	{
		System.out.println("En construcción.");
	}
	
	public static void listarPatologias()
	{
		System.out.println("En construcción.");
	}
	
	
	public static void buscarPatologiaSintomas()
	{
		System.out.println("En construcción.");
	}
	
	
	public static void listarSintomasPatologia(ResultSet rset, Statement stmt) throws SQLException
	{
		String patologia = null;
		Sintoma sintoma =null;
		ArrayList<Sintoma> list = null;
		list = new ArrayList<Sintoma>();
		
		patologia = EntradaSalida.recogerPatologia();
		
		rset = stmt.executeQuery("SELECT * FROM Sintomas WHERE Sintomas.id_sint IN (SELECT id_sint FROM Causas WHERE id_patol IN "
				+ "(SELECT id_patol FROM Patologias WHERE nom_patol = '" + patologia + "'))");
																																																		
		while (rset.next())
			
		    {
				sintoma = new Sintoma(rset.getInt(1), rset.getString(2));
				list.add(sintoma);
			 }
		
		for(Sintoma s : list)
		{
			System.out.println(s.getId_sintoma() + "; " + s.getDesc_sintoma());
		}
	}

//
//	2. --- Buscar sintomas por nombre ---
//
//	    SELECT FROM * Sintomas; 
//	    // (para editar)
//	    SELECT des_sint From Sintomas Where id_sint IN (Select id_sint From Sintomas Where id_sint); 
//	    // (para mostrar)
//	  
//	  
//	3. --- Listar patologias ---
//
//	    SELECT nom_patol From Patologias Where id_patol IN (Select id_patol From Patologias Where id_patol);
//	    // (Lista solo nombres patologias)
//	    SELECT nom_patol, trat_patol From Patologias Where id_patol IN (Select id_patol From Patologias where id_patol);
//	    // (Lista nombre de patologia + tratamiento)
//	    
//	 
//	   
//	4. --- Buscar lista patologia por sintomas ---
//
//	    SELECT nom_patol FROM Patologias WHERE id_patol IN (SELECT id_patol FROM Causas WHERE id_sint = 3);
//	    // Muestra las patologias con los sintomas que has buscado


}
