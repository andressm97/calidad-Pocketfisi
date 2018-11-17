package proyecto.back.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import proyecto.back.entity.Noticia;
import proyecto.back.service.UploadFileService;

@RestController
@RequestMapping("/imagen")
public class Imagen {
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	
	@Autowired
	private UploadFileService service;
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
		
	public ResponseEntity<Object> imagenUpload(@RequestParam("file") MultipartFile file ,@RequestParam("nombresito") String nombresito ) {
		
		if(file.isEmpty()) {
			return new ResponseEntity<Object>("xd", HttpStatus.OK);
		}
		try {
		service.saveFile(file);
		
		}catch (Exception e) {
			System.out.println("error : "+e.getMessage());
			
		}
		return new ResponseEntity<Object>("correcto", HttpStatus.OK);
	}
	
//	@RequestMapping(value="/get",method=RequestMethod.GET)
//	public void getImagen(HttpServletResponse response) throws IOException {
//		
//		InputStream in= getClass().getResourceAsStream("../img/fondo2.jpg");
//		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//		IOUtils.copy(in, response.getOutputStream());
//		
//	}
//	
	@GetMapping(
			  value = "/get2",
			  produces = MediaType.IMAGE_JPEG_VALUE
			)
			public @ResponseBody byte[] getImageWithMediaType() throws IOException {
			    
			String sql="select img  from news where id_news=21";
			List<Map<String, Object>> result = JdbcTemplate.queryForList(sql);
			if (!result.isEmpty()) {
				
				byte[] bytes = (byte[]) result.get(0).get("img");
			    //return IOUtils.toByteArray(in);
			    return bytes;
			}
			
			return null;
			}
	
	
	
	
	
	
	@RequestMapping(value="/insertar2",method=RequestMethod.POST)
	public String imagenprueba(@RequestParam("file") MultipartFile file) throws IOException{
		
		
		 if (!file.isEmpty()) {


		        String nombre = file.getOriginalFilename();
		        String tipo   = file.getContentType();
		        Long tamano   = file.getSize();
		        byte[] pixel  = file.getBytes();
		        
		        System.out.println("xdsdasdasda :"+pixel.toString());
		        
		       // String sql = "UPDATE news  set img=? where id_news =21;";
		       // JdbcTemplate.update(sql,pixel);
		        

		    }

		    return "redirect:/ ";
		
	}
	
	
	
	
	
	
	
}
