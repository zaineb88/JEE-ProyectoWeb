package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.PatologiaDTO;
import DTO.SintomaDTO;

public class PatologiaDAO {
	

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
			// utilisamos prepareStatement cuando tenemos un consulta que tiene un variable k no es fijo
			ps.setInt(1, id); // aqui estamos dar el variable al primer ?
			ps.setInt(2, id);
			
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				int id_patol = rs.getInt("id_patol");
				String nom_patol = rs.getString("nom_patol");
				String des_patol = rs.getString("des_patol");
				String trat_patol = rs.getString("trat_patol");
				String causa_patol = rs.getString("causa_patol");
				
				patologiaDTO = new PatologiaDTO(id_patol, nom_patol, causa_patol, trat_patol, des_patol);
				
			
			}
			
			do
			{
			       int id_sint = rs.getInt("id_sint");
					String desc_sint = rs.getString("des_sint");
					sintomaDTO = new SintomaDTO(id_sint, desc_sint);
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
