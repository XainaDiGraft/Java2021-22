/**
 * Una empresa se dedica a montar eventos. 
 * Cada evento es de un tipo distinto. 
 * Los tipos de evento son: concierto, despedida, cumplea�os, boda�, 
 * y nos interesa un c�digo que identifique cada evento junto con su descripci�n. 
 * A un evento se inscriben clientes, de los que debemos guardar el esquema SQL. 
 * Recuerda que un cliente puede apuntarse a m�s de un evento. 
 * 
 * Vamos a implementar el servlet GestionEventos.
 * Las p�ginas JSP necesarias para las tareas definidas a continuaci�n.
 * La clase de Bean 'Evento' y 'Tipo', a partir de las tablas que tienes en este enunciado.
 * El interface llamado IntEventoDao de la clase 'Evento' con los m�todos necesarios.
 * Una clase EventoDaoImpl, que contiene una lista de eventos con su tipo y la implementaci�n de los m�todos del interface.
 * 
 * Del servlet llamado GestionEventos tratamos las siguientes opciones:
 * �?opcion=activos� ->  Sacar el listado de la imagen superior.
 * �?opcion=alta: -> Mostrar un formulario con los datos del evento, poner el estado del evento como �activo� y, si quieres destacarlo, poner una �s� en su columna.
 * �?opcion=editar&id=x � -> Mostrar en un JSP los datos del evento.
 * �?opcion=eliminar&id=x � ->  Borrarlo de la clase que contiene los eventos y volver al listado de activos.
 * �?opcion=cancelar&id=x � ->  Poner el estado del evento como cancelado, y volver al listado de activos.
 */
package com.ite.eventos.modelo.repository;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.beans.Evento;


/**
 * @author Olga Bueno
 *
 */
@Repository 
public class EventoDaoImpl implements IntEventoDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Evento> lista;
	
	/**
	 * Constructor
	 * Crea un array de objetos evento y carga los datos en el array
	 */
	public EventoDaoImpl() {
		lista = new ArrayList<Evento>();
		cargarDatos();
	}
	
	/**
	 * funcion con los distintos elementos de objetos Evento
	 */
	
	private void cargarDatos() {
	
		IntTipoDao iTipo=new TipoDaoImpl();
		
		
		lista.add(new Evento(1,"Pepe y Maria","Catering al aire libre, banquete para 300 personas y barra libre",new GregorianCalendar(2022,2,14).getTime(),8,"Casa de campo","activo","N",500,300,200.00,iTipo.findById(4)));
		lista.add(new Evento(2,"Juan","Dbanquete para 100 personas",new GregorianCalendar(2022,5,25).getTime(),6,"Escorial","cancelado","S",200,75,20.00,iTipo.findById(1)));
		lista.add(new Evento(3,"Pepe y Maria","Catering al aire libre, banquete para 300 personas y barra libre",new GregorianCalendar(2022,2,14).getTime(),8,"Casa de campo","finalizado","N",500,300,250.00,iTipo.findById(4)));
		lista.add(new Evento(4,"Juan","Dbanquete para 100 personas",new GregorianCalendar(2022,5,25).getTime(),6,"Escorial","activo","N",200,75,100.00,iTipo.findById(5)));

	}
	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}
	/**
	 * LISTA DE EVENTOS SEGUN ESTADO ELEGIDO
	 * @param estado
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> findAllByEstado(String estado) {
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento ele: lista) {
			if (ele.getEstado().equals(estado))
				aux.add(ele);
		}
		return aux;
	}
	/**
	 * Inserta nuevo evento a la lista
	 * @param evento
	 * @return int
	 */
	@Override
	public int alta(Evento evento) {
		if (!lista.contains(evento)) {
			int ultId=ultimoId();
			evento.setIdEvento(++ultId);
			lista.add(evento);
			return 1;
		}
		return 0;
	}
	/**
	 * Modificar Evento
	 * @param evento
	 * @return int
	 */
	@Override
	public int modEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos != -1) {
			lista.set(pos, evento);
			return 1;
		}
		return 0;			
	}
	/**
	 * Eliminar evento de la lista por idEvento
	 * @param idEvento
	 * @return int
	 */
	@Override
	public int eliminar(int idEvento) {
		Evento aux=new Evento();
		aux.setIdEvento(idEvento);
		int pos = lista.indexOf(aux);
		aux= findById (idEvento);
		return (lista.remove(pos) != null)? 1 : 0;
	}
	/**
	 * MODIFICAR ESTADO POR ID
	 * @param idEvento
	 * @param estado
	 * return 
	 */
	@Override
	public int modificarEstadoEvento(int idEvento, String estado) {
		Evento evento = findById(idEvento);
		evento.setEstado(estado);
		return 1;
	}
	/**
	 * Devolver la lista de Evento
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> findAll() {
		return lista;
	}
	
	/**
	 * LISTA DE EVENTOS DESTACADOS
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> findByDestacado() {
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento ele: lista) {
			if (ele.getDestacado().equals("S"))
				aux.add(ele);
		}
		return aux;
	}
	/**
	 * Encontrar Evento por id
	 * @param idEvento
	 * @return Evento
	 */
	@Override
	public Evento findById(int idEvento) {
		Evento aux=new Evento();
		aux.setIdEvento(idEvento);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else {
			return lista.get(pos);
		}
	}
	/**
	 * Devuelve el ultimo id de la lista
	 * @return int
	 */
	@Override
	public int ultimoId() {
		Evento aux=new Evento();
		aux=lista.get(lista.size()-1);
		return aux.getIdEvento();
		
	}

	

	
}
