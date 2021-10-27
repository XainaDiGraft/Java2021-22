package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImpl;

/**
 * Servlet implementation class HomeControler
 */
@WebServlet(description = "Control pagina principal", urlPatterns = { "/HomeControler" })
public class HomeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Recupera la lista inicial de eventos y tipos y los guarda en el response de sesion
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntEventoDao edao= new EventoDaoImpl();
		List<Evento> lista=edao.findAll();
		request.getSession().setAttribute("listaEventos", lista);
		
		IntTipoDao tdao=new TipoDaoImpl();
		List<Tipo> lista2=tdao.findAll();
		request.getSession().setAttribute("listaTipos", lista2);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
