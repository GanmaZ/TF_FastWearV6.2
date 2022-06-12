package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.CategoriaProducto;

public interface ICategoriaProductoService {
	
	public void insert(CategoriaProducto categoriaproducto);
	
	public List<CategoriaProducto> list();
	

}
