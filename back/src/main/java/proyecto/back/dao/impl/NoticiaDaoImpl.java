package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		Integer ret=0;
		String sql="insert into news (title,description,category,url,start,ending,imagen,id_state,id_user) values (?,?,?,?,?,?,?,?,?)";
		ret=JdbcTemplate.update(sql,n.getTitle(),n.getDescription(),n.getCategory(),n.getUrl(),n.getStart(),n.getEnding(),n.getImagen(),
				n.getId_state(),n.getId_users());
		
		
		if(ret.equals(1)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

}
