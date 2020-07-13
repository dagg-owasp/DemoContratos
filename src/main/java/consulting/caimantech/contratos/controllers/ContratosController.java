package consulting.caimantech.contratos.controllers;

import consulting.caimantech.contratos.AppUtils;
import consulting.caimantech.contratos.model.Contrato;
import consulting.caimantech.contratos.repo.IContratoRepo;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.owasp.encoder.Encode;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ContratosController {
	
	final Logger logger = LoggerFactory.getLogger(ContratosController.class);
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private IContratoRepo repo;
	
	@GetMapping("/")
	public void Inicio(HttpServletResponse res) throws IOException {
		String defaultUrl = String.format("%s/MuestraContratos.do", context.getContextPath());
		res.sendRedirect(defaultUrl);
	}
	
	@GetMapping("/MuestraContratos.do")
	public String MuestraContratos(Model model) {
		model.addAttribute("contratos", repo.findAll());
		model.addAttribute("contextPath",  context.getContextPath());
		return "MuestraContratos";
	}	
	
	@GetMapping("/DetallesContrato.do")
	public String DetallesContrato(@RequestParam(name="id", required=false, defaultValue="0") String id, Model model) {
		
		String NombreContrato = "No Existe";
		
		try {
			logger.info("Buscando el contrato # " + Encode.forJava(id));
			//valida que sea numerico
			//if (StringUtils.isNumeric(id)) {
				int i = Integer.parseInt(id);
				//valida que exista en la base de datos
				if (repo.existsById(i)) {
					NombreContrato = repo.getOne(i).getNombre();
					//logger.info("Cargando detalles del contrato: [{}]",  Encode.forJava(NombreContrato));
				}else {
					//logger.info("No existe un contrato con el id [{}]",  Encode.forJava(id));
				}
			//}	
		} catch (Exception ex) {
			logger.error("No se encontro el contrato, stacktrace: {}", AppUtils.cleanMessage(id, null), ex);
			logger.error("No se encontro el contrato: {}", AppUtils.cleanMessage(id, ex));
			return "Error";
		}
		
		model.addAttribute("contextPath",  context.getContextPath());
		model.addAttribute("nombre", NombreContrato);
		return "DetallesContrato";
	}
	
	@GetMapping("/AltaContrato.do")
	
	public String AltaContrato(HttpServletRequest request, Model model) {

		if (StringUtils.isNumeric(request.getParameter("id"))) {
			Contrato c = new Contrato();
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			c.setIdContrato(id);
			c.setNombre(nombre);
			repo.save(c);
			model.addAttribute("nombre", nombre);
			model.addAttribute("contextPath",  context.getContextPath());
			return "ModificarContrato";
		}else {
			return "Error";
		}
		
	}
	
}