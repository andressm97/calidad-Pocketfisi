package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.back.dao.IDelegadoDAO;
import proyecto.back.entity.Cursos_delegado;
import proyecto.back.entity.Delegado;
import proyecto.back.rowmapper.Cursos_delegadoRowMapper;
import proyecto.back.rowmapper.DelegadoRowMapper;

@Transactional
@Repository
public class DelegadoDaoImpl implements IDelegadoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Cursos_delegado> mostrarcursos(String codigo, int hora) {
		
		String sql="select * from fn_llamar_soporte(?,?)";
		RowMapper<Cursos_delegado> rowMapper= new Cursos_delegadoRowMapper();
		return jdbcTemplate.query(sql, rowMapper,codigo,hora);
	}

	@Override
	public List<Delegado> cursosDelegado(String codigo) {
		
		String sql="select * from delegates where id_user=?";
		RowMapper<Delegado>rowMapper=new DelegadoRowMapper();
		
		return jdbcTemplate.query(sql,rowMapper,codigo);
	}

}
