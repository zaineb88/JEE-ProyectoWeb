package Servicios;

import DTO.PatologiaDTO;
import dao.PatologiaDAO;

public class PatologiaService {
	
	public PatologiaDTO buscarPatologiaPorId (int id)
	{
		PatologiaDTO pdto;
		PatologiaDAO pdao=new PatologiaDAO();
		pdto=pdao.buscarPorId(id);
		//System.out.println(pdto.toString());
		
		return pdto;
	}

}
