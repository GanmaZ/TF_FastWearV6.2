package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository uRepository;

	@Autowired
	private IRoleRepository rRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void insert(Usuario usuario) {

		if (usuario.getNombreEmpresa() != null) {
			usuario.setEnabled(true);
			usuario.setClaveUsuario(passwordEncoder.encode(usuario.getClaveUsuario()));
			uRepository.save(usuario);

			Role rol = new Role();

			rol.setRol("ROLE_EMPRESA");
			rol.setUser_id(usuario.getIdUsuario());
			rRepository.save(rol);

		} else {
			usuario.setEnabled(true);
			usuario.setClaveUsuario(passwordEncoder.encode(usuario.getClaveUsuario()));
			uRepository.save(usuario);

			Role rol = new Role();

			rol.setRol("ROLE_USER");
			rol.setUser_id(usuario.getIdUsuario());
			rRepository.save(rol);
		}

	}

	@Override
	public List<Usuario> list() {
		return uRepository.findAll();
	}

	@Override
	public void insertadm(Usuario usuario) {
		if (usuario.getNombreEmpresa() != null) {
			usuario.setEnabled(true);
			usuario.setClaveUsuario(passwordEncoder.encode(usuario.getClaveUsuario()));
			uRepository.save(usuario);

			Role rol = new Role();

			rol.setRol("ROLE_EMPRESA");
			rol.setUser_id(usuario.getIdUsuario());
			rRepository.save(rol);

		} else {
			usuario.setEnabled(true);
			usuario.setClaveUsuario(passwordEncoder.encode(usuario.getClaveUsuario()));
			uRepository.save(usuario);

			Role rol = new Role();

			rol.setRol("ROLE_USER");
			rol.setUser_id(usuario.getIdUsuario());
			rRepository.save(rol);
		}

	}

	@Override
	public List<String[]> ciudadUsuario() {
		// TODO Auto-generated method stub
		return uRepository.ciudadUsuario();
	}

}
