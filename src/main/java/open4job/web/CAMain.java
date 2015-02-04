package open4job.web;

import open4job.web.modelo.dao.AparcamientoMotoDAO;
import open4job.web.modelo.vo.AparcamientoMotoVO;

public class CAMain {
	


	public static void main(String[] args){

		String driver = "oracle.jdbc.driver.OracleDriver";

		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";

		String user = "test";
		String password = "test";

		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;

	
		// AparcamientoMoto
		AparcamientoMotoDAO aparcamientoMotoDAO = new AparcamientoMotoDAO(
				driver, url, user, password);

		// Detalles Aparcamiento Moto
		AparcamientoMotoVO motoDetalle = aparcamientoMotoDAO
				.getDetailAparcamientoMoto(222);
		System.out.println(motoDetalle.toString());

	}
}
