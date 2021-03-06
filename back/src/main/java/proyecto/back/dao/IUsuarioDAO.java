package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Usuario;

public interface IUsuarioDAO {
	
	List<Usuario> getListaUsuarios();
	
	boolean agregarUsuario(Usuario usuario);
	//void actualizarUsuario(Usuario usuario);
	//void eliminarUsuario(String id_usuario);
	boolean getIdUsuario(String id_user);
	
	Usuario getUsuarioWebByUsername(String username,String password);
	
	Usuario mostrarUsuario(String username,String pasword); 
	
	boolean UsuarioCambioPass(String userame,String oldpas,String newpas);
		
	

}
