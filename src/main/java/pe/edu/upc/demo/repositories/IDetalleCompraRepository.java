package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.DetalleCompra;

@Repository
public interface IDetalleCompraRepository extends JpaRepository<DetalleCompra, Integer>{
	
	@Query(value = "Select * from detallecompra where id_compra=:id_compra", nativeQuery = true)
	public List<DetalleCompra> findByidCompra(int id_compra);

}
