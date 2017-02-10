
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class PatologiaDAO {
	
	private final static String S_PATH_FILE_PRIVATE_KEY = "id_rsa.ppk"; //\\windows absolut path of our ssh private key locally saved
	private final static String S_PATH_FILE_KNOWN_HOSTS = "known_hosts";
	private final static String S_PASS_PHRASE = "mypassphrase";
	private final static int LOCAl_PORT = 3308; 
	private final static int REMOTE_PORT = 3306; 
	private final static int SSH_REMOTE_PORT = 22; 
	private final static String SSH_USER = "587fca0889f5cf057100004b";
	private final static String SSH_REMOTE_SERVER = "femxa-ebtm.rhcloud.com";
	private final static String MYSQL_REMOTE_SERVER = "127.11.220.2";
	private static Session sesion; //represents each ssh session
	private final static String cadena_conexion = "jdbc:mysql://localhost:3308/femxa";
	private final static String user = "adminGXjlxzG";
	private final static String password = "QBShkFDW_69e";
	
	
	private static void conectate_A_SSH () throws Throwable
	{
		JSch jsch = new JSch();
       jsch.setKnownHosts(S_PATH_FILE_KNOWN_HOSTS);
        jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY, S_PASS_PHRASE.getBytes());

        sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
        sesion.connect();       
        sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT); 


	}
	
	private static void desconectate_D_SSH ()
	{
		sesion.disconnect();
	}


	
	public static PatologiaDTO buscarPatologiaID(int id, List<PatologiaDTO> lista)
	{
		PatologiaDTO pato = null;
		int i = 0;
		do
		{
			pato = lista.get(i);
			i++;
		}
		while(pato.getId_patol() != id);
		
		return pato;
	}
	public static void main(String[] args) throws Throwable {
		
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		
		try
		{
			conectate_A_SSH();
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			
			conn = DriverManager.getConnection (cadena_conexion, user, password);
  	        stmt = conn.createStatement();
  	        
  	        
  	      List<PatologiaDTO> lista_patologias = null;
  	      List<SintomasDTO> lista_sintomas = null;
  	      lista_patologias = Consultas.listarPatologias(stmt, conn);
  	      HashMap<PatologiaDTO, List<SintomasDTO>> hm = new HashMap<PatologiaDTO, List<SintomasDTO>>();
  	       	      
  	      int id = 0;
  	      id = 3;
  	      PatologiaDTO pato = null;
  	        
  	      
  	      pato = buscarPatologiaID(id, lista_patologias);
  	      
  	      System.out.println("La patologia es :"+pato.getNom_patol()); 
  	      
  	      for (PatologiaDTO patologia : lista_patologias)
	  	      {
				lista_sintomas = Consultas.buscarSintomasPorPatologia(stmt, conn, patologia.getId_patol());
	 	    	hm.put(patologia, lista_sintomas);
	 	    	System.out.println(hm.get(patologia));
	  	      }
  	      
  	      

	        			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}

			desconectate_D_SSH(); 
		}   

		
	}
}




