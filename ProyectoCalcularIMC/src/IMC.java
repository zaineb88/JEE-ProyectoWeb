

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IMC
 */
@WebServlet("/IMC")
public class IMC extends HttpServlet {
	float imc;
    String peso;
	String altura;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMC() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException { // no es importante en este caso
	// TODO Auto-generated method stub
	super.init();
	imc=0;
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		peso = request.getParameter("peso");
		altura = request.getParameter("altura");
		System.out.println("peso ="+ peso);
		System.out.println("altura ="+ altura);
		String res=null;
		double peso1= Double.valueOf(peso) ;
		double altura1=Double.valueOf(altura) ;
		imc=Calcular.calcularIMC(peso1, altura1);
		
		res=Calcular.mostrarResultadoIMC(imc);
		
		
		PrintWriter pw= response.getWriter();
		//pw.write("Su imc es:"+res);
	
		response.getWriter().append("Peso= "+ peso+"\n");
		response.getWriter().append("Altura= "+ altura);
		response.getWriter().append("  IMC ES = "+ imc);
		response.getWriter().append("  Es :"+res);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		double peso1= Double.valueOf(peso) ;
		double altura1=Double.valueOf(altura) ;
		imc=Calcular.calcularIMC(peso1, altura1);
		System.out.println(imc);
	}


}
