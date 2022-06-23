package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCompra;

	@Column(name = "Total", nullable = false)
	private double Total;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaCompra", nullable = false)
	private Date FechaCompra;
	
	@Column(name = "MetodoPago", nullable = true, length = 200)
	private String MetodoPago;
	
	@ManyToOne
	@JoinColumn(name = "IdUsuario", nullable = false)
	private Usuario usuario;

	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compra(int idCompra, double total, Date fechaCompra, String metodoPago, Usuario usuario) {
		super();
		this.IdCompra = idCompra;
		this.Total = total;
		this.FechaCompra = fechaCompra;
		this.MetodoPago = metodoPago;
		this.usuario = usuario;
	}

	public int getIdCompra() {
		return IdCompra;
	}

	public void setIdCompra(int idCompra) {
		IdCompra = idCompra;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public Date getFechaCompra() {
		return FechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		FechaCompra = fechaCompra;
	}

	public String getMetodoPago() {
		return MetodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}