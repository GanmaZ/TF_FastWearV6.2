package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.DetalleCompra;
import pe.edu.upc.demo.repositories.IDetalleCompraRepository;
import pe.edu.upc.demo.serviceinterface.IDetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService{

	@Autowired
	private IDetalleCompraRepository deRepository;
	
	@Override
	public void insert(DetalleCompra detallecompra) {
		// TODO Auto-generated method stub
		deRepository.save(detallecompra);
	}

	@Override
	public List<DetalleCompra> list() {
		// TODO Auto-generated method stub
		return deRepository.findAll();
	}

	@Override
	public void delete(int idDetallecompra) {
		// TODO Auto-generated method stub
		deRepository.deleteById(idDetallecompra);
	}

	@Override
	public Optional<DetalleCompra> listId(int idDetallecompra) {
		// TODO Auto-generated method stub
		return deRepository.findById(idDetallecompra);
	}

	@Override
	public void update(DetalleCompra detallecompra) {
		// TODO Auto-generated method stub
		deRepository.save(detallecompra);
	}

}
