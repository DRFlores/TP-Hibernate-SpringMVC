package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class UbicacionTest extends SpringTest {
	
	@Test @Transactional @Rollback
	public void buscarPaisesConCapitalAlNorteDelTropicoDeCancerTest() {
		
		Double latitudTropicoDeCancer = 23.437222;
		
		Ubicacion ubicacionParis = new Ubicacion(48.853400,2.348600);
		Ubicacion ubicacionBsAs  = new Ubicacion(-34.613150,-58.377230);
		Ubicacion ubicacionTokio = new Ubicacion(35.689500,139.691710);
		
		Ciudad paris = new Ciudad("Paris");
		Ciudad bsas  = new Ciudad("Buenos Aires");
		Ciudad tokio = new Ciudad("Tokio");
		
		paris.setUbicacion(ubicacionParis);
		bsas.setUbicacion(ubicacionBsAs);
		tokio.setUbicacion(ubicacionTokio);		
		
		Pais francia   = new Pais("Francia");
		Pais argentina = new Pais("Argentina");
		Pais japon     = new Pais("Japon");
		
		francia.setCapital(paris);
		argentina.setCapital(bsas);
		japon.setCapital(tokio);
		
		Session session = getSession();
		
		session.save(francia);
		session.save(argentina);
		session.save(japon);
		
		List<Pais> paisesConCapitalAlNorteDelTropicoDeCancer = new ArrayList <Pais>();
		
		Criteria paisesCriteria = getSession().createCriteria(Pais.class)
						.createAlias("capital", "ciudad")
						.createAlias("ciudad.ubicacionGeografica", "ubicacion")
						.add(Restrictions.gt("ubicacion.latitud", latitudTropicoDeCancer));
		
		paisesConCapitalAlNorteDelTropicoDeCancer = paisesCriteria.list();			
		assertThat(paisesConCapitalAlNorteDelTropicoDeCancer).hasSize(2);

		
		
		
	}
	

}
