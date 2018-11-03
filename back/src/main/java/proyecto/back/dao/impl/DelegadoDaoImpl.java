package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.back.dao.IDelegadoDAO;
import proyecto.back.entity.Cursos_delegado;
import proyecto.back.entity.Delegado;
import proyecto.back.entity.Hora;
import proyecto.back.rowmapper.DelegadoRowMapper;

@Transactional
@Repository
public class DelegadoDaoImpl implements IDelegadoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Cursos_delegado mostrarcursos(String codigo, int hora) {
		
		try {
		String sql="select * from fn_llamar_soporte(?,?) LIMIT 1";
		RowMapper<Cursos_delegado> rowMapper= new BeanPropertyRowMapper<Cursos_delegado>(Cursos_delegado.class);
		Cursos_delegado curso=jdbcTemplate.queryForObject(sql,rowMapper,codigo,hora);
		return  curso;
		}
		catch(DataAccessException e) {
			System.out.println("errror : "+ e.getMessage());
			return new Cursos_delegado();
		}
	}

	@Override
	public List<Delegado> cursosDelegado(String codigo) {
		
		String sql="select * from delegates where id_user=?";
		RowMapper<Delegado>rowMapper=new DelegadoRowMapper();
		
		return jdbcTemplate.query(sql,rowMapper,codigo);
	}

	@Override
	public Hora horaAactual() {
		try {
		String sql="select * from extract(hour from  (SELECT NOW() )) AS hora,extract(minute from  (SELECT NOW() )) AS minutos;";
		RowMapper<Hora> rowMapper= new BeanPropertyRowMapper<Hora>(Hora.class);
		Hora curso=jdbcTemplate.queryForObject(sql,rowMapper);
		return curso;
		}catch(DataAccessException e) {
			
			System.out.println("errrorhora : "+ e.getMessage());
			return new Hora();
		}
		
		
		
		
	
	}

}
