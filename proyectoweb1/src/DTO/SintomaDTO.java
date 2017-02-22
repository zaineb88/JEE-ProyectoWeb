package DTO;

public class SintomaDTO {
	
	
	private int id;
	private String descripcion;
	
	public SintomaDTO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+ this.descripcion;
	}
	

}
