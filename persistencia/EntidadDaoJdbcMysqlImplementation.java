package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Entidad;
import util.CfgUtil;

public class EntidadDaoJdbcMysqlImplementation implements EntidadDao{
	
	@Override
	public List<Entidad> listaEntidades(){

		List<Entidad> listaAuxiliar = new ArrayList<Entidad>();
		
		Connection cx =  null;		
		try {
			cx = DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD);
			PreparedStatement pst = cx.prepareStatement("SELECT * FROM entidad");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Entidad Entidad = new Entidad(						  
						  rs.getInt("ENTI_ROWID_ENTIDAD"),
						  rs.getString("ENTI_NOMBRE"),						  
						  rs.getString("ENTI_DESCRIPCION")
						  );
				
				listaAuxiliar.add(Entidad);
							
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaAuxiliar;
	}
	

	@Override
	public Entidad buscarEntidad(Integer idEntidad){
		
		Entidad entidadAuxiliar = null;
		
		Connection cx =  null;		
		try {
			cx = DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD);
			
			PreparedStatement pst = cx.prepareStatement("SELECT * FROM entidad WHERE ENTI_ROWID_ENTIDAD=?");
			
			pst.setInt(1, idEntidad);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				entidadAuxiliar = new Entidad(						  
						  rs.getInt("ENTI_ROWID_ENTIDAD"),
						  rs.getString("ENTI_NOMBRE"),						  
						  rs.getString("ENTI_DESCRIPCION")
						  );
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return entidadAuxiliar;
	
	}
	
	@Override
	public void actualizaEntidad(Entidad entidad) {
		
		Connection cx =  null;		
		try {
			cx = DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD);
			PreparedStatement pst = cx.prepareStatement("UPDATE entidad SET " +
					"ENTI_NOMBRE=?, ENTI_DESCRIPCION=? WHERE ENTI_ROWID_ENTIDAD=?");
			
			pst.setString(1, entidad.getNombre());
			pst.setString(2, entidad.getDescripcion());
			pst.setInt(3, entidad.getIdEntidad());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {			
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	@Override
	public Integer insertarEntidad(Entidad entidad) {
		
		Connection cx =  null;		
		
		Integer resultado = null;
		
		try {
			cx = DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD);
			
			PreparedStatement pst = cx.prepareStatement("INSERT INTO entidad (" +
					"ENTI_ROWID_ENTIDAD, ENTI_NOMBRE, ENTI_DESCRIPCION) " +
					"values(?,?,?)");
			
			pst.setInt(1, entidad.getIdEntidad());
			pst.setString(2, entidad.getNombre());
			pst.setString(3, entidad.getDescripcion());
				    
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()){
			    resultado = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
		
	}
	
}
