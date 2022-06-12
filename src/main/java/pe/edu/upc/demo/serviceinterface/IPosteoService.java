package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Posteo;

public interface IPosteoService {

	public void insert(Posteo posteo);
	List<Posteo> list();
	public void delete(int idPosteo);
	Optional<Posteo> listId(int idPosteo);
	public void update(Posteo posteo);
}
