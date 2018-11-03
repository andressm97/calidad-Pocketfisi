package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.back.dao.IUsuarioDAO;
import proyecto.back.entity.Usuario;
import proyecto.back.rowmapper.UsuarioRowMapper;

@Transactional
@Repository
public class UsuarioDaoImpl implements IUsuarioDAO{
	@Autowired
	private JdbcTemplate JdbcTemplate;
		
	@Override
	public List<Usuario> getListaUsuarios() {
		 
		String sql="select * from users";
		RowMapper<Usuario> rowMapper = new UsuarioRowMapper();
		return JdbcTemplate.query(sql, rowMapper);
	}
	
	
	
	
	
	@Override
	public boolean agregarUsuario(Usuario usuario) {
		Integer ret=0;
		String sql="";
		if(usuario.getToQuery()) {
		System.out.println("insert");
		sql="insert into users (id_user,name,lastname,username,password,mobile,id_profile) values (?,?,?,?,?,?,?)";
		ret=JdbcTemplate.update(sql,usuario.getId_user(),usuario.getName(),usuario.getLastname(),usuario.getUsername(),usuario.getPassword(),usuario.getMobile(),usuario.getId_profile());
		
		}
		else {
			System.out.println("update");
			sql="UPDATE users SET name=?,lastname=?,username=?,password=?,mobile=?,id_profile=? where id_user=?";
			ret=JdbcTemplate.update(sql,usuario.getName(),usuario.getLastname(),usuario.getUsername(),usuario.getPassword(),usuario.getMobile(),usuario.getId_profile(),usuario.getId_user());
		}
		
		System.out.println("respuesta sql"+ret);
		
		
		
		
		if(ret.equals(1)) {
			return true;
		}
		
		else {
			return false;
		}
		
		
		
	}


	@Override
	public boolean getIdUsuario(String id_user) {
		
		try {	
	
				String sql= "select id_user from users where id_user= ?";
				
				String ret=JdbcTemplate.queryForObject(sql,new Object[] {id_user},String.class);
				System.out.println("ret"+ret.length());
			if(ret.length()>0) {
				System.out.println("return true");
				return true;
			}
			else {
				System.out.println("return false");
				return false;
			}
		
		}
		catch(DataAccessException e) {
			System.out.println("errror "+ e.getMessage());
					return false;
		}
		
		
		
		
	}

}
