/**
 * Una empresa se dedica a montar eventos. 
 * Cada evento es de un tipo distinto. 
 * Los tipos de evento son: concierto, despedida, cumpleaños, boda…, 
 * y nos interesa un código que identifique cada evento junto con su descripción. 
 * A un evento se inscriben clientes, de los que debemos guardar el esquema SQL. 
 * Recuerda que un cliente puede apuntarse a más de un evento. 
 * 
 * Vamos a implementar el servlet GestionEventos.
 * Las páginas JSP necesarias para las tareas definidas a continuación.
 * La clase de Bean 'Evento' y 'Tipo', a partir de las tablas que tienes en este enunciado.
 * El interface llamado IntEventoDao de la clase 'Evento' con los métodos necesarios.
 * Una clase EventoDaoImpl, que contiene una lista de eventos con su tipo y la implementación de los métodos del interface.
 * 
 * Del servlet llamado GestionEventos tratamos las siguientes opciones:
 * “?opcion=activos” ->  Sacar el listado de la imagen superior.
 * “?opcion=alta: -> Mostrar un formulario con los datos del evento, poner el estado del evento como ‘activo’ y, si quieres destacarlo, poner una ‘s’ en su columna.
 * “?opcion=editar&id=x “ -> Mostrar en un JSP los datos del evento.
 * “?opcion=eliminar&id=x “ ->  Borrarlo de la clase que contiene los eventos y volver al listado de activos.
 * “?opcion=cancelar&id=x “ ->  Poner el estado del evento como cancelado, y volver al listado de activos.
 */
package modelo.daos;



import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.beans.Evento;


/**
 * @author Olga Bueno
 *
 */
public class EventoDaoImpl implements IntEventoDao {
	
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
		
		
		lista.add(new Evento(1,"Pepe y Maria","Catering al aire libre, banquete para 300 personas y barra libre",new GregorianCalendar(2022,2,14).getTime(),8,"Casa de campo","activo",'N',500,300,30000.00,iTipo.finById(4)));
		lista.add(new Evento(2,"Juan","Dbanquete para 100 personas",new GregorianCalendar(2022,5,25).getTime(),6,"Escorial","activo",'N',200,75,10000.00,iTipo.finById(1)));
		lista.add(new Evento(3,"Pepe y Maria","Catering al aire libre, banquete para 300 personas y barra libre",new GregorianCalendar(2022,2,14).getTime(),8,"Casa de campo","activo",'N',500,300,30000.00,iTipo.finById(4)));
		lista.add(new Evento(4,"Juan","Dbanquete para 100 personas",new GregorianCalendar(2022,5,25).getTime(),6,"Escorial","activo",'N',200,75,10000.00,iTipo.finById(5)));

	}
	/**
	 * Encontrar Evento por id
	 * @param idEvento
	 * @return the Evento
	 */
	@Override
	public Evento finById(int idEvento) {
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
	 * Devolver la lista de Evento
	 * @return the lista
	 */
	@Override
	public List<Evento> findAll() {
		return lista;
	}
	/**
	 * Inserta nuevo evento a la lista
	 * @param evento
	 * @return int
	 */
	@Override
	public int alta(Evento evento) {
		if (lista.contains(evento))
			return 0;
		else
			return lista.add(evento)?1:0;
	}
	/**
	 * Modificar Evento
	 * @param Evento
	 * @return int
	 */
	@Override
	public int editar(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, evento) != null)?1:0;
	}
	/**
	 * Eliminar evento de la lista
	 * @param evento
	 * @return int
	 */
	@Override
	public int eliminar(Evento evento) {
		return lista.remove(evento)?1:0;
	}
	/**
	 * Eliminar tipo de la lista por idTipo
	 * @param idTipo
	 * @return int
	 */
	@Override
	public int eliminar(int idEvento) {
		Evento aux=new Evento();
		aux= finById (idEvento);
		return lista.remove(aux)?1:0;
	}
	/**
	 * Modificar Evento para que aparezca cancelado
	 * @param Evento
	 * @return int
	 */
	@Override
	public int cancelar(int idEvento) {
		Evento aux=new Evento();
		aux= finById (idEvento);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return 0;
		}else {
			aux=lista.get(pos);
			aux.setEstado("cancelado");
			return (lista.set(pos, aux) != null)?1:0;
		}
	}
	/**
	 * Devuelve el ultimo id de la lista
	 * @return
	 */
	@Override
	public int ultimoId() {
		Evento aux=new Evento();
		aux=lista.get(lista.size()-1);
		return aux.getIdEvento();
		
	}
}
