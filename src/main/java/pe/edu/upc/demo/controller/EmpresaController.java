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

import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.serviceinterface.IEmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private IEmpresaService eService;

	@GetMapping("/nuevo")
	public String newEmpresa(Model model) {
		model.addAttribute("emp", new Empresa());
		return "empresa/RegistrarEmpresa";
	}

	@PostMapping("/guardar")
	public String saveEmpresa(@Valid Empresa emp, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "Empresa/RegistrarEmpresa";
		} else {
			eService.insert(emp);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/login";
		}

	}

	@GetMapping("/listar")
	public String listEmpresa(Model model) {
		try {
			model.addAttribute("listaEmpresas", eService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/empresa/ListaEmpresa";
	}

	@RequestMapping("/eliminar")
	public String deleteEmpresa(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				eService.delete(id); // elimina
				model.put("listaEmpresas", eService.list());// vuelve a listar

			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/empresa/ListaEmpresa";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Empresa> objEmp = eService.listId(id);
		model.addAttribute("emps", objEmp.get());
		return "empresa/ActualizarEmpresa";
	}

	@PostMapping("/modificar")
	public String updateEmpresa(Empresa emp) {
		eService.update(emp);
		return "redirect:/empresas/listar";

	}
}
