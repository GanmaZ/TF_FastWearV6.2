package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{
	@Query(value = "Select * from producto where id_usuario=:id_usuario", nativeQuery = true)
	public List<Producto> findByidUsuario(int id_usuario);
	
	@Query(value = "Select * from producto where id_producto=:id_producto", nativeQuery = true)
	public Producto findByidProducto(int id_producto);
}
