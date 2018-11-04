package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.IPerfilDAO;
import proyecto.back.entity.Perfil;

@Service
public class PerfilService {
	@Autowired
	IPerfilDAO iPerfilDAO;
	
	public List<Perfil> listarPerfil(){
		List<Perfil> lista=iPerfilDAO.listarPerfil();
		return lista;
	}
	
	
}
