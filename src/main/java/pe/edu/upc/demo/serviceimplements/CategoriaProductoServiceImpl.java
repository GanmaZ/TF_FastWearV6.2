package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.CategoriaProducto;
import pe.edu.upc.demo.repositories.ICategoriaProductoRepository;
import pe.edu.upc.demo.serviceinterface.ICategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements ICategoriaProductoService {

	
	@Autowired
	private ICategoriaProductoRepository cpRepository;
	
	@Override
	public void insert(CategoriaProducto categoriaproducto) {
		// TODO Auto-generated method stub
		cpRepository.save(categoriaproducto);
		
	}

	@Override
	public List<CategoriaProducto> list() {
		// TODO Auto-generated method stub
		return cpRepository.findAll();
	}

}
