package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import DTO.SintomaDTO;


public class SintomasDAO {

	
	
	public static List<SintomaDTO> BuscarSintomaPorLetra(String inicio)
	{
		List<SintomaDTO> lista=null;
		
		
		Pool pool = null;
		Connection conexion = null;
		ResultSet rs = null;
		//PreparedStatement ps = null;
		Statement st=null;
        SintomaDTO sintomaDTO=null;
		
		try{
			
		
			pool = Pool.getInstance();
			conexion = pool.getConnection();
			st=conexion.createStatement();
		//	ps = conexion.prepareStatement("SELECT id_sint, desc_sint FROM  Sintomas  WHERE desc_sint like '?%'");
			// utilisamos prepareStatement cuando tenemos un consulta que tiene un variable k no es fijo
			//ps.setString(1, inicio); // aqui estamos dar el variable al primer ?
			
			
			rs = st.executeQuery("SELECT id_sint, desc_sint FROM  Sintomas  WHERE desc_sint like '"+inicio+"%'");
			
			if (rs.next())
			{
				int id=rs.getInt("id_sint");
				String descripcion= rs.getString("desc_sint");
				sintomaDTO =new SintomaDTO(id, descripcion);
			
			}
			lista.add(sintomaDTO);
			
			
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
