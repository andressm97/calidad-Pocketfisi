package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Cursos_Mobil;

public class Listar_cursos_mobilRowMapper implements RowMapper<Cursos_Mobil> {

	@Override
	public Cursos_Mobil mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cursos_Mobil cursos = new Cursos_Mobil();
		cursos.setSeccion(rs.getString("seccion"));
		cursos.setCurso(rs.getString("curso"));
		cursos.setProfesor(rs.getString("profesor"));
		cursos.setEstado(rs.getString("estado"));
		cursos.setInicio(rs.getInt("inicio"));
		cursos.setFin(rs.getInt("fin"));
		cursos.setTipo(rs.getString("tipo"));
		cursos.setCiclo(rs.getInt("ciclo"));
		cursos.setSalon(rs.getString("salon"));
		
		
				
		
		return cursos;
	}
	
	

}
