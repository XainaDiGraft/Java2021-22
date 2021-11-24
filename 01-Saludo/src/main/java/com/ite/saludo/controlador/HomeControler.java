package com.ite.saludo.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {
	@GetMapping("/saludo")
	public String bienvenida() {
		return"Bienvenida al curso de Spring boot";
	}
}
