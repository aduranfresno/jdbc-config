package negocio;

import util.CfgUtil;

public class FactoriaGestorEntidades {

	public static GestorEntidades getGestorEntidades(){
		
		GestorEntidades gt = null;
		
		try {
			Class<?> cga = Class.forName("negocio.GestorEntidades"+CfgUtil.TIPO_PERSISTENCIA);

			gt = (GestorEntidades) cga.newInstance();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return gt;	
	}
	
}
