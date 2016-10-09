package modelo;

public class Entidad {

	private Integer idEntidad 	= null;
	private String	nombre		= null;
	private String  descripcion = null;
	
	public Integer getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Entidad() {
		super();
	}
	
	public Entidad(Integer idEntidad, String nombre, String descripcion) {
		super();
		this.idEntidad = idEntidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Entidad [idEntidad=" + idEntidad + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}

}
