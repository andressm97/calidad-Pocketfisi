package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.IDelegadoDAO;
import proyecto.back.entity.Cursos_delegado;
import proyecto.back.entity.Delegado;

@Service
public class DelegadoService  {
	
	@Autowired
	IDelegadoDAO delegadoDAO;
	
	public List<Cursos_delegado> mostrarcursos(String codigo,int hora){
		List<Cursos_delegado> lista=delegadoDAO.mostrarcursos(codigo, hora);
		return lista;
	}
	
	public List<Delegado> delegadoBYcodigo(String codigo){
		List<Delegado> lista = delegadoDAO.cursosDelegado(codigo);
		return lista;
	}
}
