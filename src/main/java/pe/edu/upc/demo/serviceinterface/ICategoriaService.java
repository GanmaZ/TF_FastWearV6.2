package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Categoria;

public interface ICategoriaService {

	public void insert(Categoria categoria);
	
	public List<Categoria> list();
	
	public void delete(int id);
	
	Optional<Categoria> listId(int IdCategoria);
	
	public void update(Categoria categoria);
}
