package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByCorreoUsuario(String correoUsuario);
	
	@Query(value = "Select * from usuario where id_usuario=:id_usuario", nativeQuery = true)
	public Usuario findByidUsuario(int id_usuario);
	
	@Query(value="Select c.name_ciudad, count(u.id_ciudad) as usuariosporciudad from ciudad c join usuario u on c.id_ciudad= u.id_ciudad group by c.name_ciudad order by 2 desc", nativeQuery=true)
	public List<String[]>ciudadUsuario();
	
	@Query(value="Select u.nombre_usuario as \"Nombre De Usuario\", count(com.id_compra) as \"Numero de Pedidos\", u.correo_usuario as \"Correo Electronico\"\n"
			+ "from usuario u\n"
			+ "inner join compra com on u.id_usuario=com.id_usuario\n"
			+ "where EXTRACT(month FROM com.fecha_compra)>=EXTRACT(month FROM now())\n"
			+ "Group by u.nombre_usuario, u.correo_usuario\n"
			+ "Order by 2 desc", nativeQuery=true)
	public List<String[]>pedidoUsuario(int id_usuario);
	
	
}
