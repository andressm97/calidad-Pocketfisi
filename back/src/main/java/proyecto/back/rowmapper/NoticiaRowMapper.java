package proyecto.back.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyecto.back.entity.Noticia;
import proyecto.back.entity.Noticia2;

public class NoticiaRowMapper implements RowMapper<Noticia2> {

	@Override
	public Noticia2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Noticia2 n=new Noticia2();
		n.setId_news(rs.getInt("id_news"));
		n.setTitle(rs.getString("title"));
		n.setDescription(rs.getString("description"));
		n.setCategory(rs.getString("category"));
		n.setUrl(rs.getString("url"));
		n.setStart(rs.getDate("start"));
		n.setEnding(rs.getDate("ending"));
		n.setId_state(rs.getInt("id_state"));
		n.setId_user(rs.getString("id_user"));
		n.setDirection(rs.getString("direction"));
		return n;
	}

}
