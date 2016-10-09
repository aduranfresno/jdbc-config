package persistencia;

import java.util.List;

import modelo.Entidad;

public interface EntidadDao {

	public abstract List<Entidad> listaEntidades();
	
	public abstract Entidad buscarEntidad(Integer idEntidad);

	public abstract void actualizaEntidad(Entidad Entidad);

	public abstract Integer insertarEntidad(Entidad Entidad);

}
