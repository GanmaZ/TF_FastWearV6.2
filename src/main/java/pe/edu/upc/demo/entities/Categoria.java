package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCategoria;

	@Column(name = "NombreCategoria", nullable = false, length = 50)
	private String NombreCategoria;
	@Column(name = "DescripcionCategoria", nullable = true, length = 150)
	private String DescripcionCategoria;
	
	public Categoria() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	public Categoria(int idCategoria, String nombreCategoria, String descripcionCategoria) {
		super();
		this.IdCategoria = idCategoria;
		this.NombreCategoria = nombreCategoria;
		this.DescripcionCategoria = descripcionCategoria;
	}
	public int getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return NombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}
	public String getDescripcionCategoria() {
		return DescripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		DescripcionCategoria = descripcionCategoria;
	}
	
	
}
