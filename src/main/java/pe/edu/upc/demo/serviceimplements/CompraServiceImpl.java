package pe.edu.upc.demo.serviceimplements;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Compra;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.ICompraRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.ICompraService;

@Service
public class CompraServiceImpl implements ICompraService {

	@Autowired
	private ICompraRepository cRepository;

	@Autowired
	private IUsuarioRepository userRepository;
	

	@Override
	public Compra insert() {
		Compra compra = new Compra();
		
		long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Usuario usuario = userRepository.findByCorreoUsuario(userDetail.getUsername());

		compra.setUsuario(usuario);
		compra.setFechaCompra(date);
		cRepository.save(compra);
		
		return compra;
	}

	@Override
	public List<Compra> list() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Usuario usu = userRepository.findByCorreoUsuario(userDetail.getUsername());
		
		return cRepository.findByidUsuario(usu.getIdUsuario());
	}
}
