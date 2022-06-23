package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Compra;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer> {
	@Query(value = "Select * from compra where id_usuario=:id_usuario", nativeQuery = true)
	public List<Compra> findByidUsuario(int id_usuario);
	
	@Query(value = "Select * from compra where id_compra=:id_compra", nativeQuery = true)
	public Compra findByidCompra(int id_compra);
}
