package proyecto.back.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import proyecto.back.dao.IListar_cursos_mobilDAO;
import proyecto.back.entity.Listar_cursos_mobil;
import proyecto.back.rowmapper.Listar_cursos_mobilRowMapper;

@Transactional
@Repository
public class Listar_cursos_mobilDaoImpl implements IListar_cursos_mobilDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Listar_cursos_mobil> getListacursos(String dia) {
		
		String sql="select * from fn_listar_cursos_mobil(?);";
		RowMapper<Listar_cursos_mobil> rowMapper = new Listar_cursos_mobilRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper,dia);
	}

}
