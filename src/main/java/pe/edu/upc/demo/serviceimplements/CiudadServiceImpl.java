package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Ciudad;
import pe.edu.upc.demo.repositories.ICiudadRepository;
import pe.edu.upc.demo.serviceinterface.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService{
	@Autowired
	private ICiudadRepository ciudadRepository;
	
	@Override
	public void insert(Ciudad ciudad) {
		ciudadRepository.save(ciudad);
	}
	
	@Override
	public List<Ciudad> list() {
		return ciudadRepository.findAll();
	}
	
	@Override
	public void delete(int idCiudad) {
		ciudadRepository.deleteById(idCiudad);
	}

	@Override
	public Optional<Ciudad> listId(int idCiudad) {
		// TODO Auto-generated method stub
		return ciudadRepository.findById(idCiudad);
	}

	@Override
	public void update(Ciudad ciudad) {
		// TODO Auto-generated method stub
		ciudadRepository.save(ciudad);
	}

	@Override
	public List<String[]> CiudadVentas() {
		// TODO Auto-generated method stub
		return ciudadRepository.CiudadVentas();
	}
}
