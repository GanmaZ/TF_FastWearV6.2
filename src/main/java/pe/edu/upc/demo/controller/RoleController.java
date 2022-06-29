package pe.edu.upc.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private IUsuarioRepository uRepository;
	@Autowired
	private IRoleRepository rRepository;
	
	int ida;
	Role rolaux;

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		ida = id;
		rolaux = rRepository.findByidUsuario(id);
		
		Usuario objusr = uRepository.findByidUsuario(id);
		model.addAttribute("usuario", objusr);
		model.addAttribute("rol", rolaux);
		return ("usuario/frmActualiza");
	}

	@PostMapping("/modificar")
	public String updateUsuario(Role r) {
		
		r.setId(rolaux.getId());
		r.setUser_id(ida);
		
		rRepository.save(r);
		return "redirect:/usuarios/listar";

	}
}
