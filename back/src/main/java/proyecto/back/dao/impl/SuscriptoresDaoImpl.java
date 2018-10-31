package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.back.dao.ISuscriptoresDAO;
import proyecto.back.entity.Suscriptores;
import proyecto.back.rowmapper.SuscriptoresRowMapper;

@Transactional
@Repository
public class SuscriptoresDaoImpl implements  ISuscriptoresDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Suscriptores> getSuscriptores(int id_programa) {
		
		String sql="select * from fn_listar_alumnos(?);";
		RowMapper<Suscriptores> rowMapper= new SuscriptoresRowMapper();
		
		return this.jdbcTemplate.query(sql, rowMapper,id_programa);
	}

}
