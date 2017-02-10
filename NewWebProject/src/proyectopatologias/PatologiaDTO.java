package proyectopatologias;

import java.util.List;

public class PatologiaDTO
{
	private int id;
	private String nombre;
	private String descripcion;
	private String tratamiento;
	private String causa;
	private List<Sintoma> lista_sintoma;
	

	public PatologiaDTO(int id, String nombre, String descripcion, String tratamiento, String causa, List<Sintoma> lista_sintoma)
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tratamiento = tratamiento;
		this.causa = causa;
		this.lista_sintoma = lista_sintoma;
	}
	
	public List<Sintoma> getLista_sintoma()
	{
		return lista_sintoma;
	}

	public void setLista_sintoma(List<Sintoma> lista_sintoma)
	{
		this.lista_sintoma = lista_sintoma;
	}

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public String getTratamiento()
	{
		return tratamiento;
	}
	
	public void setTratamiento(String tratamiento)
	{
		this.tratamiento = tratamiento;
	}
	
	public String getCausa()
	{
		return causa;
	}
	
	public void setCausa(String causa)
	{
		this.causa = causa;
	}

	@Override
	public String toString()
	{
		return this.id + ". " + this.nombre;
	}
}
