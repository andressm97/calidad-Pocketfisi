package proyecto.back.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import proyecto.back.dao.Cursos_MobilDAO;
import proyecto.back.entity.Cursos_Mobil;
import proyecto.back.rowmapper.Listar_cursos_mobilRowMapper;

@Transactional
@Repository
public class Cursos_MobilDaoImpl implements Cursos_MobilDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Cursos_Mobil> getListacursos(String dia) {
		
		String sql="select * from fn_listar_cursos_mobil(?);";
		RowMapper<Cursos_Mobil> rowMapper = new Listar_cursos_mobilRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper,dia);
	}

}
