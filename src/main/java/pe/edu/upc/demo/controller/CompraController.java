package pe.edu.upc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Compra;
import pe.edu.upc.demo.serviceinterface.ICompraService;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private IUsuarioService uService;
	@Autowired
	private ICompraService cService;
	
	@GetMapping("/nuevo")
	public String newCompra(Model model) {
		model.addAttribute("compra", new Compra());
		model.addAttribute("listaUsuarios", uService.list());
		return "/compra/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveCompra(@Valid Compra objCompra, BindingResult binRes) {
		
		if(binRes.hasErrors()) {
			return"/compra/frmRegistro";
		}
		else {
			cService.insert(objCompra);
			return "redirect:/compras/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listCompra(Model model) {
		try {
			model.addAttribute("listaCompras", cService.list());
		
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/compra/frmLista";
	}
}
