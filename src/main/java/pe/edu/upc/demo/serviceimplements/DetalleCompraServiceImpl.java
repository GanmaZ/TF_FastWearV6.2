package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Compra;
import pe.edu.upc.demo.entities.DetalleCompra;
import pe.edu.upc.demo.entities.Producto;
import pe.edu.upc.demo.entities.TallaProducto;
import pe.edu.upc.demo.repositories.ICompraRepository;
import pe.edu.upc.demo.repositories.IDetalleCompraRepository;
import pe.edu.upc.demo.repositories.IProductoRepository;
import pe.edu.upc.demo.repositories.ITallaProductoRepository;
import pe.edu.upc.demo.serviceinterface.IDetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService {

	@Autowired
	private IDetalleCompraRepository deRepository;

	@Autowired
	private CompraServiceImpl cService;

	@Autowired
	private ICompraRepository cRepository;

	@Autowired
	private ITallaProductoRepository tRepository;

	@Autowired
	private IProductoRepository pRepository;

	@Override
	public void insert(DetalleCompra detallecompra) {
		Compra comp = new Compra();
		TallaProducto tp = new TallaProducto();
		Producto pro = new Producto();

		detallecompra.setCompra(cService.insert());
		comp = detallecompra.getCompra();
		tp = tRepository.findByidTallaProducto(detallecompra.getTallaProducto().getIdTallaProducto());
		pro = pRepository.findByidProducto(tp.getProducto().getIdProducto());

		detallecompra.setImporte(pro.getPrecioProducto()*detallecompra.getCantidad());

		deRepository.save(detallecompra);

		comp.setTotal(detallecompra.getImporte());

		cRepository.save(comp);
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

	@Override
	public void insertextra(DetalleCompra detallecompra) {
		Compra comp = new Compra();
		TallaProducto tp = new TallaProducto();
		Producto pro = new Producto();

		comp = detallecompra.getCompra();
		System.out.println(detallecompra.getTallaProducto().getIdTallaProducto());
		
		tp = tRepository.findByidTallaProducto(detallecompra.getTallaProducto().getIdTallaProducto());
		pro = pRepository.findByidProducto(tp.getProducto().getIdProducto());

		detallecompra.setImporte(pro.getPrecioProducto()*detallecompra.getCantidad());

		deRepository.save(detallecompra);

		comp.setTotal(comp.getTotal() + detallecompra.getImporte());

		cRepository.save(comp);
	}

}
