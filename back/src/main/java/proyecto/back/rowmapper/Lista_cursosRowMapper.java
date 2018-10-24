package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Lista_cursos;

public class Lista_cursosRowMapper implements RowMapper<Lista_cursos>{

	@Override
	public Lista_cursos mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Lista_cursos curso= new Lista_cursos();
		curso.setCurso(rs.getString("curso"));
		curso.setCodigo(rs.getInt("codigo"));
		curso.setGrupo(rs.getString("grupo"));
		curso.setDia(rs.getInt("dia"));
		
		
		return curso;
	}

}
