package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByCorreoUsuario(String correoUsuario);
	
	@Query(value = "Select * from usuario where id_usuario=:id_usuario", nativeQuery = true)
	public Usuario findByidUsuario(int id_usuario);
}
