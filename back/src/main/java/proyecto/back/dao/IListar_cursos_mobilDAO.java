package proyecto.back.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import proyecto.back.entity.Listar_cursos_mobil;

@Repository
public interface IListar_cursos_mobilDAO {
		
	List<Listar_cursos_mobil> getListacursos(String dia);
}
