package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Cursos_delegado;
import proyecto.back.entity.Delegado;

public interface IDelegadoDAO {
	
	List<Cursos_delegado> mostrarcursos(String codigo,int hora);
	
	List<Delegado> cursosDelegado(String codigo);

}
