package proyecto.back.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import proyecto.back.entity.Cursos_Mobil;

@Repository
public interface Cursos_MobilDAO {
		
	List<Cursos_Mobil> getListacursos(String dia);
}
