package DTO;


import java.util.ArrayList;
import java.util.List;

import DTO.SintomaDTO;




public class PatologiaDTO {
	
//	public PatologiaDTO(int int1, String nString, String string, String string2, String nString2,
//			List<SintomaDTO> sintomasPorPatologiaID) {
//		// TODO Auto-generated constructor stub
//	}
//	public PatologiaDTO() {
//		// TODO Auto-generated constructor stub
//	}
	private int id;
	private String nombre;
	private String causa;
	private String tratamiento;
	private String descripcion;
	private List<SintomaDTO> lista_sintomas;
	

//	
//	public PatologiaDTO(int id, String nombre, String causa, String tratamiento, String descripcion,
//			List<SintomaDTO> lista_sintomas) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.causa = causa;
//		this.tratamiento = tratamiento;
//		this.descripcion = descripcion;
//		this.lista_sintomas = lista_sintomas;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<SintomaDTO> getLista_sintomas() {
		return lista_sintomas;
	}
	public void setLista_sintomas(List<SintomaDTO> lista_sintomas) {
		this.lista_sintomas = lista_sintomas;
	}
	
	
//	@Override
//	public String toString() {
//		for(int i=0;i<lista_sintomas.size();i++)
//		{
//			System.out.println(lista_sintomas.get(i));
//		}
//		String strdev = "PATOLOGIA = " + this.nombre + " ID = " + this.id + " Nº Sintomas = " + this.lista_sintomas.size(); 
//		return strdev;
//	}
	
	
	public void addSintoma(SintomaDTO sintomaDTO) {
	
		this.lista_sintomas.add(sintomaDTO);
	}
	
	public PatologiaDTO(int id, String nombre, String causa, String tratamiento, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.causa = causa;
		this.tratamiento = tratamiento;
		this.descripcion = descripcion;
		this.lista_sintomas = new ArrayList<SintomaDTO>();
	}
}
