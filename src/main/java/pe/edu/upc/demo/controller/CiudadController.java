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

import pe.edu.upc.demo.entities.Ciudad;
import pe.edu.upc.demo.serviceinterface.ICiudadService;

@Controller
@RequestMapping("/ciudades")
public class CiudadController {
	@Autowired
	private ICiudadService cidService;

	@GetMapping("/nuevo")
	public String newCiudad(Model model) {
		model.addAttribute("c", new Ciudad());
		return "ciudad/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveCiudad(@Valid Ciudad cid, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "ciudad/frmRegistro";
		} else {
			cidService.insert(cid);
			model.addAttribute("mensaje", "Se registró correctamente!");
			return "redirect:/ciudades/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listCiudad(Model model) {
		try {
			model.addAttribute("listaCiudades", cidService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "ciudad/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleteCiudad(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if (id != null && id > 0) {
				cidService.delete(id);// elimina
				model.put("listaCiudades", cidService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "ciudad/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Ciudad>objCid=cidService.listId(id);
		model.addAttribute("ciud", objCid.get());
		return "ciudad/frmActualizar";
	}
	
	@PostMapping("/modificar")
	public String updateCiudad(Ciudad ci) {
		cidService.update(ci);
		return "redirect:/ciudades/listar";
	}
	
	@RequestMapping("/reporteciudadventas")
    public String CiudadVentas(Map<String, Object> model) {
        model.put("reporteLista", cidService.CiudadVentas());
        return "reporte/reporteJoel";
    }
}
