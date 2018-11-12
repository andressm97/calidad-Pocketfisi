package proyecto.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import proyecto.back.entity.Hora;
import proyecto.back.service.DelegadoService;

@RestController
@RequestMapping("/delegado")
public class DelegadoController {
	
	@Autowired
	private DelegadoService service;
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Object,Object>> getCurso_delegado2(@PathVariable("codigo") String codigo){
		
		
		Hora hora2= service.HoraActual();

		
		Cursos_delegado curso=null;
		List<Delegado> lista2=null;
		lista2=service.delegadoBYcodigo(codigo);
		System.out.println("hora: " + hora2);
		
		curso= service.mostrarcursos(codigo,hora2.getHora());
		//System.out.println(curso.toString());
		
		
		if(lista2.size()!=0) {
				
				if(curso.getCodigo()!=0) {
					Map<Object,Object> Map= new HashMap<>();
					Map.put("delegado",true);
					Map.put("haycurso", true);
					Map<String,String> Map2= new HashMap<>();
					Map2.put("nombre",curso.getCurso());
					Map2.put("profesor",curso.getProfesor());
					Map.put("curso",Map2);
					return new ResponseEntity<Map<Object,Object>>(Map, HttpStatus.OK);
				}
				else {
					// no hay curso en el rango
					Map<Object,Object> Map= new HashMap<>();
					Map.put("delegado", true);
					Map.put("haycurso", false);
					
					return new ResponseEntity<Map<Object,Object>>(Map,HttpStatus.OK);
				}
					
			}
		
			 
			 
			
		
		else {
			
			Map <Object,Object> Map= new HashMap<>();
			Map.put("delegado",false);
			return new ResponseEntity<Map<Object,Object>>(Map, HttpStatus.OK);
		}
		
		
		
		
	}
	
}
