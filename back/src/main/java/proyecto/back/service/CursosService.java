package proyecto.back.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.CursosDAO;
import proyecto.back.entity.Cursos;
import proyecto.back.entity.CursosSUM;

@Service
public class CursosService {
	@Autowired
	private CursosDAO ListaDAO;
	
	public List<Cursos> cursolist() {
		
		List<Cursos> curso= ListaDAO.getListaCurso();
		
		return curso;
	}
	
	public boolean agregarListaCursos(List<CursosSUM>cursos) {
		
		return ListaDAO.agregar_listaCursos(cursos);
	}
	
	

}
