package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Categoria;
import pe.edu.upc.demo.repositories.ICategoriaRepository;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	@Autowired
	private ICategoriaRepository cRepository;
	
	@Override
	public void insert(Categoria categoria) {
		cRepository.save(categoria);
	}

	@Override
	public List<Categoria> list() {
		return cRepository.findAll();
	}

	@Override
	public void delete(int id) {
		cRepository.deleteById(id);	
	}

	@Override
	public Optional<Categoria> listId(int IdCategoria) {
		return cRepository.findById(IdCategoria);
	}

	@Override
	public void update(Categoria categoria) {
		cRepository.save(categoria);
	}

}
