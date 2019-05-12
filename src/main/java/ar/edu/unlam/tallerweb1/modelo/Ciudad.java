package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CIUDAD")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CIUDAD")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ubicacion ubicacionGeografica;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Pais pais;
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	public void setUbicacion(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
		
	public Ubicacion getUbicacionGeografica() {
		return this.ubicacionGeografica;
	}	

	public Pais getPais() {
		return this.pais;
	}

}
