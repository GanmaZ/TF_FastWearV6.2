package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCiudad;
	
	@Column(name = "NameCiudad", nullable = false, length = 44)
	private String NameCiudad;
	
	
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ciudad(int idCiudad, String nameCiudad) {
		super();
		this.idCiudad = idCiudad;
		NameCiudad = nameCiudad;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNameCiudad() {
		return NameCiudad;
	}

	public void setNameCiudad(String nameCiudad) {
		NameCiudad = nameCiudad;
	}
	
	
}
