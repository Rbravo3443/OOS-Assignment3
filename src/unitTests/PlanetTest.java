package unitTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import planet.detail.*;
import org.junit.Test;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import planet.detail.Planet;
import planet.detail.PlanetController;

public class PlanetTest {
	//instance variables used for testing
	Planet myPlanet = new Planet("myplanet", "0", "0", 0);
	PlanetController planetcontroller = new PlanetController(myPlanet);
	
	/** Tests **/
	@Test(expected= InvalidPlanetException.class)
	public void testValidPlanetName() throws InvalidPlanetException {	
		myPlanet.setPlanetName("Pl@n3t$");
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidNameLength() throws InvalidPlanetException{
		myPlanet.setPlanetName("");
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidRealNumber() throws InvalidPlanetException{
		myPlanet.setDiameterkm("3.x");
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidDiameterNumber() throws InvalidPlanetException{
		myPlanet.setDiameterkm("200001");
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidColdTemperature()  throws InvalidPlanetException{
		myPlanet.setTemperatureF("-273.16");		
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidHotTemperature()  throws InvalidPlanetException{
		myPlanet.setTemperatureF("501");	
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidNumberOfMoons()  throws InvalidPlanetException{
		myPlanet.setNumberofmoon(1001);
	}
	
	@Test(expected= InvalidPlanetException.class)
	public void testValidNumberOfMoonsNoNegativeNumbers()  throws InvalidPlanetException{
		myPlanet.setNumberofmoon(-1);
	}
	
	@Test
	public void testKilometersToMilesConversion(){
	   assertEquals(74.5645, Double.parseDouble(myPlanet.KM_To_M(120.0)), .5);
	}
	
	@Test
	public void testFahrenheitToCelsiusConversion(){
		String far = myPlanet.Far_To_Cel(220);
		assertEquals(104.444, Double.parseDouble(far), .1);
	}
}
