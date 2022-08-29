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

import pe.edu.upc.demo.entities.Talla;
import pe.edu.upc.demo.serviceinterface.ITallaService;

@Controller
@RequestMapping("/tallas")
public class TallaController {

	@Autowired
	private ITallaService tService;

	@GetMapping("/nuevo")
	public String newTalla(Model model) {
		model.addAttribute("emp", new Talla());
		return "talla/RegistrarTalla";
	}

	@PostMapping("/guardar")
	public String saveTalla(@Valid Talla t, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "talla/RegistrarTalla";
		} else {
			tService.insert(t);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/tallas/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listTalla(Model model) {
		try {
			model.addAttribute("listaTallas", tService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "talla/ListarTalla";
	}

	@RequestMapping("/eliminar")
	public String deleteTalla(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.delete(id); // elimina
				model.put("listaTallas", tService.list());// vuelve a listar

			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "talla/ListarTalla";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Talla> objTa = tService.listId(id);
		model.addAttribute("tal", objTa.get());
		return "talla/ActualizaTalla";
	}

	@PostMapping("/modificar")
	public String updatTalla(Talla t) {
		tService.update(t);
		return "redirect:/tallas/listar";

	}
}
