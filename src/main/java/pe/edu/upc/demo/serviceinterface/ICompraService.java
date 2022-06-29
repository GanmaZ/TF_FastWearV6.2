package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Compra;

public interface ICompraService {
	
	public Compra insert();
	
	List<Compra> list();

}
