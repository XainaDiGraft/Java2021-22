package modelo.daos;

import java.util.List;

import modelo.beans.Evento;

public interface IntEventoDao {
	Evento findById(int idEvento);
	//DEVUELVE UNA LISTA CON TODOS LOS EVENTOS DEL ESTADO INDICADO "Activo" / "Cancelado"
	List<Evento> findAllByEstado(String estado);
	//AÑADE UN NUEVO EVENTO AL CONJUNTO DE DATOS
	int addEvento(Evento evento);
	//MODIFICA UN EVENTO EXISTENTE EN EL CONJUNTO DE DATOS
	int modEvento(Evento evento);
	//BORRA UN EVENTO DEL CONJUNTO DE DATOS
	int delEvento(int idEvento);
	//CAMBIA EL ESTADO DE UN EVENTO DEL CONJUNTO DE DATOS
	int modificarEstadoEvento(int idEvento,String estado);
	List<Evento> findAll();
	
	List<Evento> findByDetacado();
	
	
	
}
