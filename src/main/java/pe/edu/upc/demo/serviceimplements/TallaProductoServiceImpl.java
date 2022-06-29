package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.TallaProducto;
import pe.edu.upc.demo.repositories.ITallaProductoRepository;
import pe.edu.upc.demo.serviceinterface.ITallaProductoService;

@Service
public class TallaProductoServiceImpl implements ITallaProductoService {

	@Autowired
	private ITallaProductoRepository tpRepository;

	@Override
	public void insert(TallaProducto tallaproducto) {
		// TODO Auto-generated method stub
		tpRepository.save(tallaproducto);
	}

	
	@Override
	public List<TallaProducto> list() {

		return tpRepository.findAll();
	}

}
