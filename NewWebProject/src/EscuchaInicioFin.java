

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioFin
 *
 */
@WebListener
public class EscuchaInicioFin implements ServletContextListener
{

    /**
     * Default constructor. 
     */
    public EscuchaInicioFin()
    {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) 
    { 
    	System.out.println ("Programa Destruido");
    	System.out.println ("Programa Destruido");
    	System.out.println ("Programa Destruido");
    	System.out.println ("Programa Destruido");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) 
    { 
         System.out.println ("Programa Iniciado");
         System.out.println ("Programa Iniciado");
         System.out.println ("Programa Iniciado");
         System.out.println ("Programa Iniciado");
    }
	
}
