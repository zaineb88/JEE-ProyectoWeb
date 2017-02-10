import java.util.List;



public class PatologiaDTO {

	private int id_patol;
	private String nom_patol;
	private String des_patol;
	private String tratamiento;
	private String causa;
	private List<SintomasDTO> lista_sintomas;
	
	
	public PatologiaDTO(int id_patol, String nom_patol, String des_patol, String tratamiento, String causa,List<SintomasDTO> lista_sintomas) {
		super();
		this.id_patol = id_patol;
		this.nom_patol = nom_patol;
		this.des_patol = des_patol;
		this.tratamiento = tratamiento;
		this.causa = causa;
		this.lista_sintomas = lista_sintomas;
	}
	
	
 void setLista_sintomas(List<SintomasDTO> lista_sintomas) {
		this.lista_sintomas = lista_sintomas;
	}
	public PatologiaDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getId_patol() {
		return id_patol;
	}
	public void setId_patol(int id_patol) {
		this.id_patol = id_patol;
	}
	public String getNom_patol() {
		return nom_patol;
	}
	public void setNom_patol(String nom_patol) {
		this.nom_patol = nom_patol;
	}
	public String getDes_patol() {
		return des_patol;
	}
	public void setDes_patol(String des_patol) {
		this.des_patol = des_patol;
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

    public List<SintomasDTO> getLista_sintomas() {
		return lista_sintomas;
	}
	
}
