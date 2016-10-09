package entrada;

import negocio.FactoriaGestorEntidades;
import negocio.GestorEntidades;
import modelo.Entidad;

public class Main {
	
	public static void main(String[] args) {
		
		GestorEntidades gestorEntidadesBBDD = FactoriaGestorEntidades.getGestorEntidades();
		
		//Inserción de datos
		Entidad entidad1 = new Entidad(0, "NOMBRE_ENTIDAD1", "DESCRIPCION_ENTIDAD1");
		Entidad entidad2 = new Entidad(0, "NOMBRE_ENTIDAD2", "DESCRIPCION_ENTIDAD2");
		Entidad entidad3 = new Entidad(0, "NOMBRE_ENTIDAD3", "DESCRIPCION_ENTIDAD3");
	
		gestorEntidadesBBDD.insertarEntidad(entidad1);
		gestorEntidadesBBDD.insertarEntidad(entidad2);
		gestorEntidadesBBDD.insertarEntidad(entidad3);
		
		//Listado de datos
		for(Entidad ent : gestorEntidadesBBDD.listaEntidades()){
			System.out.println(ent.toString());
		}
		
		//Busqueda de un registro
		Entidad entidadBusqueda = gestorEntidadesBBDD.buscarEntidad(3);
		
		System.out.println("Búsqueda: "+entidadBusqueda);
		
		//Actualización de un registro
		entidadBusqueda.setNombre("NOMBRE MODIFICADO");
		entidadBusqueda.setDescripcion("DESCRIPCION MODIFICADA");				

		gestorEntidadesBBDD.actualizaEntidad(entidadBusqueda);
		
		System.out.println("Búsqueda: "+entidadBusqueda);
	
	}
	
}
