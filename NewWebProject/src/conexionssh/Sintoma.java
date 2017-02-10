package conexionssh;

public class Sintoma {
	
	private int id_sintoma;
	private String desc_sintoma;
	
	
	public Sintoma(int id_sintoma, String desc_sintoma) {
		super();
		this.id_sintoma = id_sintoma;
		this.desc_sintoma = desc_sintoma;
	}
	
	
	public int getId_sintoma() {
		return id_sintoma;
	}
	public void setId_sintoma(int id_sintoma) {
		this.id_sintoma = id_sintoma;
	}
	public String getDesc_sintoma() {
		return desc_sintoma;
	}
	public void setDesc_sintoma(String desc_sintoma) {
		this.desc_sintoma = desc_sintoma;
	}
	
	
	
	
	

}
