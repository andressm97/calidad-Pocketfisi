package proyecto.back.controller;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import proyecto.back.entity.Usuario;
import proyecto.back.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
		private Logger logger= LoggerFactory.getLogger(this.getClass());
		@Autowired
		private UsuarioService service;
		
		
		@RequestMapping(value="/listar", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Usuario>> getUsuarios(){
			
			List<Usuario> list = null;

			try {
				
				list = service.ListarUsuarios();
				
				if (list == null) {
					list = new ArrayList<Usuario>();
				}
			} catch (Exception e) {

				return new ResponseEntity<List<Usuario>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			


			return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
			
			
		
		}
		
		
		
		
		
		
		@RequestMapping(value="/insertar", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
		public boolean InsertarUsuario(@RequestBody Usuario usuario) {
			
			logger.info(">insertarUsuario["+usuario+"]"+" "+usuario.getId_user());
			
			boolean resp=false;
			try {
				logger.info("respuesta");
				logger.info("idusuario"+usuario.getId_user());
				if(!service.getIdUsuario(usuario.getId_user())) {
					
					usuario.setToQuery(true);
					logger.info("no existe");
				}
				else {
					usuario.setToQuery(false);
					logger.info("existe");
				}
				
				
				
				logger.info("agregado"+ resp);
				
			}
			catch(Exception e) {
				
				logger.info("catch" + e.getMessage());
				logger.info("insertarusuario"+ usuario);
				return false;
			}
			
			resp= service.agregarUsuario(usuario);
			
			return resp;
			
			
			
			
			
			
			
		}
		@RequestMapping(value="/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Map<String, String>> VerificarUsuario(@RequestBody Usuario usuario){
			
			logger.info(">mostrarusuario["+usuario+"]"+" "+usuario.getId_user());
			Usuario user = null;
			Map<String,String> map= new LinkedHashMap<>();
			try {
				
				user= service.MostrarUsuario(usuario.getUsername(),usuario.getPassword());
				logger.info(">mostrarusuarioenv["+user+"]"+" ");
				map.put("existe","true");
				map.put("nombre", user.getName()+" "+user.getLastname());
				map.put("codigo", user.getId_user());
				map.put("telefono",user.getMobile());
				map.put("perfil", user.getId_profile());
				
				
				
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
				
				
			} catch (Exception e) {
				logger.info(">mostrarusuarioenv["+user+"]"+" ");
				map.put("existe", "false");
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			


			
			
			
		
		}
		
		
		
		
		
}
