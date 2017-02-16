

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioYFin
 *
 */
@WebListener
public class EscuchaInicioYFin implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EscuchaInicioYFin() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("PROGRMA DESTRUIDO");
    	System.out.println("PROGRMA DESTRUIDO");
    	System.out.println("PROGRMA DESTRUIDO");
    	System.out.println("PROGRMA DESTRUIDO");
    	MainSSH.desconectate_D_SSH();
    
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("PROGRMA INICIADO");
    	System.out.println("PROGRMA INICIADO");
    	System.out.println("PROGRMA INICIADO");
    	System.out.println("PROGRMA INICIADO");
    	try {
			MainSSH.conectate_A_SSH();
			System.out.println("La conexión SSH queda iniciada");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
