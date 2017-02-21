

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.SintomaDTO;
import Servicios.SintomaService;

/**
 * Servlet implementation class BuscarSintomaPorLetra
 */
@WebServlet("/BuscarSintomaPorLetra")
public class BuscarSintomaPorLetra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSintomaPorLetra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String valor=request.getParameter("valor");
		SintomaService ss=new SintomaService();
	List<SintomaDTO> lista=	ss.BuscarSintomaPorLetra(valor);
		
		for(SintomaDTO sintoma:lista)
		{response.getWriter().append("Served at: "+sintoma).append(request.getContextPath());
			System.out.println(sintoma);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
