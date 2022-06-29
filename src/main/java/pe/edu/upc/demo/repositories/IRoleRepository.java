package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.demo.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
	@Query(value = "Select * from roles where user_id=:id_usuario", nativeQuery = true)
	public Role findByidUsuario(int id_usuario);
}
