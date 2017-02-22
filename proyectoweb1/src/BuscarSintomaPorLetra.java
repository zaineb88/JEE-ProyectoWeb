

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DTO.SintomaDTO;
import Servicios.SintomaService;
import javafx.scene.control.Alert;

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
		System.out.println(valor);
		SintomaService ss=new SintomaService();
		List<SintomaDTO> lista=new ArrayList<SintomaDTO>();
	    lista =	ss.BuscarSintomaPorLetra(valor);
	 
	    
	    //TRANSFORMO A JSON LA LISTTA
	    Gson gson = new Gson();
		Type tipoListaSintomas = new TypeToken<List<SintomaDTO>>(){}.getType();
		String s = gson.toJson(lista, tipoListaSintomas);
		
		
		//ESCRIBO HTTP BODY RESPONSE
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(s);
		
	
	    
	    
	    
	    /* request.setAttribute("sintoma", lista);
	 
	 for(int i=0;i<lista.size();i++){
		response.getWriter().append(""+lista.get(i)+"\n");}
		for(SintomaDTO sintoma:lista)
		{ 
			System.out.println(sintoma);
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
