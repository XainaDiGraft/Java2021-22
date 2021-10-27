/**
 * 
 */
package modelo.daos;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Familia;

/**
 * 01/10/2021
 *
 */
public class FamiliaListImp implements IntFamilia {
	private List<Familia> lista;
	
	/**
	 * Constructor que carga la lista de Familias en un arrayList
	 */
	public FamiliaListImp() {
		lista = new ArrayList<Familia>();
		cargarDatos();
	}
	/**
	 * funcion para cargar datos en la lista de familias
	 */
	private void cargarDatos() {
		lista.add(new Familia(1, "Camisa"));
		lista.add(new Familia(2, "Pantalon"));
		lista.add(new Familia(3, "Jersey"));
		lista.add(new Familia(4, "Polo"));
		lista.add(new Familia(5, "Camiseta"));
		
	}
	/**
	 * Encontrar familia por id
	 * @param idFamilia
	 * @return the Familia
	 */
	@Override
	public Familia finById(int idFamilia) {
		Familia aux =new Familia(); 
		aux.setIdFamilia(idFamilia);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else {
			return lista.get(pos);
		}
	}
	/**
	 * Devolver la lista de familias
	 * @return the lista
	 */

	@Override
	public List<Familia> findAll() {
		return lista;
	}
	/**
	 * Inserta nueva familia a la lista
	 * @param familia
	 * @return int
	 */
	@Override
	public int insertarFamilia(Familia familia) {
		if (lista.contains(familia))
			return 0;
		else
			return lista.add(familia)?1:0;
	}
	/**
	 * Modificar familia
	 * @param familia
	 * @return int
	 */
	@Override
	public int modificarFamilia(Familia familia) {
		int pos = lista.indexOf(familia);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, familia) != null)?1:0;
	}
	/**
	 * Eliminar familia de la lista
	 * @param familia
	 * @return int
	 */
	@Override
	public int eliminarFamilia(Familia familia) {
		
		return lista.remove(familia)?1:0;
	}
	/**
	 * Eliminar familia de la lista por idFamilia
	 * @param idFamilia
	 * @return int
	 */
	@Override
	public int eliminarFamilia(int idFamilia) {
		Familia aux =new Familia();
		aux= finById (idFamilia);
		return lista.remove(aux)?1:0;
	}

}
