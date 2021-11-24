/**
 * 
 */
package com.ite.eventos.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.eventos.modelo.beans.Evento;
import com.ite.eventos.modelo.beans.Reserva;
import com.ite.eventos.modelo.beans.Usuario;
import com.ite.eventos.modelo.repository.IntEventoDao;
import com.ite.eventos.modelo.repository.IntReservaDao;

/**
 * @author Olga Bueno
 *
 */
@Controller
@RequestMapping("/reservas")
public class ControladorReservas {
	@Autowired 
	private IntReservaDao rdao;
	@Autowired 
	private IntEventoDao edao;
	/**
	 * Llama al jsp misReservas con la lista de reservas de clientes
	 * @param model
	 * @param sesion
	 * @return misReservas.jsp
	 */
	@GetMapping("/misreservas")
	public String cargarReservasByUser(Model model, HttpSession sesion) {
		Usuario usu = (Usuario) sesion.getAttribute("usuarioActivo");
		
		model.addAttribute("listaReservas",rdao.findAllByUsuario(usu.getIdUsuario()));
		return "misReservas";
	}
	/**
	 * Recupera los datos del formulario de reservas 
	 * @param attr
	 * @param model
	 * @param sesion
	 * @param idEvento
	 * @param cantidad
	 * @return /inicio
	 * @return /mostrar/{idEvnto}
	 */
	@PostMapping("/altaReserva")
	public String gestionarNuevaReserva(RedirectAttributes attr,Model model, HttpSession sesion, @RequestParam("idEvento") int idEvento, @RequestParam("cantidad") int cantidad) {
		
		Reserva reser=new Reserva();
		Usuario usu = (Usuario) sesion.getAttribute("usuarioActivo");
		Evento even=(Evento)edao.findById(idEvento);
		/**
		 * Comprueba si hay reservas anteriores al mismo evento si las hay y es 10 devuelve error
		 * Maximo de entradas por persona es 10 
		 */
		
		List<Reserva> lres =rdao.findAllByUsuario(usu.getIdUsuario());
		int cResPrev=0;
		for(Reserva ele:lres) {
			if (ele.getEvento().getIdEvento()==even.getIdEvento()) {
				cResPrev=cResPrev+ele.getCantidad();
			}
		}
		
		if((cResPrev+cantidad)>10) {
			attr.addFlashAttribute("mensajeError", "Ha sobrepasado el maximo de reservas por cliente. El maximo que puede reservar son 10 y ya tiene reservadas " + cResPrev );
			return "redirect:/eventos/mostrar/"+ idEvento;
		}
		reser.setUsuario(usu);
		reser.setEvento(even);
		reser.setCantidad(cantidad);
		double precioVenta= cantidad * even.getPrecio();
		reser.setPrecioVenta(precioVenta);
		
		int codigo=rdao.alta(reser);
		if (codigo==1) {
			attr.addFlashAttribute("mensajeAlta", "Reserva generado con exito");
			return "redirect:/inicio";
		}else {
			attr.addFlashAttribute("mensajeError", "Reserva no se ha producido");
			return "redirect:/eventos/mostrar/"+ idEvento;
		}
		
	}
	
}
