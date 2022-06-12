package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.TallaProducto;

public interface ITallaProductoService {

	public void insert(TallaProducto tallaproducto);

	public List<TallaProducto> list();
}
