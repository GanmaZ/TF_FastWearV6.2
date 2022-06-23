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

import pe.edu.upc.demo.entities.Posteo;
import pe.edu.upc.demo.repositories.IPosteoRepository;
import pe.edu.upc.demo.serviceinterface.IPosteoService;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/posteos")
public class PosteoController {

	@Autowired
	private IUsuarioService uService;

	@Autowired
	private IPosteoService pService;

	@Autowired
	private IPosteoRepository pRepository;

	@GetMapping("/nuevo")
	public String newPosteo(Model model) {
		model.addAttribute("posteo", new Posteo());
		model.addAttribute("listaUsuarios", uService.list());

		return "/posteo/frmRegistro";
	}

	@PostMapping("/guardar")
	public String savePosteo(@Valid Posteo objPosteo, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/posteo/frmRegistro";
		} else {
			pService.insert(objPosteo);
			return "redirect:/posteos/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listPosteo(Model model) {
		try {
			model.addAttribute("listaPosteos", pService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/posteo/frmLista";
	}

	@RequestMapping("/reaccionp/{id}")
	public String newreaccionp(@PathVariable int id, Model model) {

		Posteo post = new Posteo();
		post = pRepository.findByidPosteo(id);

		post.setCantidadReaccion(post.getCantidadReaccion() + 1);
		pRepository.save(post);

		try {
			model.addAttribute("listaPosteos", pService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return ("posteo/frmLista");
	}

	@RequestMapping("/reaccionn/{id}")
	public String newreaccionn(@PathVariable int id, Model model) {
		Posteo post = new Posteo();
		post = pRepository.findByidPosteo(id);
		
		if (post.getCantidadReaccion() != 0) {
			post.setCantidadReaccion(post.getCantidadReaccion() - 1);
			pRepository.save(post);
		}
		try {
			model.addAttribute("listaPosteos", pService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return ("posteo/frmLista");
	}

	@RequestMapping("/eliminar")
	public String deletePosteo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.delete(id);
				model.put("listaPosteos", pService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "posteo/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Posteo> objPos = pService.listId(id);
		model.addAttribute("post", objPos.get());
		return "posteo/frmActualiza";

	}

	@PostMapping("/modificar")
	public String updatePosteo(Posteo po) {
		pService.update(po);
		return "redirect:/posteos/listar";
	}

}
