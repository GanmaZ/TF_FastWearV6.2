package pe.edu.upc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.TallaProducto;
import pe.edu.upc.demo.serviceinterface.IProductoService;
import pe.edu.upc.demo.serviceinterface.ITallaProductoService;
import pe.edu.upc.demo.serviceinterface.ITallaService;

@Controller
@RequestMapping("/tallaproductos")
public class TallaProductoController {

	@Autowired
	private ITallaProductoService tpService;

	@Autowired
	private ITallaService tSercice;

	@Autowired
	private IProductoService pService;

	@GetMapping("/nuevo")
	public String newTallaProducto(Model model) {
		model.addAttribute("tp", new TallaProducto());
		model.addAttribute("listaTallas", tSercice.list());
		model.addAttribute("listaProductos", pService.list());
		return "/tallaproducto/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveTallaProducto(@Valid TallaProducto objTP, BindingResult binRes) {

		if (binRes.hasErrors()) {
			return "/tallaproducto/frmRegistro";
		} else {
			tpService.insert(objTP);
			return "redirect:/tallaproductos/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listTallaProducto(Model model) {
		try {
			model.addAttribute("listaTallaProductos", tpService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tallaproducto/frmLista";
	}
}
