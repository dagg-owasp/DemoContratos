package consulting.caimantech.contratos.controllers;

import consulting.caimantech.contratos.AppUtils;
import consulting.caimantech.contratos.forms.BeanDetallesContrato;
import consulting.caimantech.contratos.forms.AltaContratoForm;
import consulting.caimantech.contratos.model.Contrato;
import consulting.caimantech.contratos.repo.IContratoRepo;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.owasp.encoder.Encode;

@Controller
public class ContratosController implements WebMvcConfigurer {
	
	final Logger logger = LoggerFactory.getLogger(ContratosController.class);
	
	@Autowired
	private IContratoRepo repo;
	
	@GetMapping("/")
	public String Inicio(){
		return "redirect:/MuestraContratos.do";
	}
	
	@GetMapping("/MuestraContratos.do")
	public String MuestraContratos(AltaContratoForm altaContratoForm, Model model) {
		model.addAttribute("contratos", repo.findAll(Sort.by(Sort.Direction.ASC, "idContrato")));
		return "MuestraContratos";
	}	
	
	@GetMapping("/DetallesContrato.do")
	public String DetallesContrato(@Valid BeanDetallesContrato filter, BindingResult result, Model model) {
		
		String NombreContrato = "No Existe";
		
		try {
			
				if(result.hasErrors()){
					AppUtils.propagarExcepcion(result.getFieldError().getDefaultMessage());
				}
			
				if (repo.existsById(filter.getId())) {
					NombreContrato = repo.getOne(filter.getId()).getNombre();
					logger.info("Cargando detalles del contrato: [{}]  (Encoded)",  Encode.forJava(NombreContrato));
				} else {
					logger.info("No existe un contrato con el id [{}]  (Encoded)",  Encode.forJava(String.valueOf(filter.getId())));
				}
			
			
		} catch  (Exception ex) {
			logger.error("No se encontro el contrato, Stack Trace {}", AppUtils.cleanMessage(filter.toString(), null), ex);
		}
		
		model.addAttribute("nombre", NombreContrato);
		return "DetallesContrato";
		
	}
	
	@PostMapping("/AltaContrato.do")
	public String validaFormaAltaContrato (@Valid AltaContratoForm altaContratoForm, BindingResult bindingResult, Model model) {
		
		try {
			
			if (bindingResult.hasErrors()) {
				AppUtils.propagarExcepcion(bindingResult.getFieldError().getDefaultMessage());
				
			}
			
			else {
				boolean existente = false;
				
				if (repo.existsById(Integer.parseInt(altaContratoForm.getId()))) {
					existente = true;
				}
				
				Contrato c = new Contrato();
				c.setIdContrato(Integer.parseInt(altaContratoForm.getId()));
				c.setNombre(altaContratoForm.getNombre());
				repo.save(c);
				
				model.addAttribute("nombre", altaContratoForm.getNombre());
				model.addAttribute("modificado", existente);
			}
		} catch (Exception ex) {
			logger.error("No se encontro el contrato, Stack Trace {}", AppUtils.cleanMessage(altaContratoForm.toString(), null), ex);
			return "MuestraContratos";
		}
		
		return "ModificarContrato";
	}
			
}
	
