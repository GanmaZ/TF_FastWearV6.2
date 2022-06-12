package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.repositories.IEmpresaRepository;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.serviceinterface.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private IEmpresaRepository empresaRepository;

	@Autowired
	private IRoleRepository rRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void insert(Empresa empresa) {
		empresa.setEnabled(true);
		empresa.setClaveEmpresa(passwordEncoder.encode(empresa.getClaveEmpresa()));
		empresaRepository.save(empresa);

		Role rol = new Role();

		rol.setRol("ROLE_EMPRESA");
		rol.setEmpresa_id(empresa.getIdEmpresa());
		rol.setUser_id(1);
		rRepository.save(rol);
	}

	@Override
	public List<Empresa> list() {
		return empresaRepository.findAll();
	}

	@Override
	public void delete(int idEmpresa) {
		empresaRepository.deleteById(idEmpresa);
	}

	@Override
	public Optional<Empresa> listId(int idEmpresa) {
		return empresaRepository.findById(idEmpresa);
	}

	@Override
	public void update(Empresa empresa) {
		empresaRepository.save(empresa);
	}

}
