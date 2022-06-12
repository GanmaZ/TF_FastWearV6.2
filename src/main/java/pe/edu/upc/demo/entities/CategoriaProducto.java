package pe.edu.upc.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="CategoriaProducto")
public class CategoriaProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoriaProducto;
	
	@ManyToOne
	@JoinColumn(name = "IdProducto", nullable = false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;

	public CategoriaProducto() {
		super();
		//TODO Auto-generated constructor stub
	}

	public CategoriaProducto(int idCategoriaProducto, Producto producto, Categoria categoria) {
		super();
		this.idCategoriaProducto = idCategoriaProducto;
		this.producto = producto;
		this.categoria = categoria;
	}

	public int getIdCategoriaProducto() {
		return idCategoriaProducto;
	}

	public void setIdCategoriaProducto(int idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
