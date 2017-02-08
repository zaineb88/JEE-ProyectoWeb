

import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DameHora
 */
@WebServlet("/DameHora")
public class DameHora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DameHora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HA LLAMADO AL GET !");
		//response.getWriter().append("HA LLAMADO AL GET");
		PrintWriter pw=response.getWriter();
		//pw.write("lo que ponga aqui, va a misa \n");
		
		Calendar calendar=Calendar.getInstance();
		int hora=calendar.get(Calendar.HOUR);
		int minutos=calendar.get(Calendar.MINUTE);
		int segundos=calendar.get(Calendar.SECOND);
		pw.write("<h1 style=\"color:blue;text-align:center\">LA HORA ES </h1>\n");
		pw.write("<h1><center>"+hora+":"+minutos+":"+segundos+"</h1></center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
