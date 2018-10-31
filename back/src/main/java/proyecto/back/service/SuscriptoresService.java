package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.ISuscriptoresDAO;
import proyecto.back.entity.Suscriptores;



@Service
public class SuscriptoresService {
	@Autowired
	private ISuscriptoresDAO suscriptoresDAO;
	
	public List<Suscriptores> getSubs(int id_programa){
		
		List<Suscriptores> lista= suscriptoresDAO.getSuscriptores(id_programa);
		
		return lista;
		
	}
	
	
}
