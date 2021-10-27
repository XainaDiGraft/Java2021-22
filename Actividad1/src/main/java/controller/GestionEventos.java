package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImpl;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet(description = "Tareas asociadas a eventos", urlPatterns = { "/eventos" })
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Recuperamos la lista de opciones
		 */
		String opcion=request.getParameter("opcion");
		/**
		 * Llamamos a la funcion que gestiona dependiendo de la opcion recuperada
		 */
		switch (opcion){
			case "editar":
				procesarEditar(request,response);
				break;
			case "alta":
				procesarAlta(request,response);
			
				break;
			case "eliminar":
				procesarEliminar(request,response);
				break;
			case "cancelar":
				procesarCancelar(request,response);
				break;
			default:
				System.out.println("opcion incorrecta:" + opcion);
		}
			
	}
	/**
	 * No llamamos a las funciones de IntEventoDao ya que fallarian con los nuevos datos al no tener una BBDD o fichero donde se guardan los nuevos datos
	 */
	/**
	 * Funcion que se encarga de mostrar los atributos de un evento de la lista de eventos
	 * @param request
	 * @param response
	 */
	private void procesarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Recuperamos la lista 
		 */
		List<Evento> lista =(List<Evento>)request.getSession().getAttribute("listaEventos");
		/**
		 * Recuperamos el id
		 */
		int id=(Integer.parseInt(request.getParameter("id")));
		/**
		 * Buscamos en que posicion de la lista esta
		 */
		Evento aux=new Evento();
		aux.setIdEvento(id);
		int pos= lista.indexOf(aux);
		if(pos!=-1) {
			/**
			 * Recuperamos los atributos del evento
			 */
			aux =lista.get(pos);
			/**
			 * cargamos el evento en el response y llamamos a editarEvento.jsp
			 */
			request.setAttribute("evento", aux);
			request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
	/**
	 * Funcion que se encarga de añadir un evento de la lista de eventos
	 * @param request
	 * @param response
	 */
	private void procesarAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Recuperamos la lista si es nula la creamos
		 */
		List<Evento> lista =(List<Evento>)request.getSession().getAttribute("listaEventos");
		if (lista==null) {
			lista = new ArrayList<Evento>();
		}
		/**
		 * Extraemos el ultimo id de la lista
		 */
		Evento aux=new Evento();
		aux=lista.get(lista.size()-1);
		int idnuevo=aux.getIdEvento()+1;
		
		IntTipoDao tdao= new TipoDaoImpl();
		/**
		 * generamos formato de fecha
		 */
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		/**
		 * Creamos un obgeto Evento y un objeto Tipo
		 */
		Evento evento= new Evento();
		
		
		/**
		 * Cargamos en el objeto evento los atributos recuperados
		 */
		evento.setIdEvento(idnuevo);
		evento.setNombre(request.getParameter("nombre"));
		evento.setDescripcion(request.getParameter("descripcion"));
		try {
			evento.setFechaInicio(formato.parse(request.getParameter("fechaInicio")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		evento.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		evento.setDireccion(request.getParameter("direccion"));
		evento.setEstado(request.getParameter("estado"));
		evento.setDestacado(request.getParameter("destacado").charAt(0));
		evento.setAforoMaximo(Integer.parseInt(request.getParameter("aforoMaximo")));
		evento.setMinimoAsistencia(Integer.parseInt(request.getParameter("minimoAsistencia")));
		evento.setPrecio(Double.parseDouble(request.getParameter("precio")));
		evento.setTipo(tdao.finById(Integer.parseInt(request.getParameter("tipo"))));
		/**
		 * añadimos el objeto a lista 
		 */
		lista.add(evento);
		/**
		 * Cargamos lista en el response y llamamos a index.jsp
		 */
		request.getSession().setAttribute("listaEventos", lista);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * Funcion que se encarga de eliminar un evento de la lista de eventos
	 * @param request
	 * @param response
	 */
	private void procesarEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Recuperamos la lista
		 */
		List<Evento> lista =(List<Evento>)request.getSession().getAttribute("listaEventos");
		/**
		 * Recuperamos el id
		 */
		int id=(Integer.parseInt(request.getParameter("id")));
		/**
		 * Buscamos en que posicion de la lista esta
		 */
		Evento aux=new Evento();
		aux.setIdEvento(id);
		int pos= lista.indexOf(aux);
		/**
		 * Si encuentra la posicion la borra y pasa de nuevo la lista y si no solo
		 * Llamamos a index.jsp
		 */
		if(pos!=-1) {
			lista.remove(pos);
			request.getSession().setAttribute("listaEventos",lista);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}	
	}
	/**
	 * Funcion que se encarga de modificar un evento de activo a cancelado
	 * @param request
	 * @param response
	 */
	private void procesarCancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/**
		 * Recuperamos la lista
		 */
		List<Evento> lista =(List<Evento>)request.getSession().getAttribute("listaEventos");
		/**
		 * Recuperamos el id
		 */
		int id=(Integer.parseInt(request.getParameter("id")));
		/**
		 * Buscamos en que posicion de la lista esta
		 */
		Evento aux=new Evento();
		aux.setIdEvento(id);
		int pos= lista.indexOf(aux);
		
		/**
		 * Si encuentra la posicion la pasa el estado a cancelado y modifica esa posicion con los nuevos datos y los pasa al response
		 * Si no encuentra la posicion no hace nada 
		 * Llamamos a index.jsp 
		 */
		if(pos!=-1) {
			aux=lista.get(pos);
			aux.setEstado("cancelado");
			lista.set(pos, aux);
			request.getSession().setAttribute("listaEventos",lista);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}	
		
	}
	
}
