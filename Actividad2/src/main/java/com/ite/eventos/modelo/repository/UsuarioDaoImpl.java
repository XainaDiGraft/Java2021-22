/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.beans.Usuario;

/**
 * @author Propietario
 *
 */
@Repository 
public class UsuarioDaoImpl implements IntUsuariosDao, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> lista;
	
	/**
	 * Constructor
	 * Crea un array de objetos usuario y carga los datos en el array
	 */
	public UsuarioDaoImpl() {
		lista = new ArrayList<Usuario>();
		cargarDatos();
	}
	/**
	 * funcion con los distintos elementos de objetos Usuarios
	 */
	private void cargarDatos() {
		lista.add(new Usuario(1,"Olga","1234","obuentam@gmail.com","Olga Bueno", "Brunete", 1, new GregorianCalendar(2021,11,21).getTime()));
		lista.add(new Usuario(2,"Jesus","5678","jesus@gmail.com","Jesus Diaz", "Madrid", 1, new GregorianCalendar(2021,11,25).getTime()));
	}
	
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	/**
	 * Encontrar Usuario por id
	 * @param idUsuario
	 * @return Usuario
	 */
	@Override
	public Usuario findById(int idUsuario) {
		Usuario aux=new Usuario();
		aux.setIdUsuario(idUsuario);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else {
			return lista.get(pos);
		}
	}
	@Override
	public Usuario findByUserPass(String userName,String password) {
		for(int i=0;i<lista.size();i++ ) {
			if (lista.get(i).getUserName().equals(userName) && lista.get(i).getPassword().equals(password)) {
				return lista.get(i);
			}			
		}
		
		return null;
	}
	/**
	 * Devolver la lista de Usuarios
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> findAll() {
		return lista;
	}
	/**
	 * Inserta nuevo usuario a la lista
	 * @param usuario
	 * @return int
	 */
	@Override
	public int insertarUsuario(Usuario usuario) {
		if (!lista.contains(usuario)) {
			int ultId=ultimoId();
			usuario.setIdUsuario(++ultId);
			lista.add(usuario);
			return 1;
		}
		return 0;
	}
	/**
	 * Eliminar usuario de la lista por idUsuario
	 * @param idUsuario
	 * @return int
	 */
	@Override
	public int eliminarUsuario(int idUsuario) {
		Usuario aux=new Usuario();
		aux.setIdUsuario(idUsuario);
		int pos = lista.indexOf(aux);
		aux= findById (idUsuario);
		return (lista.remove(pos) != null)? 1 : 0;
	}
	/**
	 * Modificar Usuario
	 * @param Usuario
	 * @return int
	 */
	@Override
	public int modificarUsuario(Usuario usuario) {
		int pos = lista.indexOf(usuario);
		if (pos != -1) {
			lista.set(pos, usuario);
			return 1;
		}
		return 0;	
	}

	@Override
	public int ultimoId() {
		Usuario aux=new Usuario();
		aux=lista.get(lista.size()-1);
		return aux.getIdUsuario();
	}

}
