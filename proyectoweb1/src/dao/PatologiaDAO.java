package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.PatologiaDTO;
import DTO.SintomaDTO;

public class PatologiaDAO {
	


	
	public static PatologiaDTO compomonerObjeto (ResultSet rs) throws Exception
	{
		PatologiaDTO patologiaDTO = null;
		
			int id_patol = rs.getInt("id_patol");
			String nom_patol = rs.getString("nom_patol");
			String des_patol = rs.getString("des_patol");
			String trat_patol = rs.getString("trat_patol");
			String causa_patol = rs.getString("causa_patol");
			
			patologiaDTO = new PatologiaDTO(id_patol, nom_patol, causa_patol, trat_patol, des_patol);
			
		
		
		return patologiaDTO;
	}
	
	
	public PatologiaDTO buscarPorId (int id)
	{
		PatologiaDTO patologiaDTO = null;
		Pool pool = null;
		Connection conexion = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		SintomaDTO sintomaDTO = null;
		
		try{
			
		
			pool = Pool.getInstance();
			conexion = pool.getConnection();
			ps = conexion.prepareStatement("SELECT * FROM Patologias p, Sintomas s WHERE p.id_patol = ? AND s.id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol = ?)");
			
			ps.setInt(1, id);
			ps.setInt(2, id);
			
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				patologiaDTO = compomonerObjeto(rs);
			}
			
			do
			{
				sintomaDTO = SintomasDAO.componerObjeto(rs);
				patologiaDTO.addSintoma(sintomaDTO);
				
			}while (rs.next());
			
			
			
		} catch (Exception e)
		{
			e.printStackTrace();
			
		} finally 
		{
			pool.liberarRecursos(conexion, ps, rs);
		}
		
		
		return patologiaDTO;
	}

}
