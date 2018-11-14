package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.INoticiaDAO;
import proyecto.back.entity.Noticia;

@Service
public class NoticiaService {
	@Autowired
	INoticiaDAO iNoticiaDAO;
	
	public List<Noticia> listarNoticias(){
		List<Noticia> lista=iNoticiaDAO.ListarNoticias();
		return lista;
	}
	
	public boolean agregarNoticia(Noticia noticia) {
		return iNoticiaDAO.agregarNoticia(noticia);
	}
	
	public Noticia noticiaByCodigo(int id) {
		return iNoticiaDAO.NoticiaByCodigo(id);
	}
	public boolean NoticiaDelete(int id) {
		return iNoticiaDAO.NoticiaDelete(id);
	}
	
	public boolean NoticiaEditar(int id,Noticia noticia) {
		return iNoticiaDAO.NoticiaEditar(id, noticia);
	}
}
