package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTINENTE")
public class Continente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTINENTE")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Continente(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
