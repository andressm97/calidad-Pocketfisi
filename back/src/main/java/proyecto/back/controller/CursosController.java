package proyecto.back.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import proyecto.back.entity.Cursos;
import proyecto.back.entity.CursosSUM;
import proyecto.back.service.CursosService;
@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class CursosController {
	
	@Autowired
	private CursosService service;
	@RequestMapping(value="/listar", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Cursos>> getLista_cursos(){
		
		
		List<Cursos> list = null;

		try {
			
			list = service.cursolist();
			
			if (list == null) {
				list = new ArrayList<Cursos>();
			}
		} catch (Exception e) {

			return new ResponseEntity<List<Cursos>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


		return new ResponseEntity<List<Cursos>>(list, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/insertar", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		
	public boolean AgregarLista_cursos() throws IOException {
		
		 List<CursosSUM> cursos= new ArrayList<CursosSUM>() ;
		//recogiendo datos del SUM FAKE
			URL url = new URL("https://sum-calidad.herokuapp.com/tabla/listar");
			
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CursosSUM>> typeReference = new TypeReference<List<CursosSUM>>(){};
	
			InputStream inputStream = url.openStream();
			try {
				cursos = mapper.readValue(inputStream,typeReference);
				System.out.println("USUARIOS GUARDADOS : " + cursos.get(0).getDocente());
			} catch (IOException e){
				System.out.println("ERROR! USUARIOS NO GUARDADOS : " + e.getMessage());
			}
		
		//Agregando la lista a la base de datos
		
			boolean xd=service.agregarListaCursos(cursos);
		
		
		
		return xd;
	}
	
	
	

}
