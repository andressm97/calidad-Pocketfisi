package proyecto.back.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import proyecto.back.dao.ILista_cursosDAO;
import proyecto.back.entity.Lista_cursos;
import proyecto.back.entity.CursosSUM;
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
	
	
	@Override
	public boolean agregar_listaCursos(List<CursosSUM> curso) {
		SqlRowSet ret = null;
		//int i=0;
		String sql="select fn_cursos_sum(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
		
		for(CursosSUM c: curso ){ 
		System.out.println("insert" +"curso : " + c.getCurso());
		
		
		ret=jdbcTemplate.queryForRowSet(sql,c.getId_programacion(),c.getDocente(),c.getCurso(),c.getCiclo(),
									c.getPlan(),c.getMatriculados(),c.getDia(),c.getH_inicio(),
									c.getH_fin(),c.getGrupo(),c.getClase(),c.getSiglas());
		
		}
		// TODO Auto-generated method stub
		
		
		} catch (DataAccessException e) {
			System.out.println("error :" + e.getMessage());
		}
		
		System.out.println(ret.getRow());
		
		if(ret!=null) {
			return true;
		}
		
		return false;
		
	}

}
