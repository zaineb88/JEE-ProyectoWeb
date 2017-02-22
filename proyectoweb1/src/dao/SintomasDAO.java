package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.SintomaDTO;


public class SintomasDAO {

	
	
	public static List<SintomaDTO> BuscarSintomaPorLetra(String inicio)
	{
		List<SintomaDTO> lista=new ArrayList<SintomaDTO>();
	
		Pool pool = null;
		Connection conexion = null;
		pool = Pool.getInstance();
		ResultSet rs = null;

		Statement st=null;
        SintomaDTO sintomaDTO=null;
		conexion = pool.getConnection();
			
		try{
			
		
			st=conexion.createStatement();
	
			rs = st.executeQuery("SELECT id_sint, des_sint FROM  Sintomas  WHERE des_sint like '"+inicio+"%'");
			
			while (rs.next())
			{
				int id=rs.getInt("id_sint");
				String descripcion= rs.getString("des_sint");
				sintomaDTO =new SintomaDTO(id, descripcion);
				lista.add(sintomaDTO);
			
			}
		
			
		} catch (Exception e)
		{
			e.printStackTrace();
			
		} finally 
		{
			pool.liberarRecursos(conexion, st, rs);
		}
		
		
		
		
		
		return lista;
	}
}
