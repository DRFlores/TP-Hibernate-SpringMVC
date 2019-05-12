package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {

	@RequestMapping(path = {"/", "/procesar-operacion","/home"}, method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/procesar-operacion", method = RequestMethod.POST)
	public ModelAndView procesarOperacion(@RequestParam("operacion") String operacion,@RequestParam("texto") String texto) {
		
		String cadenaResultado ="";
		String nombreOperacion ="";
		boolean retornoUnNumero = false;
		Integer numeroResultado = 0;
				
		switch(operacion) {
		case "pasarAMayuscula":
			nombreOperacion = "Pasar a mayúscula";
			cadenaResultado = texto.toUpperCase();
			break;
		case "pasarAMinuscula":
			nombreOperacion = "Pasar a minúscula";
			cadenaResultado = texto.toLowerCase();
			break;
		case "invertirOrden":
			nombreOperacion = "Invertir orden";
			StringBuilder builder=new StringBuilder(texto);
			cadenaResultado = builder.reverse().toString();
			break;
		case "cantidadDeCaracteres":
			nombreOperacion = "Cantidad de caracteres";
			numeroResultado = texto.length();
			retornoUnNumero = true;
			break;
		}
		
		ModelMap model = new ModelMap();
		
		model.put("nombreOperacion", nombreOperacion);
		model.put("cadena", texto);	
		
		if(retornoUnNumero) {
			model.put("cadenaResultado", numeroResultado);
		}
		else {
			model.put("cadenaResultado", cadenaResultado);
		}		
		
		return new ModelAndView("resultado", model);
	}

}
