package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Noticia;

public interface INoticiaDAO {
	
	List<Noticia> ListarNoticias();	
	boolean agregarNoticia(Noticia noticia);

}
