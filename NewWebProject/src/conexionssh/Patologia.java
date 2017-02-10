package conexionssh;

public class Patologia {

	private int id_patologia;
	private String nombre_patologia;
	private String descripcion;
	private String tratamiento;
	private String causa;
	
	public int getId_patologia() {
		return id_patologia;
	}
	public void setId_patologia(int id_patologia) {
		this.id_patologia = id_patologia;
	}
	public String getNombre_patologia() {
		return nombre_patologia;
	}
	public void setNombre_patologia(String nombre_patologia) {
		this.nombre_patologia = nombre_patologia;
	}	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	
	
	public Patologia(int id_patologia, String nombre_patologia,
			String descripcion, String tratamiento, String causa) {
		super();
		this.id_patologia = id_patologia;
		this.nombre_patologia = nombre_patologia;
		this.descripcion = descripcion;
		this.tratamiento = tratamiento;
		this.causa = causa;
	}
	
	
	
	
	
}
