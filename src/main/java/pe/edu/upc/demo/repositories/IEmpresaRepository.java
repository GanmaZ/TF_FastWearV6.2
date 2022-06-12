package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
	public Empresa findByCorreoEmpresa(String correoEmpresa);

}
