package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class PaisTest extends SpringTest{

	@Test @Transactional @Rollback
	public void buscarPaisesDeHablaInglesa() {
		
		Pais eeuu      = new Pais("Estados Unidos");
		Pais argentina = new Pais("Argentina");
		Pais australia = new Pais("Australia");
		
		eeuu.setIdioma("Ingles");
		argentina.setIdioma("Español");
		australia.setIdioma("Ingles");
		
		Session session = getSession();
		session.save(eeuu);
		session.save(argentina);
		session.save(australia);
		
		@SuppressWarnings("unchecked")
		List<Pais> paisesDeHablaInglesa = session.createCriteria(Pais.class).add(Restrictions.eq("idioma","Ingles")).list();
		
		assertThat(paisesDeHablaInglesa).hasSize(2);
		
	}

}
