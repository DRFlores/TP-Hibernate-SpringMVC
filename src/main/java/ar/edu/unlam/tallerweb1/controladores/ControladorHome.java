package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {

	@RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/procesar-operacion/{operacion}/{cadena}", method = RequestMethod.GET)
	public ModelAndView procesarOperacion(@PathVariable("operacion") String operacion,@PathVariable("cadena") String cadena) {
		
		String cadenaResultado ="";
		String nombreOperacion ="";
		boolean retornoUnNumero = false;
		Integer numeroResultado = 0;
				
		switch(operacion) {
		case "pasarAMayuscula":
			nombreOperacion = "Pasar a mayúscula";
			cadenaResultado = cadena.toUpperCase();
			break;
		case "pasarAMinuscula":
			nombreOperacion = "Pasar a minúscula";
			cadenaResultado = cadena.toLowerCase();
			break;
		case "invertirOrden":
			nombreOperacion = "Invertir orden";
			StringBuilder builder=new StringBuilder(cadena);
			cadenaResultado = builder.reverse().toString();
			break;
		case "cantidadDeCaracteres":
			nombreOperacion = "Cantidad de caracteres";
			numeroResultado = cadena.length();
			retornoUnNumero = true;
			break;
		default:
		   return new ModelAndView("home");
		    
		}
		
		ModelMap model = new ModelMap();
		
		model.put("nombreOperacion", nombreOperacion);
		model.put("cadena", cadena);	
		
		if(retornoUnNumero) {
			model.put("cadenaResultado", numeroResultado);
		}
		else {
			model.put("cadenaResultado", cadenaResultado);
		}		
		
		return new ModelAndView("resultado", model);
	}

}
