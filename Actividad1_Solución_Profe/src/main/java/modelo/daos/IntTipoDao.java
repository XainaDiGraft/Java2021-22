package modelo.daos;

import java.util.List;

import modelo.beans.Tipo;

public interface IntTipoDao {
	
	List<Tipo> findAll();
	int addTipo(Tipo tipo);
	Tipo findById(int idTipo);

}
