package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.IUsuarioDAO;
import proyecto.back.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	public List<Usuario> ListarUsuarios(){
		List<Usuario> lista= usuarioDAO.getListaUsuarios();
		return lista;
		
	}
	
	public  boolean agregarUsuario(Usuario usuario) {
		//usuarioDAO.agregarUsuario(usuario);
		return usuarioDAO.agregarUsuario(usuario);
	}
	
	public boolean getIdUsuario(String id_user) {
		return usuarioDAO.getIdUsuario(id_user);
	}
	public Usuario MostrarUsuario(String username,String password) {
		
		Usuario usuario =usuarioDAO.mostrarUsuario(username, password);
		return usuario;
	}
	
	
	
	

}
