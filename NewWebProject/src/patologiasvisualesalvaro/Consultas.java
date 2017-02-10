package patologiasvisualesalvaro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Consultas
{
	public static final String CONSULTA_SINTOMAS_POR_PATOLOGIA = "SELECT * FROM Sintomas WHERE id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol = ";
	public static final String CONSULTA_LISTAR_PATOLOGIAS = "SELECT * FROM Patologias";
	public static final String CONSULTA_LISTAR_SINTOMAS = "SELECT * FROM Sintomas"; 
	
	public static List<Sintoma> buscarSintomasPorPatologia (Statement stmt, Connection conn, int id_patologia) throws SQLException
	{
		List<Sintoma> lista_sintomas = new ArrayList<Sintoma>();
		
			String descripcion_sintoma = null;
			int id_sintoma = 0;
			Sintoma sintoma = null;
			ResultSet rset = null;
			rset = stmt.executeQuery(Consultas.CONSULTA_SINTOMAS_POR_PATOLOGIA+id_patologia+")");
		
			while (rset.next())
		    {
				id_sintoma = rset.getInt(1);
				descripcion_sintoma = rset.getString(2);
				sintoma = new Sintoma(id_sintoma, descripcion_sintoma);
				lista_sintomas.add(sintoma);
			}
			
		return lista_sintomas;
	}
	
	public static List<Patologia> listarPatologias (Statement stmt, Connection conn) throws SQLException
	{
		List<Patologia> lista_patologias = new ArrayList<Patologia>();
			
			Patologia patologia = null;
			
			ResultSet rset = null;
			rset = stmt.executeQuery(Consultas.CONSULTA_LISTAR_PATOLOGIAS);
			
			while (rset.next())
		    {
				patologia = new Patologia(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
				lista_patologias.add(patologia);
		    }
			
		return lista_patologias;
	}
	
	public static List<Sintoma> listarSintomas (Statement stmt, Connection conn) throws SQLException
	{
		List<Sintoma> lista_sintomas = new ArrayList<Sintoma>();
			
			Sintoma sintoma = null;
			ResultSet rset = null;
			
			rset = stmt.executeQuery(Consultas.CONSULTA_LISTAR_SINTOMAS);
			
			while (rset.next())
		    {
				sintoma = new Sintoma(rset.getInt(1), rset.getString(2));
				lista_sintomas.add(sintoma);
		    }
			
		return lista_sintomas;
	}
}