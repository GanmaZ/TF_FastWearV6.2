package pe.edu.upc.demo.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Categoria;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService cService;

	@GetMapping("/nueva")
	public String newCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());

		return "categoria/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveCategoria(@Valid Categoria categoria, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "categoria/frmRegistro";
		} else {
			cService.insert(categoria);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/categorias/nueva";
		}
	}

	@GetMapping("/listar")
	public String listCategoria(Model model) {
		try {
			model.addAttribute("listaCategorias", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "categoria/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleteCategoria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				cService.delete(id);
				model.put("listaCategorias", cService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "categoria/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Categoria> objCat = cService.listId(id);
		model.addAttribute("cats", objCat.get());
		return ("categoria/frmActualiza");
	}

	@PostMapping("/modificar")
	public String updateCategoria(Categoria ca) {
		cService.update(ca);
		return "redirect:/categorias/listar";

	}
}
