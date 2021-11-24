/**
 * 
 */
package com.ite.eventos.controlador;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.eventos.modelo.beans.Usuario;
import com.ite.eventos.modelo.repository.IntUsuariosDao;

/**
 * @author Olga Bueno
 *
 */
@Controller
@RequestMapping("/usuario")
public class ControladorUsuario {
	@Autowired 
	IntUsuariosDao udao;
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
	 * Metodo que llama al formulario de login
	 * @return login.jsp
	 */
	@GetMapping("/login")
	public String mostrarFormularioLogin() {
		return "login";
	}
	/**
	 * Metodo que gestiona el formulario de login y si es correto 
	 * te redirecciona al HomeController
	 * @param usuario
	 * @param sesion
	 * @param model
	 * @return login.jsp
	 * @return /inicio
	 */
	@PostMapping("/login")
	public String procesarFormularioLogin( Usuario usuario, HttpSession sesion, Model model) {
		Usuario usuario2=udao.findByUserPass(usuario.getUserName(), usuario.getPassword());
		if (usuario2==null) {
			
			model.addAttribute("mensajeError","Usuario y password incorrecto");
			
			return "login";
		}else {
			sesion.setAttribute("usuarioActivo",usuario2);
			return "redirect:/inicio";
		}
		
	}
	/**
	 * Metodo que llama al formulario de alta de usuario
	 * @return registroUsuario.jsp
	 */
	@GetMapping("/altaUsuario")
	public String mostrarFormularioAltaUsuario() {
		return "registroUsuario";
	}
	/**
	 * Metodo que gestiona el formulario de alta de usuario y si es correto te logea el usuario y
	 * te redirecciona al HomeController
	 * @param attr
	 * @param usuario
	 * @param usuarioSesion
	 * @return /inicio
	 * @return registroUsuario.jsp
	 */
	@PostMapping("/altaUsuario")
	public String procesarFormularioAltaUsuario(RedirectAttributes attr, Usuario usuario, HttpSession usuarioSesion) {
		usuario.setFechaRegistro(new java.util.Date());
		int codigo=udao.insertarUsuario(usuario);
		if (codigo==1) {
			attr.addFlashAttribute("mensajeAlta", "Usuario registrado con exito");
			usuarioSesion.setAttribute("usuarioActivo",usuario);
			return "redirect:/inicio";
		}else {
			attr.addFlashAttribute("mensajeError", "Usuario no registrado");	
			return "registroUsuario";
		}
	}
	/**
	 * Metodo que mustra los datos del usuario que este logeado en el momento 
	 * en caso de que no haya nadie logeado llama al HomeController
	 * @param model
	 * @param sesion
	 * @return usuario.jsp
	 * @return /inicio
	 */
	@GetMapping("/usuarioDatos")
	public String mostrarUsuario(Model model, HttpSession sesion) {
		if((Usuario) sesion.getAttribute("usuarioActivo")==null) {
			model.addAttribute("mensajeAlta", "Es necesario estar loggeado");
			return "forward:/inicio";
		}else {
			Usuario usuario=(Usuario) sesion.getAttribute("usuarioActivo");
			model.addAttribute("usuario", usuario);
			return "usuario";
		}
	}
	/**
	 * Metodo que cierra la sesion del cliente y redirecciona al HomeController
	 * @param sesion
	 * @return /inicio
	 */
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession sesion) {
		sesion.removeAttribute("usuarioActivo");
		sesion.invalidate();
		return "forward:/inicio";
	}
}
