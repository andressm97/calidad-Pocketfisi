package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Listar_cursos_mobil;

public class Listar_cursos_mobilRowMapper implements RowMapper<Listar_cursos_mobil> {

	@Override
	public Listar_cursos_mobil mapRow(ResultSet rs, int rowNum) throws SQLException {
		Listar_cursos_mobil cursos = new Listar_cursos_mobil();
		cursos.setSeccion(rs.getString("seccion"));
		cursos.setCurso(rs.getString("curso"));
		cursos.setProfesor(rs.getString("profesor"));
		cursos.setEstado(rs.getString("estado"));
		cursos.setInicio(rs.getInt("inicio"));
		cursos.setFin(rs.getInt("fin"));
		cursos.setTipo(rs.getString("tipo"));
		cursos.setCiclo(rs.getInt("ciclo"));
		
		
				
		
		return cursos;
	}
	
	

}
