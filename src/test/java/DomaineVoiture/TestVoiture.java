package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 0, 10);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getPositionEnX());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesseMetreSeconde());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesseMetreSeconde());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getPositionEnX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getPositionEnX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getPositionEnX());
		
	}
    @Test
    public void testBase2D() {
        maVoiture = new Voiture(0,0,100);
        maVoiture.setDirection(0);
        maVoiture.miseAJourPosition();
        assertEquals(100, maVoiture.getPositionEnX());

    }

    @Test
    public void testDirection90Degrees() {
        maVoiture = new Voiture(0,100,10);
        maVoiture.setDirection(90);
        maVoiture.miseAJourPosition();
        assertEquals(90, maVoiture.getPositionEnY());

    }

    @Test
    public void testDirection30Degrees() {
        maVoiture = new Voiture(0,100,100);
        maVoiture.setDirection(30);
        maVoiture.miseAJourPosition();
        assertEquals(86, maVoiture.getPositionEnX());
        assertEquals(51, maVoiture.getPositionEnY());

    }

	
}
