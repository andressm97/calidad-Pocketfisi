package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.Cursos_MobilDAO;
import proyecto.back.entity.Cursos_Mobil;

@Service
public class Curso_MobilService {
	@Autowired
	private Cursos_MobilDAO listaDAO;
	
	public List<Cursos_Mobil> cursolist(String dia){
		
		List<Cursos_Mobil> lista= listaDAO.getListacursos(dia);
		
		return lista;
		
	}

}
