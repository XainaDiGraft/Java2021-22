/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.beans.Evento;
import com.ite.eventos.modelo.beans.Reserva;

/**
 * @author Olga Bueno
 *
 */
@Repository 
public class ReservaDaoImpl implements IntReservaDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Reserva> lista;
	
	/**
	 * Constructor
	 * Crea un array de objetos reserva y carga los datos en el array 
	 */
	public ReservaDaoImpl() {
		lista = new ArrayList<Reserva>();
		cargarDatos();
	}
	/**
	 * funcion con los distintos elementos de objetos Evento
	 */
	
	private void cargarDatos() {
		IntEventoDao iEvento=new EventoDaoImpl();
		IntUsuariosDao iUsuario=new UsuarioDaoImpl();
		
		lista.add(new Reserva(1,iEvento.findById(3),iUsuario.findById(2),15.5,"",1));
		lista.add(new Reserva(1,iEvento.findById(2),iUsuario.findById(1),40.00,"",2));
		
	}
	public void setLista(List<Reserva> lista) {
		this.lista = lista;
	}
	/**
	 * Encontrar Reserva por id
	 * @param idReserva
	 * @return Reserva
	 */
	@Override
	public Reserva findById(int idReserva) {
		Reserva aux=new Reserva();
		aux.setIdReserva(idReserva);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else {
			return lista.get(pos);
		}
	}
	/**
	 * Encontrar Reserva por evento
	 * @param idEvento
	 * @return List<Reserva>
	 */
	@Override
	public List<Reserva> findAllByEvento(int idEvento){
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva ele: lista) {
			if (ele.getEvento().getIdEvento()==(idEvento))
				aux.add(ele);
		}
		return aux;
	}
	/**
	 * Encontrar Reserva por usuario
	 * @param idUsuario
	 * @return List<Reserva>
	 */
	@Override
	public List<Reserva> findAllByUsuario(int idUsuario){
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva ele: lista) {
			if (ele.getUsuario().getIdUsuario()==(idUsuario))
				aux.add(ele);
		}
		return aux;
	}
	/**
	 * Devolver la lista de Reserva
	 * @return List<Reserva>
	 */
	@Override
	public List<Reserva> findAll() {
		return lista;
	}
	/**
	 * Inserta nueva Reserva a la lista
	 * @param reserva
	 * @return int
	 */
	@Override
	public int alta(Reserva reserva) {
		if (!lista.contains(reserva)) {
			int ultId=ultimoId();
			reserva.setIdReserva(++ultId);
			lista.add(reserva);
			return 1;
		}
		return 0;
	}
	/**
	 * Modificar Reserva
	 * @param reserva
	 * @return int
	 */
	@Override
	public int modUsuario(Reserva reserva) {
		int pos = lista.indexOf(reserva);
		if (pos != -1) {
			lista.set(pos, reserva);
			return 1;
		}
		return 0;
	}
	/**
	 * Eliminar reserva de la lista por idReserva
	 * @param idReserva
	 * @return int
	 */
	@Override
	public int eliminar(int idReserva) {
		Reserva aux=new Reserva();
		aux.setIdReserva(idReserva);
		int pos = lista.indexOf(aux);
		aux= findById (idReserva);
		return (lista.remove(pos) != null)? 1 : 0;
	}
	/**
	 * Devuelve el ultimo id de la lista
	 * @return int
	 */
	@Override
	public int ultimoId() {
		Reserva aux=new Reserva();
		aux=lista.get(lista.size()-1);
		return aux.getIdReserva();
	}
	@Override
	public int plazasLib(Evento evento) {
		int plazasOcupadas=0;
		List<Reserva> lista = findAllByEvento(evento.getIdEvento());
		for(Reserva ele: lista) {
			plazasOcupadas= plazasOcupadas + ele.getCantidad();
		}
		return evento.getAforoMaximo()- plazasOcupadas;
	}

}
