package proyecto.back.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.ILista_cursosDAO;
import proyecto.back.entity.Lista_cursos;

@Service
public class Lista_cursosService {
	@Autowired
	private ILista_cursosDAO ListaDAO;
	
	public List<Lista_cursos> cursolist() {
		
		List<Lista_cursos> curso= ListaDAO.getListaCurso();
		
		return curso;
	}
	
	

}
