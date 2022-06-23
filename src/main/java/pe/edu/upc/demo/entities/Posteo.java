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
@Table(name = "Posteo")
public class Posteo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPosteo;

	@Column(name = "DescripcionPosteo", nullable = false, length = 80)
	private String DescripcionPosteo;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaPosteo", nullable = false)
	private Date FechaPosteo;

	@Column(name = "CantidadReaccion", nullable = false)
	private int CantidadReaccion;

	@ManyToOne
	@JoinColumn(name = "IdUsuario", nullable = true)
	private Usuario usuario;

	public Posteo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Posteo(int idPosteo, String descripcionPosteo, Date fechaPosteo, int cantidadReaccion, Usuario usuario) {
		super();
		this.IdPosteo = idPosteo;
		this.DescripcionPosteo = descripcionPosteo;
		this.FechaPosteo = fechaPosteo;
		this.CantidadReaccion = cantidadReaccion;
		this.usuario = usuario;
	}

	public int getIdPosteo() {
		return IdPosteo;
	}

	public void setIdPosteo(int idPosteo) {
		IdPosteo = idPosteo;
	}

	public String getDescripcionPosteo() {
		return DescripcionPosteo;
	}

	public void setDescripcionPosteo(String descripcionPosteo) {
		DescripcionPosteo = descripcionPosteo;
	}

	public Date getFechaPosteo() {
		return FechaPosteo;
	}

	public void setFechaPosteo(Date fechaPosteo) {
		FechaPosteo = fechaPosteo;
	}

	public int getCantidadReaccion() {
		return CantidadReaccion;
	}

	public void setCantidadReaccion(int cantidadReaccion) {
		CantidadReaccion = cantidadReaccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
