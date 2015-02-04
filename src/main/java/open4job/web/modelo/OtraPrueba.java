package open4job.web.modelo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import open4job.web.modelo.dao.AparcamientoMotoDAO;
import open4job.web.modelo.vo.AparcamientoMotoVO;

/**
 * Servlet implementation class OtraPrueba
 */
public class OtraPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtraPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out = response.getWriter();
		int id=0;
		try{
		id = Integer.parseInt(request.getParameter("id"));
		}catch(Exception e){
		}
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
		.getDetailAparcamientoMoto(id);
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Aparcamiento Moto</h1>");
		out.println(motoDetalle.toString());
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
