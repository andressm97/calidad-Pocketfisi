package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Lista_cursos;
import proyecto.back.entity.CursosSUM;

public interface ILista_cursosDAO {
	
	List<Lista_cursos> getListaCurso();
	
	boolean agregar_listaCursos(List<CursosSUM> curso); 
}
