package pe.edu.upc.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Marca")

public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMarca;
	
	@Column(name="nombreMarca", nullable = false, length =60)
	private String nombreMarca;
	@Column (name = "descripcionMarca", nullable= false, length =200)
	private String descripcionMarca;

	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marca(int idMarca, String nombreMarca, String descripcionMarca) {
		super();
		this.idMarca = idMarca;
		this.nombreMarca = nombreMarca;
		this.descripcionMarca = descripcionMarca;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}

}
