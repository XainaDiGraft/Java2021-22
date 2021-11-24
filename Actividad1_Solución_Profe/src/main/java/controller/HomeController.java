package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.EventoDaoImplList;
import modelo.daos.IntEventoDao;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private IntEventoDao edao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        edao = new EventoDaoImplList();
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
		IntEventoDao edaoSession = (IntEventoDao) request.getSession().getAttribute("edaoSession");
		if (edaoSession != null)
			edao = edaoSession;
	//	List<Evento> lista = edao.findAllByEstado("ACTIVO");
		
		
		
		List<Evento> lista = edao.findAll(); 
		
		request.setAttribute("listaEventos", lista);
		request.getSession().setAttribute("edaoSession", edao);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
