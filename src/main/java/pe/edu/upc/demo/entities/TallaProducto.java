package pe.edu.upc.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TallaProducto")
public class TallaProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTallaProducto;

	@ManyToOne
	@JoinColumn(name = "IdProducto", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "idTalla", nullable = false)
	private Talla talla;

	public TallaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TallaProducto(int idTallaProducto, Producto producto, Talla talla) {
		super();
		this.idTallaProducto = idTallaProducto;
		this.producto = producto;
		this.talla = talla;
	}

	public int getIdTallaProducto() {
		return idTallaProducto;
	}

	public void setIdTallaProducto(int idTallaProducto) {
		this.idTallaProducto = idTallaProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}
