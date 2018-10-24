package proyecto.back.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import proyecto.back.dao.ILista_cursosDAO;
import proyecto.back.entity.Lista_cursos;
import proyecto.back.rowmapper.Lista_cursosRowMapper;

@Transactional
@Repository
public class Lista_cursosDaoImpl implements ILista_cursosDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Lista_cursos> getListaCurso() {
		
		String sql="select * from fn_listar_cursos()";
		
		RowMapper<Lista_cursos> rowmapper= new Lista_cursosRowMapper();
		
		return this.jdbcTemplate.query(sql,rowmapper);
	}

}
