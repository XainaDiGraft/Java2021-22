/**
 * 
 */
package modelo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 01/10/2021
 *
 */
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idProducto;
	private String descripcion;
	private double precioUnitario;
	private Date fechaAlta;
	private Familia familia;
	/**
	 * Constructor con argumentos
	 * @param idProducto
	 * @param descripcion
	 * @param precioUnitario
	 * @param fechaAlta
	 * @param familia
	 */
	public Producto(int idProducto, String descripcion, double precioUnitario, Date fechaAlta, Familia familia) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.fechaAlta = fechaAlta;
		this.familia = familia;
	}
	/**
	 * Constructor sin argumentos
	 */
	public Producto() {
		super();
	}
	/**
	 * getter and setter todos los parametros
	 */
	/**
	 * @return the idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the familia
	 */
	public Familia getFamilia() {
		return familia;
	}
	/**
	 * @param familia the familia to set
	 */
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	/**
	 * hashcode y equals solo por idProducto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	/**
	 * toString con todos los parametros
	 */
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", fechaAlta=" + fechaAlta + ", familia=" + familia + "]";
	}
	
}
