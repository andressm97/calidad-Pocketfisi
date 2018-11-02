package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario= new Usuario();
		
		usuario.setId_user(rs.getString("id_user"));
		usuario.setName(rs.getString("name"));
		usuario.setLastname(rs.getString("lastname"));
		usuario.setUsername(rs.getString("username"));
		usuario.setPassword(rs.getString("password"));
		usuario.setMobile(rs.getString("mobile"));
		usuario.setId_profile(rs.getString("id_profile"));
		usuario.setDelegate(rs.getInt("delegate"));
		
		return usuario;
	}

}
