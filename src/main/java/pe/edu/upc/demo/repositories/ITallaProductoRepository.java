package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.TallaProducto;

@Repository
public interface ITallaProductoRepository extends JpaRepository<TallaProducto, Integer> {

	@Query(value = "Select * from talla_producto where id_talla_producto=:id_tallaproducto", nativeQuery = true)
	public TallaProducto findByidTallaProducto(int id_tallaproducto);
}
