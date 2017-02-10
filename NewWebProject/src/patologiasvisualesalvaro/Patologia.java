package patologiasvisualesalvaro;

public class Patologia
{
	private int id;
	private String nombre;
	private String causa;
	private String tratamiento;
	private String descripcion;
	
	public Patologia(int id, String nombre, String causa, String tratamiento, String descripcion )
	{
		this.id = id;
		this.nombre = nombre;
		this.causa = causa;
		this.tratamiento = tratamiento;
		this.descripcion = descripcion;
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
	
	public String getCausa()
	{
		return causa;
	}
	
	public void setCausa(String causa)
	{
		this.causa = causa;
	}
	
	public String getTratamiento()
	{
		return tratamiento;
	}
	
	public void setTratamiento(String tratamiento)
	{
		this.tratamiento = tratamiento;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString()
	{
		return this.id+". "+this.nombre;
	}
}