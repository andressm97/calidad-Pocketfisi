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
	
}
