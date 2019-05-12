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
@Table(name = "PAIS")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAIS")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="HABITANTES")
	private Integer habitantes;

	@Column(name="IDIOMA")   
	private String idioma;

	@OneToOne(cascade = CascadeType.ALL)
	private Ciudad capital;

	@ManyToOne(cascade = CascadeType.ALL)
	private Continente continente;
	
	public Pais(String nombre) {
		this.nombre = nombre;
	}
	
	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public void setCapital(Ciudad capital) {
		this.capital = capital;		
	}
	
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getHabitantes() {
		return this.habitantes;
	}
	
	public String getIdioma() {
		return this.idioma;
	}
	
	public Ciudad getCapital() {
		return this.capital;
	}
	
	public Continente getContinente() {
		return this.continente;
	}

}
