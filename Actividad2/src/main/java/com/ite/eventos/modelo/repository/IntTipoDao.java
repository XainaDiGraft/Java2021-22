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

import java.util.List;
import com.ite.eventos.modelo.beans.Tipo;

/**
 * @author Olga Bueno
 *
 */
public interface IntTipoDao {
	//BUSCAR TIPO POR ID
	Tipo findById(int idTipos);
	//DEVUELVE UNA LISTA CON TODOS LOS TIPOS
	List<Tipo> findAll();
	//AÑADE UN NUEVO TIPO AL CONJUNTO DE DATOS
	int insertarTipo(Tipo tipo);
	//MODIFICA UN TIPO EXISTENTE EN EL CONJUNTO DE DATOS
	int modificarTipo(Tipo tipo);
	//BORRA UN TIPO DEL CONJUNTO DE DATOS
	int eliminarTipo(int idTipo);
	//DEVOLVER EL ULTIMO ID USADO
	int ultimoId();
}
