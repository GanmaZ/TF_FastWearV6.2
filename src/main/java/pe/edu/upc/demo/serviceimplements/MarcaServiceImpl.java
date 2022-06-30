package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Marca;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IMarcaRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService {

	@Autowired
	private IMarcaRepository marcaRepository;

	@Autowired
	private IUsuarioRepository uRepository;

	@Override
	public void Insert(Marca marca) {
		marcaRepository.save(marca);

	}

	@Override
	public List<Marca> list() {
		// TODO Auto-generated method stub
		return marcaRepository.findAll();
	}

	@Override
	public void delete(int idMarca) {
		marcaRepository.deleteById(idMarca);

	}

	@Override
	public Optional<Marca> listId(int idMarca) {
		// TODO Auto-generated method stub
		return marcaRepository.findById(idMarca);
	}

	@Override
	public void update(Marca marca) {
		marcaRepository.save(marca);

	}

	@Override
	public List<String[]> ventasMarca() {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Usuario usuario = uRepository.findByCorreoUsuario(userDetail.getUsername());
		return marcaRepository.PedidosMarca(usuario.getIdUsuario());
	}

}
