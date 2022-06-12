package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.TipoProducto;
import pe.edu.upc.demo.repositories.ITipoProductoRepo;
import pe.edu.upc.demo.serviceinterface.ITipoProductoService;

@Service
public class TipoProductoServiceImpls implements ITipoProductoService{

	@Autowired
	private ITipoProductoRepo tipoproductoRepository;
	
	@Override
	public void insert(TipoProducto tipoproducto) {
		tipoproductoRepository.save(tipoproducto);
		
	}

	@Override
	public List<TipoProducto> list() {
		// TODO Auto-generated method stub
		return tipoproductoRepository.findAll();
	}

	@Override
	public void delete(int idTipoProducto) {
		// TODO Auto-generated method stub
		tipoproductoRepository.deleteById(idTipoProducto);
	}

	@Override
	public Optional<TipoProducto> listId(int idTipoProducto) {
		// TODO Auto-generated method stub
		return tipoproductoRepository.findById(idTipoProducto);
	}

	@Override
	public void update(TipoProducto tipoproducto) {
		// TODO Auto-generated method stub
		tipoproductoRepository.save(tipoproducto);
	}

	

}
