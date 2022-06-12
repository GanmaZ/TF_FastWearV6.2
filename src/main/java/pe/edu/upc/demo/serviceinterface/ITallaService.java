package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Talla;

public interface ITallaService {

	public void insert(Talla talla);

	public List<Talla> list();

	public void delete(int idTalla);

	Optional<Talla> listId(int idTalla);

	public void update(Talla talla);
}
