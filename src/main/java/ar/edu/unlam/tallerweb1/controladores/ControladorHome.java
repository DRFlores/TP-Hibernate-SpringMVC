package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
}
