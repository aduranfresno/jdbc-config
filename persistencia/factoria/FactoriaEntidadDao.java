package persistencia.factoria;

import persistencia.EntidadDao;
import persistencia.EntidadDaoJdbcMysqlImplementation;
import util.CfgUtil;

public class FactoriaEntidadDao {

	public static EntidadDao getEntidadDao(){
		
		EntidadDao uDao = null;
		if(CfgUtil.TIPO_BBDD.equals("mysql")){
			uDao = new EntidadDaoJdbcMysqlImplementation();
		}
		
		return uDao;
		
	}
	
}
