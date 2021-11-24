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

package com.ite.eventos.modelo.beans;

import java.io.Serializable;

/**
 * @author Olga Bueno
 *
 */
public class Tipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idTipo;
	private String nombre;
	private String descripcion;
	/**
	 * Constructor con argumentos
	 * @param idTipo
	 * @param nombre
	 * @param descripcion
	 */
	public Tipo(int idTipo, String nombre, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	/**
	 * Constructor sin argumentos
	 */
	public Tipo() {
		super();
	}
	/**
	 * getter and setter de 
	 * @param idTipo
	 * @param nombre
	 * @param descripcion
	 */
	/**
	 * @return the idTipo
	 */
	public int getIdTipo() {
		return idTipo;
	}
	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * hashcode solo por idTipo
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipo;
		return result;
	}
	/**
	 * equals solo por idTipo
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
		Tipo other = (Tipo) obj;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}
	/**
	 * toString con todos los parametros
	 */
	@Override
	public String toString() {
		return "tipo [idTipo=" + idTipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
