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

import proyecto.back.entity.Cursos_Mobil;
import proyecto.back.service.Curso_MobilService;


@RestController
@RequestMapping("/cursos_mb")
public class Cursos_MobilController {
	@Autowired
	private Curso_MobilService service;
	@RequestMapping(value="/listar/{dia}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Cursos_Mobil>> getSubs(@PathVariable("dia") String dia){
		List<Cursos_Mobil> lista = null;
		try {
			lista  = service.cursolist(dia);

			if (lista == null) {
				lista = new ArrayList<Cursos_Mobil>();
			}
			
		} catch (Exception e) {
		
			return new ResponseEntity<List<Cursos_Mobil>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}


		return new ResponseEntity<List<Cursos_Mobil>>(lista, HttpStatus.OK);
		
		
	}
}
