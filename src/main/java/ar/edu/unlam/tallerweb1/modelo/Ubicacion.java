package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UBICACION")
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_UBICACION")
	private Long id;
	
	@Column(name = "LATITUD")
	private Double latitud;
	
	@Column(name = "LONGITUD")
	private Double longitud;
	
	public Ubicacion(Double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public Long getId() {
		return this.id;
	}

	public Double getLatitud() {
		return this.latitud;
	}	

	public Double getLongitud() {
		return this.longitud;
	}

}
