package proyecto.back.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.back.dao.IMensajeDAO;
import proyecto.back.entity.Mensaje;

@Transactional
@Repository

public class MensajeDaoImpl implements IMensajeDAO {
	
	@Autowired
	JdbcTemplate JdbcTemplate;
	@Override
	public boolean insertarMensaje(Mensaje mensaje) {
		// TODO Auto-generated method stub
		
		String sql="select fn_enviar_mensaje(?,?,?,?)";
		
		try {
			
			JdbcTemplate.queryForRowSet(sql,mensaje.getId_usuario(),mensaje.getAsunto(),mensaje.getMensaje(),mensaje.getId_perfil());
			return true;
			
			
		}catch (DataAccessException e) {
			
			System.out.println("error al  enviar mensaje : "+e.getMessage());
			return false;
		}
		
		
		
	}

	
}
