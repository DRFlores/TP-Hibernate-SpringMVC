package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class ContinenteTest extends SpringTest{

	@Test @Transactional @Rollback
	public void buscarPaisesDelContinenteEuropeo() {
		
		Pais francia   = new Pais("Francia");
		Pais argentina = new Pais("Argentina");
		Pais alemania  = new Pais("Alemania");
		
		Continente europa  = new Continente("Europa");
		Continente america = new Continente("America");
		
		francia.setContinente(europa);
		argentina.setContinente(america);
		alemania.setContinente(europa);
		
		Session session = getSession();
		
		session.save(francia);
		session.save(argentina);
		session.save(alemania);
		
		@SuppressWarnings("unchecked")
		List<Pais> paisesEuropeos = session.createCriteria(Pais.class).add(Restrictions.eq("continente", europa)).list();
		
		assertThat(paisesEuropeos).hasSize(2);
		
	}

}
