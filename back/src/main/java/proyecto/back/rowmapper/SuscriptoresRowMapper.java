package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Suscriptores;

public class SuscriptoresRowMapper implements RowMapper<Suscriptores>{

	@Override
	public Suscriptores mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 Suscriptores subs=new Suscriptores();
		 subs.setCodigo(rs.getString("codigo"));
		
		return subs;
	}

}
