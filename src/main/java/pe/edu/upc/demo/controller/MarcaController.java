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

import pe.edu.upc.demo.entities.Marca;
import pe.edu.upc.demo.serviceinterface.IMarcaService;

@Controller
@RequestMapping("/marcas")
public class MarcaController {
	@Autowired
	private IMarcaService marService;

	@GetMapping("/nuevo")
	public String newMarca(Model model) {
		model.addAttribute("marca", new Marca());
		return "marca/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveMarca(@Valid Marca marca, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "marca/frmRegistro";
		} else {
			marService.Insert(marca);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/marcas/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listMarca(Model model) {
		try {
			model.addAttribute("listaMarcas", marService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/marca/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleteMarca(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				marService.delete(id);
				model.put("listaMarcas", marService.list());

			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "marca/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Marca> objMarca = marService.listId(id);
		model.addAttribute("marca", objMarca.get());
		return "marca/frmActualiza";
	}

	@RequestMapping("/modificar")
	public String updateMarca(Marca ma) {
		marService.update(ma);
		return "redirect:/marcas/listar";
	}

	@RequestMapping("/reportepedidospormarca")
	public String PedidosMarca(Map<String, Object> model) {
		model.put("reporteLista", marService.ventasMarca());
		return "reporte/reporteairton";
	}

}
