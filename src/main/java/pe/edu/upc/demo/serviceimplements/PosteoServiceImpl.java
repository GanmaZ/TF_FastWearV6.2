package pe.edu.upc.demo.serviceimplements;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Posteo;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IPosteoRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.IPosteoService;

@Service
public class PosteoServiceImpl implements IPosteoService{

	@Autowired
	private IPosteoRepository poRepository;
	
	@Autowired
	private IUsuarioRepository userRepository;
	
	@Override
	public void insert(Posteo posteo) {
		
		long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		Usuario usuario = userRepository.findByCorreoUsuario(userDetail.getUsername());

		posteo.setUsuario(usuario);
		posteo.setFechaPosteo(date);
		poRepository.save(posteo);
	}

	@Override
	public List<Posteo> list() {
		// TODO Auto-generated method stub
		return poRepository.findAll();
	}

	@Override
	public void delete(int idPosteo) {
		// TODO Auto-generated method stub
		poRepository.deleteById(idPosteo);
	}

	@Override
	public Optional<Posteo> listId(int idPosteo) {
		// TODO Auto-generated method stub
		return poRepository.findById(idPosteo);
	}

	@Override
	public void update(Posteo posteo) {
		// TODO Auto-generated method stub
		poRepository.save(posteo);
	}

}
