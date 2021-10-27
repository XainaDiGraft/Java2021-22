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
import java.util.List;
import modelo.beans.Tipo;

/**
 * @author Olga Bueno
 *
 */
public class TipoDaoImpl implements IntTipoDao {
	private List<Tipo> lista;

	/**
	 * Constructor
	 * Crea un array de objetos tipo y carga los datos en el array
	 */
	public TipoDaoImpl() {
		lista = new ArrayList<Tipo>();
		cargarDatos();
	}
	/**
	 * funcion con los distintos elementos de objetos Tipo
	 */
	private void cargarDatos() {
		lista.add(new Tipo(1,"Concierto","Concierto musical"));
		lista.add(new Tipo(2,"Despedida","Despedida de soltero/a"));
		lista.add(new Tipo(3,"Cumpleaños","Cumpleaños de niños y adultos"));
		lista.add(new Tipo(4,"Boda","Banquete de boda y sala de fiesta"));
		lista.add(new Tipo(5,"Comunion","Banquete de comunion y con animadores para niños"));
		lista.add(new Tipo(6,"Bautizo","Banquete de bauizo y con animadores para niños"));
	}
	/**
	 * Encontrar Tipo por id
	 * @param idTipos
	 * @return the Tipo
	 */
	@Override
	public Tipo finById(int idTipos) {
		Tipo aux =new Tipo();
		aux.setIdTipo(idTipos);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else {
			return lista.get(pos);
		}
	}
	
	/**
	 * Devolver la lista de Tipo
	 * @return the lista
	 */
	@Override
	public List<Tipo> findAll() {
		return lista;
	}
	/**
	 * Inserta nuevo tipo a la lista
	 * @param tipo
	 * @return int
	 */
	@Override
	public int insertarTipo(Tipo tipo) {
		if (lista.contains(tipo))
			return 0;
		else
			return lista.add(tipo)?1:0;
	}
	/**
	 * Modificar tipo
	 * @param tipo
	 * @return int
	 */
	@Override
	public int modificarTipo(Tipo tipo) {
		int pos = lista.indexOf(tipo);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, tipo) != null)?1:0;
	}
	/**
	 * Eliminar tipo de la lista
	 * @param tipo
	 * @return int
	 */
	@Override
	public int eliminarTipo(Tipo tipo) {
		return lista.remove(tipo)?1:0;
	}
	/**
	 * Eliminar tipo de la lista por idTipo
	 * @param idTipo
	 * @return int
	 */
	@Override
	public int eliminarTipo(int idTipo) {
		Tipo aux =new Tipo();
		aux= finById (idTipo);
		return lista.remove(aux)?1:0;
	}

}
