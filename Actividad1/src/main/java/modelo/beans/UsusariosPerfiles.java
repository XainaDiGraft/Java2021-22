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
package modelo.beans;

import java.io.Serializable;

/**
 * @author Olga Bueno
 *
 */
public class UsusariosPerfiles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Perfil perfil;
}
