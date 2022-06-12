package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Empresa;

public interface IEmpresaService {

	public void insert(Empresa empresa);

	public List<Empresa> list();

	public void delete(int idEmpresa);

	Optional<Empresa> listId(int idEmpresa);

	public void update(Empresa empresa);

}
