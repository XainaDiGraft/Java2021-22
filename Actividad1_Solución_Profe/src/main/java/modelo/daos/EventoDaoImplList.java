package modelo.daos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.beans.Evento;

public class EventoDaoImplList implements IntEventoDao, Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private List<Evento> lista;
	private static int idEventoAuto;
	
	public EventoDaoImplList() {
		lista = new ArrayList<Evento>();
		cargar();
	}
	
	private void cargar() {
		
		IntTipoDao tdao = new TipoDaoImplList();
		
		lista.add(new Evento(1, "BODA DE FRANCISCO GARCIA", "BODA MINIMA", new Date(), 72, "C. de Hortaleza, 63, 28004 Madrid", "cancelado", "s", 50, 25, 99.99, tdao.findById(1)));
		lista.add(new Evento(2, "BODA DE FRANCISCO SANCHEZ", "BODA MAXIMA", new Date(), 72, "C. de Hortaleza, 63, 28004 Madrid", "ACTIVO", "s", 50, 25, 99.99, tdao.findById(1)));
		lista.add(new Evento(3, "BODA DE FRANCISCO ZOILO", "BODA TOP", new Date(), 72, "C. de Hortaleza, 63, 28004 Madrid", "ACTIVO", "n", 50, 25, 99.99, tdao.findById(1)));
		lista.add(new Evento(4, "BODA DE FRANCISCO TARREGA", "BODA SUPER", new Date(), 72, "C. de Hortaleza, 63, 28004 Madrid", "ACTIVO", "n", 50, 25, 99.99, tdao.findById(1)));
		
		idEventoAuto=4;
	}
	
	

	

	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}

	@Override
	public List<Evento> findAllByEstado(String estado) {
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento ele: lista) {
			if (ele.getEstado().equals(estado))
				aux.add(ele);
		}
		return aux;
	}

	@Override
	public int addEvento(Evento evento) {
		if (!lista.contains(evento)) {
			evento.setIdEvento(++idEventoAuto);
			lista.add(evento);
			
			return 1;
		}
		return 0;
	}

	@Override
	public int modEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos != -1) {
			lista.set(pos, evento);
			return 1;
		}
		return 0;
		
	}

	@Override
	public int delEvento(int idEvento) {
		Evento evento = new Evento();
		evento.setIdEvento(idEvento);
		int pos = lista.indexOf(evento);
		return (lista.remove(pos) != null)? 1 : 0;
	}

	@Override
	public int modificarEstadoEvento(int idEvento, String estado) {
		Evento evento = findById(idEvento);
		evento.setEstado(estado);
		return 1;
		
	}

	@Override
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Evento> findByDetacado() {
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento ele: lista) {
			if (ele.getDestacado().equals("s"))
				aux.add(ele);
		}
		return aux;
	}

	@Override
	public Evento findById(int idEvento) {
		Evento evento = new Evento();
		evento.setIdEvento(idEvento);
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}
	
	

}
