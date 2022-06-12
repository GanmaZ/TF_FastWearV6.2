package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Producto;
import pe.edu.upc.demo.repositories.IProductoRepository;
import pe.edu.upc.demo.serviceinterface.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository pRepository;
	
	@Override
	public void insert(Producto producto) {
		pRepository.save(producto);
	}

	@Override
	public List<Producto> list() {
		return pRepository.findAll();
	}

}
