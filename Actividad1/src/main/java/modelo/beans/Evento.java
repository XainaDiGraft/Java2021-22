/**
 * Una empresa se dedica a montar eventos. 
 * Cada evento es de un tipo distinto. 
 * Los tipos de evento son: concierto, despedida, cumpleaños, boda…, 
 * y nos interesa un código que identifique cada evento junto con su descripción. 
 * A un evento se inscriben clientes, de los que debemos guardar el esquema SQL. 
 * Recuerda que un cliente puede apuntarse a más de un evento. 
 * 
 * Vamos a implementar el servlet GestionEventos.
 * Las páginas JSP necesarias para las tareas definidas a continuación.
 * La clase de Bean 'Evento' y 'Tipo', a partir de las tablas que tienes en este enunciado.
 * El interface llamado IntEventoDao de la clase 'Evento' con los métodos necesarios.
 * Una clase EventoDaoImpl, que contiene una lista de eventos con su tipo y la implementación de los métodos del interface.
 * 
 * Del servlet llamado GestionEventos tratamos las siguientes opciones:
 * “?opcion=activos” ->  Sacar el listado de la imagen superior.
 * “?opcion=alta: -> Mostrar un formulario con los datos del evento, poner el estado del evento como ‘activo’ y, si quieres destacarlo, poner una ‘s’ en su columna.
 * “?opcion=editar&id=x “ -> Mostrar en un JSP los datos del evento.
 * “?opcion=eliminar&id=x “ ->  Borrarlo de la clase que contiene los eventos y volver al listado de activos.
 * “?opcion=cancelar&id=x “ ->  Poner el estado del evento como cancelado, y volver al listado de activos.
 */
package modelo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Olga Bueno
 *
 */
public class Evento implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private char destacado;
	private int aforoMaximo;
	private int minimoAsistencia;
	private double precio; 
	private Tipo tipo;
	
	/**
	 * Constructor con argumentos
	 * @param idEvento
	 * @param nombre
	 * @param descripcion
	 * @param fechaInicio
	 * @param duracion
	 * @param direccion
	 * @param estado
	 * @param destacado
	 * @param aforoMaximo
	 * @param minimoAsistencia
	 * @param precio
	 * @param tipo
	 */
	public Evento(int idEvento, String nombre, String descripcion, Date fechaInicio, int duracion, String direccion,
			String estado, char destacado, int aforoMaximo, int minimoAsistencia, double precio, Tipo tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMaximo = aforoMaximo;
		this.minimoAsistencia = minimoAsistencia;
		this.precio = precio;
		this.tipo = tipo;
	}
	/**
	 * Constructor sin argumentos
	 */
	public Evento() {
		super();
	}
	/**
	 * getter and setter de 
	 * @param idEvento
	 * @param nombre
	 * @param descripcion
	 * @param fechaInicio
	 * @param duracion
	 * @param direccion
	 * @param estado
	 * @param destacado
	 * @param aforoMaximo
	 * @param minimoAsistencia
	 * @param precio
	 * @param tipo
	 */
	
	/**
	 * @return the idEvento
	 */
	public int getIdEvento() {
		return idEvento;
	}
	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the destacado
	 */
	public char getDestacado() {
		return destacado;
	}
	/**
	 * @param destacado the destacado to set
	 */
	public void setDestacado(char destacado) {
		this.destacado = destacado;
	}
	/**
	 * @return the aforoMaximo
	 */
	public int getAforoMaximo() {
		return aforoMaximo;
	}
	/**
	 * @param aforoMaximo the aforoMaximo to set
	 */
	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}
	/**
	 * @return the minimoAsistencia
	 */
	public int getMinimoAsistencia() {
		return minimoAsistencia;
	}
	/**
	 * @param minimoAsistencia the minimoAsistencia to set
	 */
	public void setMinimoAsistencia(int minimoAsistencia) {
		this.minimoAsistencia = minimoAsistencia;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * hashcode solo por idEvento
	 * @return the result
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvento;
		return result;
	}
	/**
	 * equals solo por idEvento
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
		Evento other = (Evento) obj;
		if (idEvento != other.idEvento)
			return false;
		return true;
	}
	/**
	 * toString con todos los parametros
	 */
	@Override
	public String toString() {
		return "evento [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", aforoMaximo=" + aforoMaximo + ", minimoAsistencia=" + minimoAsistencia
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}

	
}
