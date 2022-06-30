package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.TipoProducto;

@Repository
public interface ITipoProductoRepo extends JpaRepository<TipoProducto, Integer> {

	@Query(value = "Select tp.nombre_tipo_producto,\r\n"
			+ "Count (tllp.id_talla_producto)\r\n"
			+ "from tipo_producto tp \r\n"
			+ "INNER JOIN producto pr ON pr.id_tipo_producto = tp.id_tipo_producto \r\n"
			+ "INNER JOIN talla_producto tllp ON tllp.id_producto = pr.id_producto\r\n"
			+ "INNER JOIN detallecompra dc ON dc.id_talla_producto = tllp.id_talla_producto \r\n"
			+ "WHERE pr.id_usuario =:id_usuario\r\n"
			+ "GROUP BY tp.nombre_tipo_producto\r\n"
			+ "Order by Count (tllp.id_talla_producto) DESC", nativeQuery = true)
	public List<String[]> reportetipoproductoeventa(int id_usuario);

}
