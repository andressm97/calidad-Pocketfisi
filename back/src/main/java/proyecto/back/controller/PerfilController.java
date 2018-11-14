package proyecto.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import proyecto.back.entity.Perfil;
import proyecto.back.service.PerfilService;
@CrossOrigin
@RestController
@RequestMapping("/perfiles")
public class PerfilController {
	@Autowired
	private PerfilService service;
	
	@RequestMapping( method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Perfil>> getLista_perfiles(){
		
		
		List<Perfil> list = null;

		try {
			
			list = service.listarPerfil();
			
			if (list == null) {
				list = new ArrayList<Perfil>();
			}
		} catch (Exception e) {

			return new ResponseEntity<List<Perfil>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


		return new ResponseEntity<List<Perfil>>(list, HttpStatus.OK);
		
		
	}
	

}
