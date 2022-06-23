package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Posteo;

@Repository
public interface IPosteoRepository extends JpaRepository<Posteo, Integer>{
	@Query(value = "Select * from posteo where id_posteo=:id_posteo", nativeQuery = true)
	public Posteo findByidPosteo(int id_posteo);
}
