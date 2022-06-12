package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoProducto")
public class TipoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoProducto;
	
	@Column(name ="NombreTipoProducto", nullable = false, length = 50)
	private String NombreTipoProducto;

	public TipoProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoProducto(int idTipoProducto, String nombreTipoProducto) {
		super();
		this.idTipoProducto = idTipoProducto;
		NombreTipoProducto = nombreTipoProducto;
	}

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getNombreTipoProducto() {
		return NombreTipoProducto;
	}

	public void setNombreTipoProducto(String nombreTipoProducto) {
		NombreTipoProducto = nombreTipoProducto;
	}
	
	
	
	
}
