

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class ObtenerInfoPatologia
 */
@WebServlet("/ObtenerInfoPatologia")
public class ObtenerInfoPatologia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerInfoPatologia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** http://localhost:8010/proyectoweb1/ObtenerInfoPatologia?id=1
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("llamando el DEPOST");
		String str = request.getParameter("id");
		System.out.println("Id ="+ str);
		
//		
//		String valorid = request.getParameter("id");
//		System.out.println("Valor id ="+valorid);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
