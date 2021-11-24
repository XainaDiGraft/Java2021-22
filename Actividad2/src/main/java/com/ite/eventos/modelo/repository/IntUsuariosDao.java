/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.util.List;

import com.ite.eventos.modelo.beans.Usuario;

/**
 * @author Olga Bueno
 *
 */
public interface IntUsuariosDao {
	//BUSCAR USUARIO POR ID
	Usuario findById(int idUsuario);
	//BUSCAR USUARIO POR user password
	Usuario findByUserPass(String userName,String password);
	//DEVUELVE UNA LISTA CON TODOS LOS USUARIOS
	List<Usuario> findAll();
	//AÑADIR NUEVO USUARIO
	int insertarUsuario(Usuario usuario);
	//BORRAR USUARIO
	int eliminarUsuario(int idUsuario);
	//MODIFICAR USUARIO
	int modificarUsuario(Usuario usuario);
	//DEVOLVER EL ULTIMO ID USADO
	int ultimoId();
}
