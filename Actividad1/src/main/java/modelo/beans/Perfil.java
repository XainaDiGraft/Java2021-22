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
public class Perfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idPerfil;
	private String nombre;
	/**
	 * Constructor con argumentos
	 * @param idPerfil
	 * @param nombre
	 */
	public Perfil(int idPerfil, String nombre) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	}
	/**
	 * Constructor sin argumentos
	 */
	public Perfil() {
		super();
	}
	
	/**
	 * getter and setter de 
	 * @param idPerfil
	 * @param nombre
	 */
	/**
	 * @return the idPerfil
	 */
	public int getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * hashcode solo por idPerfil
	 * @return the result
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPerfil;
		return result;
	}
	/**
	 * equals solo por idPerfil
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (idPerfil != other.idPerfil)
			return false;
		return true;
	}
	/**
	 * toString con todos los parametros
	 */
	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + "]";
	}
	
	

}
