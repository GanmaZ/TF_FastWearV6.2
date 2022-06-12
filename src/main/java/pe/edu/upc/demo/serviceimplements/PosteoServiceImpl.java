package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Posteo;
import pe.edu.upc.demo.repositories.IPosteoRepository;
import pe.edu.upc.demo.serviceinterface.IPosteoService;

@Service
public class PosteoServiceImpl implements IPosteoService{

	@Autowired
	private IPosteoRepository poRepository;
	
	@Override
	public void insert(Posteo posteo) {
		// TODO Auto-generated method stub
		poRepository.save(posteo);
	}

	@Override
	public List<Posteo> list() {
		// TODO Auto-generated method stub
		return poRepository.findAll();
	}

	@Override
	public void delete(int idPosteo) {
		// TODO Auto-generated method stub
		poRepository.deleteById(idPosteo);
	}

	@Override
	public Optional<Posteo> listId(int idPosteo) {
		// TODO Auto-generated method stub
		return poRepository.findById(idPosteo);
	}

	@Override
	public void update(Posteo posteo) {
		// TODO Auto-generated method stub
		poRepository.save(posteo);
	}

}
