package proyecto.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.back.dao.INoticiaDAO;
import proyecto.back.entity.Noticia;
import proyecto.back.entity.Noticia2;

@Service
public class NoticiaService {
	@Autowired
	INoticiaDAO iNoticiaDAO;
	
	public List<Noticia2> listarNoticias(){
		List<Noticia2> lista=iNoticiaDAO.ListarNoticias();
		return lista;
	}
	
	public boolean agregarNoticia(Noticia2 n,byte [] img) {
		return iNoticiaDAO.agregarNoticia(n,img);
	}
	
	public Noticia2 noticiaByCodigo(int id) {
		return iNoticiaDAO.NoticiaByCodigo(id);
	}
	public boolean NoticiaDelete(int id) {
		return iNoticiaDAO.NoticiaDelete(id);
	}
	
	public boolean NoticiaEditar(int id,Noticia noticia) {
		return iNoticiaDAO.NoticiaEditar(id, noticia);
	}
	public byte[] ImgNoticia(int id) {
		
		return iNoticiaDAO.ImagenNoticia(id);
	}
}
