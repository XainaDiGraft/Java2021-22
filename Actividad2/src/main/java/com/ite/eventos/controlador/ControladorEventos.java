/**
 * 
 */
package com.ite.eventos.controlador;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.eventos.modelo.beans.Evento;
import com.ite.eventos.modelo.repository.IntEventoDao;
import com.ite.eventos.modelo.repository.IntReservaDao;
import com.ite.eventos.modelo.repository.IntTipoDao;


/**
 * @author Olga Bueno
 *
 */
@Controller
@RequestMapping("/eventos")
public class ControladorEventos {
	@Autowired 
	private IntEventoDao edao;
	@Autowired
	private IntTipoDao tdao;
	@Autowired
	private IntReservaDao rdao;
	/**
	 * Metodo que controla la entrada de fechas
	 * @param webdataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webdataBinder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	/**
	 * Metodo que muestra el detalle de un evento
	 * @param model
	 * @param idEvento
	 * @return editarEvento.jsp
	 */
	@GetMapping("/mostrar/{id}")
	public String mostrarEvento(Model model, @PathVariable("id") int idEvento) {
		Evento evento=edao.findById(idEvento);
		int plazaslibres=rdao.plazasLib(evento);
		model.addAttribute("evento", evento);
		model.addAttribute("plazasLib",plazaslibres);
		return "editarEvento";
	}
	/**
	 * Metodo que elimina un evento de la lista segun el parametro pasado 
	 * y llama a HomeController
	 * @param model
	 * @param idEvento
	 * @return /inicio
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarEvento(Model model, @PathVariable("id") int idEvento) {
		int i =edao.eliminar(idEvento);
		if (i == 0) {
			model.addAttribute("mensajeAlta","Evento no eliminado");
			
		}else {
			model.addAttribute("listaEventos", edao.findAll());
			model.addAttribute("mensajeAlta","Evento eliminado");
			
		}
		return "forward:/inicio";
	}
	/**
	 * Metodo que modifica el estado de un evento segun los parametros pasados y llama a HomeController
	 * @param model
	 * @param idEvento
	 * @param estado
	 * @return /inicio
	 */
	@GetMapping("/cambioEstado/{id}/{estado}")
	public String cambiarEstadoEvento(Model model, @PathVariable("id") int idEvento, @PathVariable("estado") String estado) {
		
		
		int i =edao.modificarEstadoEvento(idEvento,estado);
		if (i !=1) {
			model.addAttribute("mensajeAlta","Evento no modificado");
			
		}else {
			model.addAttribute("listaEventos", edao.findAll());
			model.addAttribute("mensajeAlta","Evento modificado con exito");
			
		}
		return "forward:/inicio";
	}
	/**
	 * Metodo que llama al formulario de alta de eventos
	 * @param model
	 * @return altaEvento.jsp
	 */
	@GetMapping("/altaEventoNuevo")
	public String mostrarFormularioAltaEvento(Model model) {
		model.addAttribute("listaTipos", tdao.findAll());
		return "altaEvento";
	}
	/**
	 * Metodo que gestiona el formulario de alta de eventos carga el dato en la lista de evedntos
	 * y llama al Home Controller
	 * @param attr
	 * @param evento
	 * @param idTipo
	 * @return /inicio 
	 */
	@PostMapping("/altaEventoNuevo")
	public String procesarFormularioAltaEvento(RedirectAttributes attr, Evento evento){
		
		evento.setTipo(tdao.findById(evento.getTipo().getIdTipo()));

		int codigo=edao.alta(evento);
		if (codigo==1) {
			attr.addFlashAttribute("mensajeAlta", "Evento generado con exito");
		}else {
			attr.addFlashAttribute("mensajeAlta", "Evento no generado con exito");	
		}
		return "redirect:/inicio";
	}
	
	/**
	 * Metodo que muestra en el jsp destacados la lista de eventos 
	 * con parametro destacado S
	 * @param model
	 * @return destacados.jsp
	 */
	@GetMapping("/listarDestacados")
	public String mostrarDestacados(Model model) {
		model.addAttribute("listaEventos",edao.findByDestacado());
		return "destacados";
	}
	/**
	 * Metodo que muestra en el jsp estados la lista de eventos 
	 * con el estado que se pasa por parametro
	 * @param model
	 * @param estado
	 * @return estados.jsp
	 */
	@GetMapping("/listarEstado/{estado}")
	public String mostrarEstado(Model model, @PathVariable("estado") String estado) {
		model.addAttribute("listaEventos",edao.findAllByEstado(estado));
		System.out.println(edao.findByDestacado());
		return "estados";
	}
}
