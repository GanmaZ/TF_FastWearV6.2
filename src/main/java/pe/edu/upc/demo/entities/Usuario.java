package pe.edu.upc.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUsuario;

	@Column(name = "NombreUsuario", nullable = true, length = 60)
	private String NombreUsuario;

	@Column(name = "ApellidoUsuario", nullable = true, length = 60)
	private String ApellidoUsuario;

	@Column(name = "correoUsuario", nullable = true, length = 60)
	private String correoUsuario;

	@Column(name = "claveUsuario", nullable = true, length = 60)
	private String claveUsuario;

	private Boolean enabled;

	@Column(name = "Telefono", nullable = true, length = 60)
	private String Telefono;

	@Column(name = "NombreEmpresa", nullable = true, length = 47)
	private String NombreEmpresa;

	@Column(name = "RUC", nullable = true, length = 11)
	private String RUC;

	@Column(name = "SedeEmpresa", nullable = true, length = 47)
	private String SedeEmpresa;

	@Column(name = "DireccionEmpresa", nullable = true, length = 47)
	private String DireccionEmpresa;

	@ManyToOne
	@JoinColumn(name = "IdCiudad", nullable = true)
	private Ciudad ciudad;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
			String claveUsuario, Boolean enabled, String telefono, String nombreEmpresa, String rUC, String sedeEmpresa,
			String direccionEmpresa, Ciudad ciudad, List<Role> roles) {
		super();
		IdUsuario = idUsuario;
		this.NombreUsuario = nombreUsuario;
		this.ApellidoUsuario = apellidoUsuario;
		this.correoUsuario = correoUsuario;
		this.claveUsuario = claveUsuario;
		this.enabled = enabled;
		this.Telefono = telefono;
		this.NombreEmpresa = nombreEmpresa;
		this.RUC = rUC;
		this.SedeEmpresa = sedeEmpresa;
		this.DireccionEmpresa = direccionEmpresa;
		this.ciudad = ciudad;
		this.roles = roles;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return ApellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		ApellidoUsuario = apellidoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getNombreEmpresa() {
		return NombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String rUC) {
		RUC = rUC;
	}

	public String getSedeEmpresa() {
		return SedeEmpresa;
	}

	public void setSedeEmpresa(String sedeEmpresa) {
		SedeEmpresa = sedeEmpresa;
	}

	public String getDireccionEmpresa() {
		return DireccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		DireccionEmpresa = direccionEmpresa;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
