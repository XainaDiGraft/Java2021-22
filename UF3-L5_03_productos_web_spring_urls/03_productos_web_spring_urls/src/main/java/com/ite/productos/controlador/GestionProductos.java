package com.ite.productos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ite.productos.modelo.beans.Producto;
import com.ite.productos.modelo.repository.IntFamilia;
import com.ite.productos.modelo.repository.IntProductos;

@Controller
@RequestMapping("/productos")
public class GestionProductos {
	@Autowired
	private IntProductos iprod;
	@Autowired
	private IntFamilia ifam;
	
	@GetMapping("/editar")
	public String editar(Model model, @RequestParam("id") int idProducto) {
		Producto producto = iprod.findById(idProducto);
		model.addAttribute("producto", producto);
		return "editarproducto";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") int idProducto) {
		int i = iprod.borrarProducto(idProducto);
		if (i == 0)
			model.addAttribute("mensaje","producto no eliminado");
		else {
			model.addAttribute("listaProductos", iprod.findAll());
			model.addAttribute("mensaje","producto  eliminado");
		}
			
		return "index";
		
	}
	
	@GetMapping("/alta")
	public String verAlta(Model model) {
		model.addAttribute("familias", ifam.findAll());
		return "FormAltaProducto";
	}

}
