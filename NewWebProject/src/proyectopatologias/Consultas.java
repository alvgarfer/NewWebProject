package proyectopatologias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Consultas
{ 
	public static final String CONSULTA_PATOLOGIA_ID = "SELECT * FROM Patologias WHERE id_patol = ";
	public static final String CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID = "SELECT * FROM Sintomas "
							+ "WHERE id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol = ";
}
