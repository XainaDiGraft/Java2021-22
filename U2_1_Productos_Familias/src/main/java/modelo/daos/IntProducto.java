
package modelo.daos;

import java.util.List;
import modelo.beans.Producto;

/**
 * 01/10/2021
 */
public interface IntProducto {
	Producto findbyId(int idProducto);
	List<Producto> findAll();
	List<Producto> buscarPorFamilia (int idFamilia);
	List<Producto> novedades();
	int altaProducto (Producto producto);
	int modificarProducto (Producto producto);
	int eliminarProducto (Producto producto);
	int eliminarProducto (int idProducto);
	
}