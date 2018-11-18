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
import proyecto.back.entity.Noticia2;
import proyecto.back.rowmapper.NoticiaRowMapper;


@Transactional
@Repository
public class NoticiaDaoImpl implements INoticiaDAO {
	@Autowired
	JdbcTemplate JdbcTemplate;
	@Override
	public List<Noticia2> ListarNoticias() {
		
		String sql= "select id_news,title,description,category,url,start,ending,id_state,id_user,direction from news";
		RowMapper<Noticia2> noticia= new NoticiaRowMapper();
		
		return this.JdbcTemplate.query(sql, noticia);
	}
	
	
	
	@Override
	public boolean agregarNoticia(Noticia2 n,byte [] img) {
		String sql="select fn_crear_noticia(?,?,?,?,?,?,?);";
		//direccion desde donde se leen las imagenes en el servidor
		String direccion="https://calidad-pf.herokuapp.com/noticias/imagen";
		try {
		
		String codigo=JdbcTemplate.queryForObject(sql,new Object[] {n.getTitle(),n.getDescription(),n.getCategory(),n.getUrl(),img,direccion,n.getId_user()},String.class);
		
		System.out.println("codigo de la noticia insertada :" +codigo);
		return true;
		
		}catch (DataAccessException e) {
			System.out.println("error al agregar noticia"+ e.getMessage());
		
		return false;
		}
		
		
		
		
	}


	@Override
	public Noticia2 NoticiaByCodigo(int id) {
		String sql="select id_news,title,description,category,url,start,ending,id_state,id_user,direction from news where id_news=?";
		RowMapper<Noticia2> rowMapper = new BeanPropertyRowMapper<Noticia2>(Noticia2.class);
		Noticia2 noticia=  JdbcTemplate.queryForObject(sql, rowMapper,id);
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
