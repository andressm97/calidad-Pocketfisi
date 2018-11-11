package proyecto.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import proyecto.back.dao.IMensajeDAO;
import proyecto.back.entity.Mensaje;

@Service
public class SendMailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private IMensajeDAO mensajeDAO;
	
	public void sendMail(String from,String to,String subject,String body) {
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		javaMailSender.send(mailMessage);
	}
	
	public boolean insertarMensaje(Mensaje mensaje) {
		
		return mensajeDAO.insertarMensaje(mensaje);
		
	}
	
	

}
