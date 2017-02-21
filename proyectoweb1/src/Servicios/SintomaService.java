package Servicios;

import java.util.List;

import DTO.SintomaDTO;
import dao.SintomasDAO;

public class SintomaService {

	public static List<SintomaDTO> BuscarSintomaPorLetra(String inicio)
	{
		List<SintomaDTO> lista=null;
		
		SintomasDAO sdao=new SintomasDAO();
		lista=sdao.BuscarSintomaPorLetra(inicio);
		
		
		return lista;
	}
}
