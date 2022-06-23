package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detallecompra")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDetalleCompra;

	@Column(name = "Importe", nullable = false)
	private double Importe;

	@Column(name = "Cantidad", nullable = false)
	private int Cantidad;

	@Column(name = "MetodoPago", nullable = true, length = 200)
	private String MetodoPago;

	@ManyToOne
	@JoinColumn(name = "IdProducto", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "IdCompra", nullable = false)
	private Compra compra;

	public DetalleCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleCompra(int idDetalleCompra, double importe, int cantidad, String metodoPago, Producto producto,
			Compra compra) {
		super();
		this.IdDetalleCompra = idDetalleCompra;
		this.Importe = importe;
		this.Cantidad = cantidad;
		this.MetodoPago = metodoPago;
		this.producto = producto;
		this.compra = compra;
	}

	public int getIdDetalleCompra() {
		return IdDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		IdDetalleCompra = idDetalleCompra;
	}

	public double getImporte() {
		return Importe;
	}

	public void setImporte(double importe) {
		Importe = importe;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getMetodoPago() {
		return MetodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}
