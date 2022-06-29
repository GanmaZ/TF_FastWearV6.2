package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Producto;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IProductoRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository pRepository;
	
	@Autowired
	private IUsuarioRepository userRepository;
	
	@Override
	public void insert(Producto producto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Usuario usuario = userRepository.findByCorreoUsuario(userDetail.getUsername());
		
		producto.setUsuario(usuario);
		pRepository.save(producto);
	}

	@Override
	public List<Producto> list() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Usuario usu = userRepository.findByCorreoUsuario(userDetail.getUsername());
		
		return pRepository.findByidUsuario(usu.getIdUsuario());
	}

}
