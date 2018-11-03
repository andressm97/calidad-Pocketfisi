package proyecto.back.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
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
	public ResponseEntity<Map> getCurso_delegado2(@PathVariable("codigo") String codigo){
		
		Calendar calendario = new GregorianCalendar();
		int hora=calendario.get(Calendar.HOUR_OF_DAY);
		
		Cursos_delegado curso=null;
		List<Delegado> lista2=null;
		lista2=service.delegadoBYcodigo(codigo);
		System.out.println("hora" + hora);
		
		curso= service.mostrarcursos(codigo,hora);
		System.out.println(curso.toString());
		
		
		if(lista2.size()!=0) {
				
				if(curso.getCodigo()!=0) {
					Map Map= new HashMap<>();
					Map.put("delegado","true");
					Map.put("haycurso", "true");
					Map<String,String> Map2= new HashMap<>();
					Map2.put("nombre",curso.getCurso());
					Map2.put("profesor",curso.getProfesor());
					Map.put("curso",Map2);
					return new ResponseEntity<Map>(Map, HttpStatus.OK);
				}
				else {
					// no hay curso en el rango
					Map<String,String> Map= new HashMap<>();
					Map.put("delegado", "true");
					Map.put("haycurso", "false");
					
					return new ResponseEntity<Map>(Map,HttpStatus.OK);
				}
					
			}
		
			 
			 
			
		
		else {
			
			Map<String,String> Map= new HashMap<>();
			Map.put("delegado", "false");
			return new ResponseEntity<Map>(Map, HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
}
