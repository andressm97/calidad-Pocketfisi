package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import proyecto.back.dao.INoticiaDAO;
import proyecto.back.entity.Noticia;
import proyecto.back.rowmapper.NoticiaRowMapper;


@Transactional
@Repository
public class NoticiaDaoImpl implements INoticiaDAO {
	@Autowired
	JdbcTemplate JdbcTemplate;
	@Override
	public List<Noticia> ListarNoticias() {
		
		String sql= "select * from news";
		RowMapper<Noticia> noticia= new NoticiaRowMapper();
		
		return this.JdbcTemplate.query(sql, noticia);
	}
	
	
	@Override
	public boolean agregarNoticia(Noticia n) {
		String sql="select fn_crear_noticia(?,?,?,?,?,?);";
		
		try {
		
		JdbcTemplate.queryForRowSet(sql,n.getTitle(),n.getDescription(),n.getCategory(),n.getUrl(),n.getImagen(),n.getId_users());
		return true;
		
		}catch (DataAccessException e) {
			System.out.println("error al agregar noticia"+ e.getMessage());
		
		return false;
		}
		
		
		
		
	}

}
