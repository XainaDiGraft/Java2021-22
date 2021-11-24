package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.daos.EventoDaoImplList;
import modelo.daos.IntEventoDao;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImplList;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/eventos")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private IntEventoDao edao; 
     private IntTipoDao tdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        edao = new EventoDaoImplList();
        tdao = new TipoDaoImplList();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "alta":
			procAlta(request, response);
			break;
		
		case "editar":
			procEditar(request, response);
			break;
		
		case "eliminar":
			procEliminar(request, response);
			break;
			
		case "cancelar":
			procCancelar(request, response);
			break;
		
		default:
			System.out.println("opcion incorrecta : " + opcion);
			
		}
		
		
	}
	
	protected void procAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String mensaje = null;
		Evento evento = new Evento();
		evento.setNombre(request.getParameter("nombre"));
		evento.setDescripcion(request.getParameter("descripcion"));
		
		try {
			evento.setFechaInicio(sdf.parse(request.getParameter("fechaInicio")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		evento.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		evento.setDireccion(request.getParameter("direccion"));
		evento.setEstado(request.getParameter("estado"));
		evento.setDestacado(request.getParameter("destacado"));
		evento.setAforoMaximo(Integer.parseInt(request.getParameter("aforoMaximo")));
		evento.setMinimoAsistencia(Integer.parseInt(request.getParameter("minimoAsistencia")));
		evento.setPrecio(Double.parseDouble(request.getParameter("precio")));
		evento.setTipo(tdao.findById(Integer.parseInt(request.getParameter("idTipo"))));
 
		if (edao.addEvento(evento) == 1)
			mensaje = "Alta Evento confirmada";
		else
			mensaje = "Alta NOOOOO realizada";
		
		request.getSession().setAttribute("edaoSession", edao);
		request.setAttribute("mensaje", mensaje); 
		request.getRequestDispatcher("inicio").forward(request, response);
		
	}
	
	protected void procEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Evento evento = edao.findById(Integer.parseInt(request.getParameter("idEvento")));
			request.setAttribute("evento", evento);
			request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
		}
	protected void procCancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		edao.modificarEstadoEvento(Integer.parseInt(request.getParameter("idEvento")), request.getParameter("estado"));
	 
	 	request.getSession().setAttribute("edaoSession", edao);
		 
			request.getRequestDispatcher("inicio").forward(request, response);
		
	}
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		edao.delEvento(Integer.parseInt(request.getParameter("idEvento")));
	 	request.getSession().setAttribute("edaoSession", edao);
	 
		request.getRequestDispatcher("inicio").forward(request, response);
	}

}
