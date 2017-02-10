package proyectopatologias;

public class Consultas
{ 
	public static final String CONSULTA_PATOLOGIA_ID = "SELECT * FROM Patologias WHERE id_patol = ";
	public static final String CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID = "SELECT * FROM Sintomas "
							+ "WHERE id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol = ";
}
