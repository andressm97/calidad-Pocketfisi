package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Noticia;
import proyecto.back.entity.Noticia2;

public interface INoticiaDAO {
	
	List<Noticia2> ListarNoticias();	
	boolean agregarNoticia(Noticia2 noticia, byte [] img);
	
	Noticia2 NoticiaByCodigo(int id);
	boolean NoticiaDelete(int id);
	boolean NoticiaEditar(int id,Noticia noticia);
	
	byte[] ImagenNoticia(int id);
	
	
}
