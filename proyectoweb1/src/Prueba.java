
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Pool;

/**
 * Servlet implementation class Prueba
 */
@WebServlet("/Prueba")
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String select_pat="select id_patol from Patologias where nom_patol ='Queratocono'";
		Pool pool =Pool.getInstance();
		ResultSet rs=null;
		Connection  con=pool.getConnection();
		int idpatol = -5;
		Statement st=null;
		try
		{
			
			st=con.createStatement();
			rs=st.executeQuery(select_pat);
			rs.next();
			idpatol=rs.getInt("id_patol");
			

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("error hace la consulta " + select_pat);
			
		}
	finally{
		//pool.liberarRecursos(con,st,rs);
			
			 try 
			 {
				 rs.close(); 
			 }
			 catch (SQLException e)
			 {
				 System.out.println("Error al liberar el ResultSet");
			 }
			 try 
			 {
				 st.close(); 
			 }
			 catch (SQLException e)
			 {
				 System.out.println("Error al liberar el Statement"); 
			 }
			 try 
			 {con.close();
			 
			 } catch (SQLException e) {
				 System.out.println("Error al liberar la conexión");
			}
			
		}
//		
	response.getWriter().append("EL ID DE QUERATOCONO ES: ").append(String.valueOf(idpatol));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
