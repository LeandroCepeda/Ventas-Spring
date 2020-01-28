package api.main.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import api.main.repositorios.VentaRepository;

@Controller
@RequestMapping(path = "/ventas")
public class VentaController {
	
	@Autowired
	private VentaRepository ventaRepository;
	
	
	@GetMapping(value = "/")
	public String mostrarVentas(Model model) {
		
		model.addAttribute("ventas",ventaRepository.findAll());
		
		return "ventas/listaVentas";
		
	}

}
