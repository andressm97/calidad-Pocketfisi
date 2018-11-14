package proyecto.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyecto.back.entity.Mensaje;
import proyecto.back.service.SendMailService;
@CrossOrigin
@RestController
@RequestMapping("/mensaje")
public class MailController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SendMailService service;
	
	
	@RequestMapping(value="/enviar", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean enviarMensaje(@RequestBody Mensaje mensaje) {
		
		
		logger.info("INSERTAR MENSAJE : "+mensaje.toString());
		
		boolean insertado=service.insertarMensaje(mensaje);
		
		if(insertado) {
			
			service.sendMail("necesito.soporte18@gmail.com", "soportefisi18@gmail.com",mensaje.getAsunto(),mensaje.getMensaje());
			return true;
		}
		
		else {
			return false;
		}
		
		
		
	}
	

}
