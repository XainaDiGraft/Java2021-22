/**
 * 
 */
package com.ite.eventos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ite.eventos.modelo.repository.IntTipoDao;

/**
 * @author Olga Bueno
 *
 */
@Controller
@RequestMapping("/tipos")
public class ControladorTipos {
	@Autowired
	private IntTipoDao tdao;
	
	@GetMapping("/listarTipos")
	public String mostrarDestacados(Model model) {
		model.addAttribute("listaTipos",tdao.findAll());
		return "tipos";
	}
	
	
	
}
