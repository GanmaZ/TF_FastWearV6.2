package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer> {

	@Query(value = "Select m.nombre_marca, count(dtc.id_talla_producto) as VentasdeMarcas\r\n"
			+ "from marca m join producto p on m.id_marca= p.id_marca \r\n"
			+ "inner join talla_producto t on t.id_producto=p.id_producto\r\n"
			+ "inner join detallecompra dtc on dtc.id_talla_producto= t.id_talla_producto\r\n"
			+ "inner join compra c on c.id_compra=dtc.id_compra\r\n"
			+ "inner join usuario u on u.id_usuario=c.id_usuario \r\n" + "WHERE p.id_usuario =:id_usuario\r\n"
			+ "group by m.id_marca", nativeQuery = true)
	public List<String[]> PedidosMarca(int id_usuario);

}
