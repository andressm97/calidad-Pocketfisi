package proyecto.back.dao;

import java.util.List;

import proyecto.back.entity.Suscriptores;

public interface ISuscriptoresDAO {
	
	List<Suscriptores> getSuscriptores(int id_programa);
	

}
