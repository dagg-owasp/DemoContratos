package consulting.caimantech.contratos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessoDenegadoController {
	
	@GetMapping("/acceso")
	public String error() {	
		return "AccesoDenegado";	
	}
	
}