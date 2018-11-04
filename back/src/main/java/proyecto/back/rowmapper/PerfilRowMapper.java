package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Perfil;

public class PerfilRowMapper implements RowMapper<Perfil>{

	@Override
	public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
		Perfil p= new Perfil();
		p.setId_profile(rs.getString("id_profile"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		return p;
	}
	

}
