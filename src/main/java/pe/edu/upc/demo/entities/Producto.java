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
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdProducto;

	@Column(name = "NombreProducto", nullable = false, length = 60)
	private String NombreProducto;

	@Column(name = "DescripcionProducto", nullable = true, length = 200)
	private String DescripcionProducto;

	@Column(name = "PrecioProducto", nullable = false)
	private double PrecioProducto;
	
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "AnioProduccion", nullable = false)
	private Date AnioProduccion;

	@ManyToOne
	@JoinColumn(name = "IdMarca", nullable = false)
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "IdTipoProducto", nullable = false)
	private TipoProducto tipoProducto;

	@ManyToOne
	@JoinColumn(name = "IdUsuario", nullable = false)
	private Usuario usuario;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int idProducto, String nombreProducto, String descripcionProducto, double precioProducto,
			Date anioProduccion, Marca marca, TipoProducto tipoProducto, Usuario usuario) {
		super();
		this.IdProducto = idProducto;
		this.NombreProducto = nombreProducto;
		this.DescripcionProducto = descripcionProducto;
		this.PrecioProducto = precioProducto;
		this.AnioProduccion = anioProduccion;
		this.marca = marca;
		this.tipoProducto = tipoProducto;
		this.usuario = usuario;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return DescripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		DescripcionProducto = descripcionProducto;
	}

	public double getPrecioProducto() {
		return PrecioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		PrecioProducto = precioProducto;
	}

	public Date getAnioProduccion() {
		return AnioProduccion;
	}

	public void setAnioProduccion(Date anioProduccion) {
		AnioProduccion = anioProduccion;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
