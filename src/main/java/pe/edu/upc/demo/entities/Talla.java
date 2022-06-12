package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Talla")
public class Talla {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTalla;

	@Column(name = "nombreTalla", nullable = false, length = 47)
	private String nombreTalla;

	public Talla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Talla(int idTalla, String nombreTalla) {
		super();
		this.idTalla = idTalla;
		this.nombreTalla = nombreTalla;
	}

	public int getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	public String getNombreTalla() {
		return nombreTalla;
	}

	public void setNombreTalla(String nombreTalla) {
		this.nombreTalla = nombreTalla;
	}

	
}
