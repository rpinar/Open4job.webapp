package open4job.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import open4job.web.modelo.dao.AparcamientoMotoDAO;
import open4job.web.modelo.vo.AparcamientoMotoVO;


public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String driver = "oracle.jdbc.driver.OracleDriver";

		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";

		String user = "test";
		String password = "test";

		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;
		//String url = "jdbc:oracle:thin:test/test@54.154.192.80:1521:xe";

	
		AparcamientoMotoDAO aparcamientoMotoDAO = new AparcamientoMotoDAO(
				driver, url, user, password);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		AparcamientoMotoVO motoDetalle = aparcamientoMotoDAO.getDetailAparcamientoMoto(id);
		 String usuario = (String) request.getSession().getAttribute("Nombre");
	      
		 
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>HOLA "+usuario+"</h1>");
		if (motoDetalle==null) out.println("Nada que hacer");
		else out.println(motoDetalle.toString());
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
