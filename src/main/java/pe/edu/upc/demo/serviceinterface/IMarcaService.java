package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Marca;

public interface IMarcaService {

	public void Insert(Marca marca);

	public List<Marca> list();

	public void delete(int idMarca);

	Optional<Marca> listId(int idMarca);

	public void update(Marca marca);

	public List<String[]> ventasMarca();

}
