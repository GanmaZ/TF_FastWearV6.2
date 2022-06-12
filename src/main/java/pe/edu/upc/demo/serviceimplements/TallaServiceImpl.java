package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Talla;
import pe.edu.upc.demo.repositories.ITallaRepository;
import pe.edu.upc.demo.serviceinterface.ITallaService;

@Service
public class TallaServiceImpl implements ITallaService {

	@Autowired
	private ITallaRepository tallaRepository;

	@Override
	public List<Talla> list() {
		// TODO Auto-generated method stub
		return tallaRepository.findAll();
	}

	@Override
	public void insert(Talla talla) {
		// TODO Auto-generated method stub
		tallaRepository.save(talla);
	}

	@Override
	public void delete(int idTalla) {
		// TODO Auto-generated method stub
		tallaRepository.deleteById(idTalla);
	}

	@Override
	public Optional<Talla> listId(int idTalla) {
		// TODO Auto-generated method stub
		return tallaRepository.findById(idTalla);
	}

	@Override
	public void update(Talla talla) {
		// TODO Auto-generated method stub
		tallaRepository.save(talla);
	}

}
