package proyecto.back.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		
		JdbcTemplate.queryForRowSet(sql,n.getTitle(),n.getDescription(),n.getCategory(),n.getUrl(),n.getImg(),n.getId_user());
		return true;
		
		}catch (DataAccessException e) {
			System.out.println("error al agregar noticia"+ e.getMessage());
		
		return false;
		}
		
		
		
		
	}


	@Override
	public Noticia NoticiaByCodigo(int id) {
		String sql="select * from news where id_news=?";
		RowMapper<Noticia> rowMapper = new BeanPropertyRowMapper<Noticia>(Noticia.class);
		Noticia noticia=  JdbcTemplate.queryForObject(sql, rowMapper,id);
		return noticia;
	}


	@Override
	public boolean NoticiaDelete(int id) {
		Integer ret=0;
		String sql="Delete from news where id_news=?";
		
		ret=JdbcTemplate.update(sql,id);
		
		if(ret.equals(1)) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public boolean NoticiaEditar(int id,Noticia noticia) {
		String sql="Update News set title=?,description=?,category=?,url=?,ending=?,imagen=?,id_state='3',id_user=?" + 
				"where id_news=?";
		Integer ret=0;
		ret=JdbcTemplate.update(sql,noticia.getTitle(),noticia.getDescription(),noticia.getCategory(),noticia.getUrl(),
				noticia.getEnding(),noticia.getImg(),noticia.getId_user(),id);
		
		if(ret.equals(1)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}



	@Override
	public byte[] ImagenNoticia(int id) {
		String sql="select img  from news where id_news=?";
		
		try {
			
		
		List<Map<String, Object>> result = JdbcTemplate.queryForList(sql,id);
		if (!result.isEmpty()) {
			
			byte[] bytes = (byte[]) result.get(0).get("img");
		    //return IOUtils.toByteArray(in);
		    return bytes;
		}
		
		}catch (Exception e) {
			System.out.println("error al leer imagen : "+e.getMessage());
			
		}
		return null;
		
	}

}
