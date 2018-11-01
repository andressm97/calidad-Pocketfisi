package proyecto.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyecto.back.entity.Listar_cursos_mobil;
import proyecto.back.service.Lista_curso_mobilService;


@RestController
@RequestMapping("/cursos_mb")
public class Lista_cursos_mobilController {
	@Autowired
	private Lista_curso_mobilService service;
	@RequestMapping(value="/listar/{dia}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Listar_cursos_mobil>> getSubs(@PathVariable("dia") String dia){
		List<Listar_cursos_mobil> lista = null;
		try {
			lista  = service.cursolist(dia);

			if (lista == null) {
				lista = new ArrayList<Listar_cursos_mobil>();
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<List<Listar_cursos_mobil>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}


		return new ResponseEntity<List<Listar_cursos_mobil>>(lista, HttpStatus.OK);
		
		
	}
}
