package proyecto.back.controller;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import proyecto.back.entity.CursosSUM;




@RestController
@RequestMapping("/tabla")
public class ListaCursosSUM {
	
	
	private List<CursosSUM> cursos;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CursosSUM>> getTabla() throws IOException{
		
		URL url = new URL("https://sum-calidad.herokuapp.com/tabla/listar");
		// read json and write to db
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<CursosSUM>> typeReference = new TypeReference<List<CursosSUM>>(){};
		//InputStream inputStream = TypeReference.class.getResourceAsStream("/listar.json");
		InputStream inputStream = url.openStream();
		try {
			List<CursosSUM> users = mapper.readValue(inputStream,typeReference);
			cursos=users;
			System.out.println("USUARIOS GUARDADOS : " + users.get(0).getDocente());
		} catch (IOException e){
			System.out.println("ERROR! USUARIOS NO GUARDADOS : " + e.getMessage());
		}
		
		
		
		
		List<CursosSUM> list = null;

		try {
			
			list = cursos;
			
			if (list == null) {
				list = new ArrayList<CursosSUM>();
			}
		} catch (Exception e) {

			return new ResponseEntity<List<CursosSUM>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


		return new ResponseEntity<List<CursosSUM>>(list, HttpStatus.OK);
		
	}
	


}
