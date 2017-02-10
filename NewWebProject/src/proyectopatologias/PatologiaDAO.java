package proyectopatologias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatologiaDAO {
	public static PatologiaDTO buscarPatologiaID(int id, Connection conn, Statement stmt) throws SQLException
	{
		ResultSet rset = null;
		PatologiaDTO patologia = null;
		rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIA_ID + id);
		while (rset.next())
		{
			patologia = new PatologiaDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), buscarSintomasPatologiaID(id, conn));
		}
		
		return patologia;
	}
	
	public static List<Sintoma> buscarSintomasPatologiaID (int id, Connection conn) throws SQLException
	{
		List<Sintoma> lista_sintomas = new ArrayList<Sintoma>();
		
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		Sintoma sintoma = null;
		ResultSet result = null;
		Statement state = null;
		state = conn.createStatement();
		result = state.executeQuery(Consultas.CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID +id+")");
		while (result.next())
	    {
			id_sintoma = result.getInt(1);
			descripcion_sintoma = result.getString(2);
			sintoma = new Sintoma(id_sintoma, descripcion_sintoma);
			lista_sintomas.add(sintoma);
		}
		
		if (result != null) { try { result.close(); } catch (Exception e) { e.printStackTrace(); }}
		if (state != null)	{ try {	state.close(); } catch (Exception e) { e.printStackTrace(); }}
		return lista_sintomas;
	}
}
