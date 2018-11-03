package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Delegado;

public class DelegadoRowMapper implements RowMapper<Delegado> {

	@Override
	public Delegado mapRow(ResultSet rs, int rowNum) throws SQLException {
		Delegado delegado=new Delegado();
		delegado.setId_programming(rs.getInt("id_programming"));
		delegado.setId_user(rs.getString("id_user"));
		
		return delegado;
	}
		
		
	
}
