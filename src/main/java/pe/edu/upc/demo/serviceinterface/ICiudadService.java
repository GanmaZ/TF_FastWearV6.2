package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Ciudad;

public interface ICiudadService {

	public void insert(Ciudad ciudad);
	
	public List<Ciudad> list();
	
	public void delete(int idCiudad);
	
	Optional<Ciudad> listId(int idCiudad);
	
	public void update(Ciudad ciudad);
	
	public List<String[]> CiudadVentas();
}

