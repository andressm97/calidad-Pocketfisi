package proyecto.back.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyecto.back.entity.Cursos_delegado;
import proyecto.back.entity.Delegado;

import proyecto.back.service.DelegadoService;

@RestController
@RequestMapping("/delegado")
public class DelegadoController {
	
	@Autowired
	private DelegadoService service;
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cursos_delegado>> getCurso_delegado(@PathVariable("codigo") String codigo){
		
		Calendar calendario = new GregorianCalendar();
		int hora=calendario.get(Calendar.HOUR_OF_DAY);
		List<Cursos_delegado> lista=null;
		List<Delegado> lista2=null;
		lista2=service.delegadoBYcodigo(codigo);
		System.out.println("hora" + hora);
		if(lista2.size()!=0) {
			try {
				lista= service.mostrarcursos(codigo,hora);
				if(lista.size()!=0) {
					//si existe 200
					return new ResponseEntity<List<Cursos_delegado>>(lista, HttpStatus.OK);
				}
				else {
					//204 no exiten cursos
					return new ResponseEntity<List<Cursos_delegado>>(lista,HttpStatus.NO_CONTENT );
				}
					
			}
			catch (Exception e) {
				// 500 otro error 
				return new ResponseEntity<List<Cursos_delegado>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			 
			 
			
		}
		else {
			//404 no es delegado
			return new ResponseEntity<List<Cursos_delegado>>(lista, HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
}
