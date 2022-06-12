package pe.edu.upc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Producto;
import pe.edu.upc.demo.serviceinterface.IEmpresaService;
import pe.edu.upc.demo.serviceinterface.IMarcaService;
import pe.edu.upc.demo.serviceinterface.IProductoService;
import pe.edu.upc.demo.serviceinterface.ITipoProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IMarcaService mService;
	@Autowired
	private IEmpresaService eService;
	@Autowired
	private ITipoProductoService tpService;
	@Autowired
	private IProductoService pService;
	
	@GetMapping("/nuevo")
	public String newProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("listaMarcas", mService.list());
		model.addAttribute("listaEmpresas", eService.list());
		model.addAttribute("listaTipoProductos", tpService.list());
		return "/producto/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveProducto(@Valid Producto objProducto, BindingResult binRes) {
		
		if(binRes.hasErrors()) {
			return"/producto/frmRegistro";
		}
		else {
			pService.insert(objProducto);
			return "redirect:/productos/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listProducto(Model model) {
		try {
			model.addAttribute("listaProductos", pService.list());
		
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/producto/frmLista";
	}
	
}
