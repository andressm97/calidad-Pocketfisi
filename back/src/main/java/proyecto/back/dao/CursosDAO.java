package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Cursos;
import proyecto.back.entity.CursosSUM;

public interface CursosDAO {
	
	List<Cursos> getListaCurso();
	
	boolean agregar_listaCursos(List<CursosSUM> curso); 
}
