package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Compra;

public interface ICompraService {
	
	public void insert(Compra compra);
	
	List<Compra> list();
}
