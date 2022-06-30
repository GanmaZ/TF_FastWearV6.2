package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Usuario;

public interface IUsuarioService {
	
	public void insert(Usuario usuario);
	
	public void insertadm(Usuario usuario);
	
	List<Usuario> list();
	
	public List<String[]> ciudadUsuario();
	
	public List<String[]> pedidoUsuario();
	
	

}
