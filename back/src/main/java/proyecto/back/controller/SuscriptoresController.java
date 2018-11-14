package proyecto.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyecto.back.entity.Suscriptores;

import proyecto.back.service.SuscriptoresService;
@CrossOrigin
@RestController
@RequestMapping("/subs")
public class SuscriptoresController {
	@Autowired
	private SuscriptoresService service;
	@RequestMapping(value="/listar/{id_programa}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Suscriptores>> getSubs(@PathVariable("id_programa") Integer id_programa){
		
		List<Suscriptores> subs = null;
		try {
			subs = service.getSubs(id_programa);

			if (subs == null) {
				subs = new ArrayList<Suscriptores>();
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<List<Suscriptores>>(subs, HttpStatus.INTERNAL_SERVER_ERROR);
		}


		return new ResponseEntity<List<Suscriptores>>(subs, HttpStatus.OK);
		
		
	}

}
