package proyecto.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyecto.back.entity.Lista_cursos;
import proyecto.back.service.Lista_cursosService;

@RestController
@RequestMapping("/cursos")
public class Lista_cursosController {
	
	@Autowired
	private Lista_cursosService service;
	@RequestMapping(value="/listar", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Lista_cursos>> getLista_cursos(){
		
		
		List<Lista_cursos> list = null;

		try {
			
			list = service.cursolist();
			
			if (list == null) {
				list = new ArrayList<Lista_cursos>();
			}
		} catch (Exception e) {

			return new ResponseEntity<List<Lista_cursos>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


		return new ResponseEntity<List<Lista_cursos>>(list, HttpStatus.OK);
		
		
	}
	

}
