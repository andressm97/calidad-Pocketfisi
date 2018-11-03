package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.IDelegadoDAO;
import proyecto.back.entity.Cursos_delegado;
import proyecto.back.entity.Delegado;
import proyecto.back.entity.Hora;

@Service
public class DelegadoService  {
	
	@Autowired
	IDelegadoDAO delegadoDAO;
	
	public Cursos_delegado mostrarcursos(String codigo,int hora){
		Cursos_delegado curso=delegadoDAO.mostrarcursos(codigo, hora);
		return curso;
	}
	
	public List<Delegado> delegadoBYcodigo(String codigo){
		List<Delegado> lista = delegadoDAO.cursosDelegado(codigo);
		return lista;
	}
	
	public Hora HoraActual() {
		Hora hora= delegadoDAO.horaAactual();
		return hora;
	}
}
