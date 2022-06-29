package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Ciudad;
@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
	@Query(value="Select ciu.name_ciudad, count(dtc.id_detalle_compra) as ventasporciudad\r\n"
			+ "from ciudad ciu join usuario u on ciu.id_ciudad= u.id_ciudad \r\n"
			+ "inner join compra com on u.id_usuario=com.id_usuario\r\n"
			+ "inner join detallecompra dtc on dtc.id_compra= com.id_compra\r\n"
			+ "group by ciu.name_ciudad", nativeQuery=true)
	public List<String[]> CiudadVentas(); 
}
