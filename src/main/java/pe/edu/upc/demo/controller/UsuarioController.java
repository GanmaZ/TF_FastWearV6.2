package pe.edu.upc.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.ICiudadService;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService uService;
	@Autowired
	private ICiudadService cService;
	@Autowired
	private IRoleRepository rRepository;
	@Autowired
	private IUsuarioRepository uRepository;

	@GetMapping("/nuevouser")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaCiudades", cService.list());

		return "/usuario/frmRegistro";
	}

	@GetMapping("/nuevouseradm")
	public String newUsuarioadm(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaCiudades", cService.list());

		return "/usuario/frmRegistroadm";
	}

	@GetMapping("/nuevoempresa")
	public String newEmpresa(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaCiudades", cService.list());

		return "/empresa/RegistrarEmpresa";
	}

	@GetMapping("/nuevoempresaadm")
	public String newEmpresaadm(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaCiudades", cService.list());

		return "/empresa/RegistrarEmpresaadm";
	}

	@PostMapping("/guardar")
	public String saveUsuario(@Valid Usuario objUsuario, BindingResult binRes) {

		if (binRes.hasErrors()) {
			return "/usuario/frmRegistro";
		} else {
			uService.insertadm(objUsuario);
			return "redirect:/login";
		}
	}

	
	@GetMapping("/listar")
	public String listUsuario(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.list());
			model.addAttribute("listaRoles", rRepository.findAll());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/usuario/frmLista";
	}

	@RequestMapping("/lever/{id}")
	public String changeActivo(@PathVariable int id, Model model) {
		Usuario user = new Usuario();
		user = uRepository.findByidUsuario(id);
		
		if (user.getEnabled()) {
			user.setEnabled(false);
		} else {
			user.setEnabled(true);
		}

		uRepository.save(user);

		return "redirect:/usuarios/listar";
	}
	
	@RequestMapping("/reporteciudadxusuario")
	public String ciudadUsuario(Map<String, Object> model) {
		model.put("reporteLista", uService.ciudadUsuario());
		return "reporte/reportesergio";
	}
}
