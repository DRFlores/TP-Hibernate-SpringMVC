package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class CiudadTest extends SpringTest  {

	@Test @Transactional @Rollback
	public void buscarCiudadesDelHemisferioSurTest() {
		
		Double latitudHemisferioSur = (double) 0;
		
		Ubicacion ubicacionParis = new Ubicacion(48.853400,2.348600);
		Ubicacion ubicacionBsAs  = new Ubicacion(-34.613150,-58.377230);
		Ubicacion ubicacionCDCba = new Ubicacion(-31.4135000,-64.181050);
		
		Ciudad paris = new Ciudad("Paris");
		Ciudad bsas  = new Ciudad("Buenos Aires");
		Ciudad cdcba = new Ciudad("Ciudad de Cordoba");
		
		paris.setUbicacion(ubicacionParis);
		bsas.setUbicacion(ubicacionBsAs);
		cdcba.setUbicacion(ubicacionCDCba);
		
		Session session = getSession();
		
		session.save(cdcba);
		session.save(paris);
		session.save(bsas);
		
		List<Ciudad> ciudadesDelHemisferioSur = new ArrayList <Ciudad>();
		
		ciudadesDelHemisferioSur = getSession().createCriteria(Ciudad.class)
								.createAlias("ubicacionGeografica", "ubicacion")
								.add(Restrictions.lt("ubicacion.latitud", latitudHemisferioSur)).list();
		
		assertThat(ciudadesDelHemisferioSur).hasSize(2);

		
	}

}
