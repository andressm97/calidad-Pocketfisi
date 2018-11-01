package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.IListar_cursos_mobilDAO;
import proyecto.back.entity.Listar_cursos_mobil;

@Service
public class Lista_curso_mobilService {
	@Autowired
	private IListar_cursos_mobilDAO listaDAO;
	
	public List<Listar_cursos_mobil> cursolist(String dia){
		
		List<Listar_cursos_mobil> lista= listaDAO.getListacursos(dia);
		
		return lista;
		
	}

}
