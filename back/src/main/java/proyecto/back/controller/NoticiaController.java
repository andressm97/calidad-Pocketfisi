package proyecto.back.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import proyecto.back.entity.Noticia;
import proyecto.back.service.NoticiaService;
@CrossOrigin 
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
	public boolean agregarNoticias(
									@RequestParam("file") MultipartFile file,
									@RequestParam("title") String title,
									@RequestParam("description") String description,
									@RequestParam("category")String category,
									@RequestParam("url") String url,
									@RequestParam("id_user")String id_user
			
			
			
			) throws IOException {
		
		Noticia noticia = new Noticia();
		noticia.setTitle(title);
		noticia.setDescription(description);
		noticia.setCategory(category);
		noticia.setUrl(url);
		noticia.setId_user(id_user);
		
		
		logger.info(">insertarNoticia :" + noticia.toString() );
		
		
		try {
			
			if (!file.isEmpty()) {

				System.out.println("imagen correcta");
//		        String nombre = file.getOriginalFilename();
//		        String tipo   = file.getContentType();
//		        Long tamano   = file.getSize();
		        byte[] pixel  = file.getBytes();
		        
		        noticia.setImagen(pixel);

		    }
		
			return service.agregarNoticia(noticia);
			
		}catch (DataAccessException e) {
			
			System.out.println("error al agregar noticia :"+e.getMessage());
			return false;
			// TODO: handle exception
		}
		
		
		
		
		
		
	}
	
	@RequestMapping(value="/imagen/{id}", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] MostrarImagen(@PathVariable("id") Integer id) {
		
		return service.ImgNoticia(id);
		
		
	}
	
	
	
	
	
	@RequestMapping(value="/listar/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Noticia> listarNoticiasByCodigo(@PathVariable("id") Integer id){
	
		
		
		try {
			
			Noticia noticia=service.noticiaByCodigo(id);
			return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
			
			
		}catch (DataAccessException e) {
			
			
			return new ResponseEntity<Noticia>(new Noticia(),HttpStatus.BAD_REQUEST);
			
		}

		
	
	}
	@RequestMapping(value="/listar/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean EliminarNoticiaByCodigo(@PathVariable("id") Integer id){
		
		try {
			
			return service.NoticiaDelete(id);
		}catch (DataAccessException e) {
			
			System.out.println("ERROR AL ELIMINAR : "+e.getMessage());
			return false;
			
			
		}
		
		
		
		
	}
	
	@RequestMapping(value="/listar/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean editarNoticia(@PathVariable("id") Integer id,@RequestBody Noticia noticia) {
		
		logger.info(">EditarNoticia :" + noticia.toString() );
		
		
		try {
					
			return service.NoticiaEditar(id, noticia);
			
		}catch (DataAccessException e) {
					
					System.out.println("ERROR AL EDITAR  : "+e.getMessage());
					return false;
					
					
		}}
				
		
		
		
		
		
	}
	
	
	

	


