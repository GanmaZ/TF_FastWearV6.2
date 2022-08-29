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

import pe.edu.upc.demo.entities.TipoProducto;
import pe.edu.upc.demo.serviceinterface.ITipoProductoService;

@Controller
@RequestMapping("/tipoproductos")
public class TipoProductoController {

	@Autowired
	private ITipoProductoService tipService;

	@GetMapping("/nuevo")
	public String newTipoProducto(Model model) {
		model.addAttribute("p", new TipoProducto());
		return "tipoproducto/frmRegistro";

	}

	@PostMapping("/guardar")
	public String saveTipoProducto(@Valid TipoProducto tip, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "tipoproducto/frmRegistro";
		} else {
			tipService.insert(tip);
			model.addAttribute("mensaje", "Se registró correctamente!");
			return "redirect:/tipoproductos/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listTipoProducto(Model model) {
		try {
			model.addAttribute("listaTipoProductos", tipService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tipoproducto/frmLista";
	}

	@GetMapping("/reporte")
	public String reporteTipoProducto(Map<String, Object> model) {
		model.put("reporteLista", tipService.reporte());
		
		return "reporte/reportejim";
	}

	@RequestMapping("/eliminar")
	public String deleteTipoProducto(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tipService.delete(id);// eliminar
				model.put("listaTipoProductos", tipService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "tipoproducto/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<TipoProducto> objTip = tipService.listId(id);
		model.addAttribute("tipo", objTip.get());
		return "tipoproducto/frmActualiza";
	}

	@PostMapping("/modificar")
	public String updateTipoProducto(TipoProducto ti) {
		tipService.update(ti);
		return "redirect:/tipoproductos/listar";
	}
}
