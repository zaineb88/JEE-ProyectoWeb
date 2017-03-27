package android;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcularLetraDni
 */
@WebServlet("/CalcularLetraDni")
public class CalcularLetraDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcularLetraDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String dni=request.getParameter("dni");
		int numero=Integer.parseInt(dni);
		
		
			char letra=letraDNI(numero);
			System.out.println(letra);
			response.getWriter().append("LA LETRA ES : "+letra);
	//  request	(HttpURLConnection.HTTP_OK);
		
	
		
		
	}

	private char letraDNI(int numero) {

		char letra=0;
			
		String letras1="TRWAGMYFPDXBNJZSQVHLCKE"; 
	
		int posicion=numero%23;
		letra=letras1.charAt(posicion);
	
		return letra;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
