package modelo.beans;

import java.io.Serializable;

/**
 * 01/10/21
 *
 */
public class Familia implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private int idFamilia;
	private String descripcion;
	/**
	 * Constructor con argumentos
	 * @param idFamilia
	 * @param descripcion
	 */
	public Familia(int idFamilia, String descripcion) {
		super();
		this.idFamilia = idFamilia;
		this.descripcion = descripcion;
	}
	/**
	 * Constructor sin argumentos
	 */
	public Familia() {
		super();
	}
	/**
	 * getter and setter de @param idFamilia y @param descripcion
	 */
	/**
	 * @return the idFamilia
	 */
	public int getIdFamilia() {
		return idFamilia;
	}
	/**
	 * @param idFamilia the idFamilia to set
	 */
	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
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
	 * hashcode solo por idFamilia
	 * @return the result
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFamilia;
		return result;
	}
	/**
	 * equals solo por idFamilia
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
		Familia other = (Familia) obj;
		if (idFamilia != other.idFamilia)
			return false;
		return true;
	}
	/**
	 * toString con idFamilia y descripcion
	 * @return String
	 */
	@Override
	public String toString() {
		return "Familia [idFamilia=" + idFamilia + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
