/**
 * 
 */
package modelo.daos;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import modelo.beans.Familia;
import modelo.beans.Producto;

/**
 * 01/10/2021
 *
 */
public class ProductoListImp implements IntProducto {
	private List<Producto> lista;
	/**
	 * Constructor que carga la lista de Productos en un arrayList
	 */
	public ProductoListImp() {
		lista = new ArrayList<Producto>();
		cargarDatos();
	}
	/**
	 * Encontrar producto por id
	 * @param idProducto
	 * @return the producto
	 */	
	@Override
	public Producto findbyId(int idProducto) {
		
		Producto aux = new Producto();
		aux.setIdProducto(idProducto);
		
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else {
			return lista.get(pos);
		}
	}
	/**
	 * Devolver la lista de Productos
	 * @return the lista
	 */
	@Override
	public List<Producto> findAll() {
		return lista;
	}
	/**
	 * Devolver la lista de Productos por id de familia
	 * @param idFamilia
	 * @return the listaXFamilia
	 */
	@Override
	public List<Producto> buscarPorFamilia(int idFamilia) {
		//busco la familia
		IntFamilia ifamilias = new FamiliaListImp();
		Familia f =new Familia();
		f=ifamilias.finById(idFamilia);
		
		//meto en una lista todos los productos que tengan esa familia
		ArrayList<Producto> listaXFamilia=new ArrayList<Producto>();
		
		for (int i =0; i<lista.size();i++) {
			if(lista.get(i).getFamilia()==f) {
				listaXFamilia.add(lista.get(i));
			}
		}
		
		return listaXFamilia;
	}
	/**
	 * Devolver la lista de Productos Novedades
	 * @return the lista
	 */
	@Override
	public List<Producto> novedades() {
		return lista;
	}
	/**
	 * Inserta nuevo producto a la lista
	 * @param producto
	 * @return int
	 */
	@Override
	public int altaProducto(Producto producto) {
		return lista.add(producto)?1:0;
	}
	/**
	 * Modificar producto
	 * @param familia
	 * @return int
	 */
	@Override
	public int modificarProducto(Producto producto) {
		int pos = lista.indexOf(producto);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, producto) != null)?1:0;
	}
	/**
	 * Eliminar producto de la lista
	 * @param producto
	 * @return int
	 */
	@Override
	public int eliminarProducto(Producto producto) {
		return lista.remove(producto)?1:0;
	}
	/**
	 * Eliminar producto de la lista por idProducto
	 * @param idProducto
	 * @return int
	 */
	@Override
	public int eliminarProducto(int idProducto) {
		Producto aux=new Producto();
		aux= findbyId (idProducto);
		return lista.remove(aux)?1:0;	
	}
	/**
	 * funcion para cargar datos en la lista de productos
	 */
	private void cargarDatos() {
		
		IntFamilia ifamilias = new FamiliaListImp();
		
		
			lista.add(new Producto(1,"Camisa blanca XL Hombre",30,new Date(),ifamilias.finById(1)));
			lista.add(new Producto(2,"Camisa verde XS Mujer",60,new Date(),ifamilias.finById(1)));
			lista.add(new Producto(3,"Pantalon blanca L Hombre",15,new Date(),ifamilias.finById(2)));
			lista.add(new Producto(4,"Pantalon verde S Mujer",45,new Date(),ifamilias.finById(2)));
			lista.add(new Producto(5,"Jersey blanca XL Hombre",78,new Date(),ifamilias.finById(3)));
			lista.add(new Producto(6,"Jersey verde XS Mujer",87,new Date(),ifamilias.finById(3)));
			lista.add(new Producto(7,"Chaleco blanca XL Hombre",56,new Date(),ifamilias.finById(4)));
			lista.add(new Producto(8,"Chaleco verde S Mujer",36,new Date(),ifamilias.finById(4)));
			lista.add(new Producto(9,"Camiseta blanca M Hombre",34,new Date(),ifamilias.finById(5)));
			lista.add(new Producto(10,"Camiseta verde M Mujer",120,new Date(),ifamilias.finById(5)));
			
		
	}
}
