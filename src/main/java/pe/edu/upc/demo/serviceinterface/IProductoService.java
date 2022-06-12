package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Producto;

public interface IProductoService {
	
	public void insert(Producto producto);
	
	List<Producto> list();

}
