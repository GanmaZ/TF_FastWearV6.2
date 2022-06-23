package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.DetalleCompra;

public interface IDetalleCompraService {

	public void insert(DetalleCompra detallecompra);
	public void insertextra(DetalleCompra detallecompra);
	List<DetalleCompra> list();
	public void delete(int idDetallecompra);
	Optional<DetalleCompra> listId(int idDetallecompra);
	public void update(DetalleCompra detallecompra);
}
