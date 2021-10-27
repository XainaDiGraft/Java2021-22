package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionProductos
 */
@WebServlet(description = "Tareas asociadas a productos", urlPatterns = { "/productos" })
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Productos:Entrando solo una vez en ini");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Productos:Entrando en servlet, una por tarea");
		String opcion= request.getParameter("opcion");
		switch(opcion) {
		case "novedades":
			procesarNovedades(request,response);
			break;
		case "alta":
			procesarAlta(request,response);
			break;
		case "editar":
			procesarEditar(request,response);
			break;
		case "eliminar":
			procesarEliminar(request,response);
			break;
		default:
			System.out.println("opcion incorrecta : " + opcion);
			
		}
	}

	private void procesarEliminar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("en eliminar id : " + request.getParameter("id"));
		
	}

	private void procesarEditar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("en editar id : " + request.getParameter("id"));
		
	}

	private void procesarAlta(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("en alta");
		
	}

	private void procesarNovedades(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("en novedades");
		
	}

	
}
