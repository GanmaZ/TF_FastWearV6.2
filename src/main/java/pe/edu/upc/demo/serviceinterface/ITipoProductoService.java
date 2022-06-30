package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.TipoProducto;

public interface ITipoProductoService {

	public void insert(TipoProducto tipoproducto);
	public List<TipoProducto> list();
	public List<String[]> reporte();
	public void delete(int idTipoProducto);
	Optional<TipoProducto> listId(int idTipoProducto);
	public void update(TipoProducto tipoproducto);
}
