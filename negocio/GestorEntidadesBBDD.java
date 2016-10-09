package negocio;

import java.util.List;

import modelo.Entidad;
import persistencia.EntidadDao;
import persistencia.factoria.FactoriaEntidadDao;

public class GestorEntidadesBBDD implements GestorEntidades{

	private EntidadDao pDao = FactoriaEntidadDao.getEntidadDao();

	@Override
	public List<Entidad> listaEntidades() {		
		return pDao.listaEntidades();
	}

	@Override
	public Entidad buscarEntidad(Integer idEntidad) {
		return pDao.buscarEntidad(idEntidad);
	}

	@Override
	public void actualizaEntidad(Entidad Entidad) {
		pDao.actualizaEntidad(Entidad);
	}

	@Override
	public Integer insertarEntidad(Entidad Entidad) {
		return pDao.insertarEntidad(Entidad);
	}

	
	
}
