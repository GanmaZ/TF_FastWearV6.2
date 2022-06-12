package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thymeleaf.exceptions.TemplateInputException;

import pe.edu.upc.demo.entities.Compra;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer>{

}
