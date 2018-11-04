package proyecto.back.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyecto.back.dao.IPerfilDAO;
import proyecto.back.entity.Perfil;
import proyecto.back.rowmapper.PerfilRowMapper;

@Transactional
@Repository
public class PerfilDaoImpl implements IPerfilDAO{

	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public List<Perfil> listarPerfil() {
		String sql="select * from profiles";
		RowMapper<Perfil>rowMapper = new PerfilRowMapper();
		
		return this.JdbcTemplate.query(sql,rowMapper);
	}

}
