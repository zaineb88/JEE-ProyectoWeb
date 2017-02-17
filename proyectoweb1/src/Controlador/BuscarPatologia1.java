package Controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.PatologiaDTO;
import Servicios.PatologiaService;

/**
 * Servlet implementation class BuscarPatologia1
 */
@WebServlet("/BuscarPatologia1")
public class BuscarPatologia1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologia1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatologiaService ps=new PatologiaService();
		String str_id=request.getParameter("id");
		int id=Integer.parseInt(str_id);
		PatologiaDTO patoDto =ps.buscarPatologiaPorId(id);

		request.setAttribute("patologia", patoDto);
		
		//response.getWriter().append(""+patoDto);//.append(request.getContextPath());
		

		switch (id) {
		case 1:
			request.getRequestDispatcher(".//html//queratocono.jsp").forward(request, response);
			
			break;
		case 2:
			request.getRequestDispatcher(".//html//glaucoma.jsp").forward(request, response);
			
			break;
			
		case 4:
			request.getRequestDispatcher(".//html//catarata.jsp").forward(request, response);
			break;
		
		case 5:
			
			request.getRequestDispatcher(".//html//conjuntivitis.jsp").forward(request, response);
			
			break;
			
		case 6: 
			request.getRequestDispatcher(".//html//desprendimiento.jsp").forward(request, response);
			break;
			
		case 7:
			request.getRequestDispatcher(".//html//acromatopsia.jsp").forward(request, response);
			break;
			
		case 8:
			request.getRequestDispatcher(".//html//estrabismo.jsp").forward(request, response);
			break;
		
		case 9: 
			request.getRequestDispatcher(".//html//presbicia.jsp").forward(request, response);
			break;
						
		default:
			request.getRequestDispatcher(".//html//patologias.html").forward(request, response);
			break;
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
