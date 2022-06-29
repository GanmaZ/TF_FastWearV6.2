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
}
