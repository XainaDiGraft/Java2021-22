package modelo.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.beans.Tipo;

public class TipoDaoImplList implements IntTipoDao, Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private List<Tipo> lista;
	
	public TipoDaoImplList() {
		lista = new ArrayList<Tipo>();
		cargar();
	}
	
	
	private void cargar() {
		lista.add(new Tipo(1, "Boda", "exterior o interior minimo 30 pax"));
		lista.add(new Tipo(2, "Concierto", "exterior o interior minimo 100 pax"));
		
	}


	@Override
	public List<Tipo> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}


	@Override
	public int addTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		if (!lista.contains(tipo)) {
			lista.add(tipo);
			return 1;
		}
		return 0;
	}


	@Override
	public Tipo findById(int idTipo) {
		Tipo tipo = new Tipo();
		tipo.setIdTipo(idTipo);
		int pos = lista.indexOf(tipo);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

}
