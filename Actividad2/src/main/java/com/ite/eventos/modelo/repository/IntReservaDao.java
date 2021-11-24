/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.util.List;

import com.ite.eventos.modelo.beans.Evento;
import com.ite.eventos.modelo.beans.Reserva;


/**
 * @author Olga Bueno
 *
 */
public interface IntReservaDao {
	//BUSCAR RESERVA POR ID
	Reserva findById(int idReserva);
	//BUSCAR RESERVA POR EVENTO
	List<Reserva> findAllByEvento(int idEvento);
	//CALCULAR PLAZAS LIBRES DEL EVENTO
	int plazasLib(Evento evento);
	//BUSCAR RESERVA POR USUARIO
	List<Reserva> findAllByUsuario(int idUsuario);
	//DEVUELVE UNA LISTA CON TODAS LAS RESERVAS
	List<Reserva> findAll();
	//AÑADE UNA NUEVA RESERVA AL CONJUNTO DE DATOS
	int alta(Reserva reserva);
	//MODIFICA UNA RESERVA EXISTENTE EN EL CONJUNTO DE DATOS
	int modUsuario(Reserva reserva);
	//BORRA UNA RESERVA DEL CONJUNTO DE DATOS
	int eliminar(int idReserva);
	//DEVOLVER EL ULTIMO ID USADO
	int ultimoId();
}
