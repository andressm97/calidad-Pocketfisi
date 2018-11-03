package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Cursos_delegado;

public class Cursos_delegadoRowMapper implements RowMapper<Cursos_delegado>{

	@Override
	public Cursos_delegado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cursos_delegado cursos_delegado=new Cursos_delegado();
		cursos_delegado.setCodigo(rs.getInt("codigo"));
		cursos_delegado.setCurso(rs.getString("curso"));
		cursos_delegado.setProfesor(rs.getString("profesor"));
		
		
		return cursos_delegado;
	}

}
