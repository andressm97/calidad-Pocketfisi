package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Cursos;

public class Lista_cursosRowMapper implements RowMapper<Cursos>{

	@Override
	public Cursos mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cursos curso= new Cursos();
		curso.setCurso(rs.getString("curso"));
		curso.setCodigo(rs.getInt("codigo"));
		curso.setGrupo(rs.getString("grupo"));
		curso.setDia(rs.getString("dia"));
		
		
		return curso;
	}

}
