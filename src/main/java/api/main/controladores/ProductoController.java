package api.main.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import api.main.entidades.Producto;
import api.main.repositorios.ProductoRepository;

@Controller
@RequestMapping(path = "/productos")
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@GetMapping(value = "/agregar" )
	public String agregarProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "productos/agregarProducto";
	}
	
	
	@PostMapping(value = "/agregar")
	public String guardarProducto(@ModelAttribute @Valid Producto producto,BindingResult bindingResult, RedirectAttributes redirectAttrs) { 
		if(bindingResult.hasErrors()) { //BindingResult para probar y recuperar errores de validacion.
			return "productos/agregarProducto";
		}
		if(productoRepository.findFirstByCodigo(producto.getCodigo()) != null) {
			redirectAttrs.addFlashAttribute("mensaje", "Ya existe un producto con ese codigo")
						 .addFlashAttribute("clase", "warning"); //útiles cuando se tiene que mostrar un mensaje por única ocasión cuando se redirige a otra página.
			
			return"redirect:/productos/agregar"; //Indica el path hacia la pagina	
		}
		
		productoRepository.save(producto);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente")
        			 .addFlashAttribute("clase", "success");
		return"redirect:/productos/agregar";
	}
	
	
	@GetMapping(value = "/mostrar")
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "productos/listaProductos";
	}
	
	
	@GetMapping(value = "/editar/{id}")
	public String editarProducto(@PathVariable int id, Model model) {
		model.addAttribute("producto", productoRepository.findById(id).orElse(null));
		return "productos/editarProducto";
		
	}
	
	
	@PostMapping(value = "/editar/{id}")
	public String actualizarProducto(@ModelAttribute @Valid Producto producto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		if(bindingResult.hasErrors()) {
			return "productos/editarProducto";
		}
		
		// return "redirect:/productos/mostrar";
		
		Producto posibleProductoExistente = productoRepository.findFirstByCodigo(producto.getCodigo());
		
		if(posibleProductoExistente != null && !posibleProductoExistente.getId().equals(producto.getId())) {
			
			redirectAttrs.addFlashAttribute("mensaje", "Ya existe un producto con ese código")
						 .addFlashAttribute("clase","warning");
			return "redirect:/productos/agregar";
		}
		
		productoRepository.save(producto);
		redirectAttrs.addFlashAttribute("mensaje", "Editado correctamente")
        			 .addFlashAttribute("clase", "success");
		return "redirect:/productos/mostrar";
	}
	
	
	@PostMapping(value="/eliminar")
	public String eliminarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente") 
        			 .addFlashAttribute("clase", "warning");
		productoRepository.deleteById(producto.getId());
		return "redirect:/productos/mostrar";
	}
	
	

	
}
