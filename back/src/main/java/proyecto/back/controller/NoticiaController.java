package proyecto.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import proyecto.back.entity.Noticia;
import proyecto.back.service.NoticiaService;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private NoticiaService service;
	@RequestMapping(value="/listar", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Noticia>> listarNoticias(){
		
		List<Noticia> list = null;
		try {
			
			list = service.listarNoticias();
			
			if (list == null) {
				list = new ArrayList<Noticia>();
			}
		} catch (Exception e) {

			return new ResponseEntity<List<Noticia>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


		return new ResponseEntity<List<Noticia>>(list, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/agregar", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean agregarNoticias(@RequestBody Noticia noticia) {
		
		logger.info(">insertarNoticia :" + noticia.toString() );
		
		
		try {
			
			
			return service.agregarNoticia(noticia);
			
		}catch (DataAccessException e) {
			
			System.out.println("error al agregar noticia :"+e.getMessage());
			return false;
			// TODO: handle exception
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	}
	


