/**
 * 
 */
package com.ite.eventos.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.ite.eventos.modelo.beans.Usuario;
import com.ite.eventos.modelo.repository.IntEventoDao;


/**
 * @author Olga Bueno
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private IntEventoDao ievento;
	/**
	 * Metodo inicial comprueba is estas registrado, si no lo estas te envia al 
	 * controlador que llama al formulario de login, si lo estas te envia a index.jsp
	 * @param model
	 * @param sesion
	 * @return /usuario/login
	 * @return index.jsp
	 */
	@GetMapping("/inicio")
	public String inicio(Model model, HttpSession sesion) {
		if((Usuario) sesion.getAttribute("usuarioActivo")==null) {
			return "forward:/usuario/login";
		}else {
			model.addAttribute("listaEventos",ievento.findAll());	
			return "index";
		}
			
	}
}
