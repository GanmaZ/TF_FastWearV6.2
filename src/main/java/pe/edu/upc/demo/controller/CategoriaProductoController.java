package pe.edu.upc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.CategoriaProducto;
import pe.edu.upc.demo.serviceinterface.ICategoriaProductoService;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;
import pe.edu.upc.demo.serviceinterface.IProductoService;

@Controller
@RequestMapping("/categoriaproductos")
public class CategoriaProductoController {
	@Autowired
	private ICategoriaProductoService cpService;
	
	@Autowired
	private ICategoriaService cService;

	@Autowired
	private IProductoService pService;

	@GetMapping("/nuevo")
	public String newCategoriaProducto(Model model) {
		model.addAttribute("cp", new CategoriaProducto());
		model.addAttribute("listaCategorias", cService.list());
		model.addAttribute("listaProductos", pService.list());
		return "categoriaproducto/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveCategoriaProducto(@Valid CategoriaProducto objCP, BindingResult binRes) {

		if (binRes.hasErrors()) {
			return "categoriaproducto/frmRegistro";
		} else {
			cpService.insert(objCP);
			return "redirect:/categoriaproductos/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listCategoriaProducto(Model model) {
		try {
			model.addAttribute("listaCategoriaProductos", cpService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "categoriaproducto/frmLista";
	}

}
