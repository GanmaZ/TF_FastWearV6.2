package pe.edu.upc.demo.controller;

import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.DetalleCompra;
import pe.edu.upc.demo.serviceinterface.ICompraService;
import pe.edu.upc.demo.serviceinterface.IDetalleCompraService;
import pe.edu.upc.demo.serviceinterface.IProductoService;

@Controller
@RequestMapping("/detallecompras")
public class DetalleCompraController {

	@Autowired
	private IProductoService pService;
	
	@Autowired
	private ICompraService cService;
	
	@Autowired
	private IDetalleCompraService dService;
	
	@GetMapping("/nuevo")
	public String newDetalleCompra(Model model) {
		model.addAttribute("detallecompra", new DetalleCompra());
		model.addAttribute("listaProductos", pService.list());
		model.addAttribute("listaCompras", cService.list());
		
		return "/detallecompra/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveDetallecompra(@Valid DetalleCompra objDetallecompra, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/detallecompra/frmRegistro";
		}
		else {
			dService.insert(objDetallecompra);
			return "redirect:/detallecompras/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listDetalleCompra(Model model) {
		try {
			model.addAttribute("listaDetallecompras", dService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/detallecompra/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteDetallecompra(Map<String, Object> model, @RequestParam(value = "id")Integer id) {
		try {
			if (id!=null && id>0) {
				dService.delete(id);
				model.put("listaDetallecompras", dService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "detallecompra/frmLista";
	}
	
	
}
