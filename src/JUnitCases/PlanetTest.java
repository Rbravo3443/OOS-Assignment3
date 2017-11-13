package JUnitCases;

import static org.junit.Assert.*;

import org.junit.Test;

import planet.detail.InvalidPlanetException;
import planet.detail.Planet;

public class PlanetTest {

	@Test(expected = InvalidPlanetException.class)
	public void TestPlanetCreation() {
		Planet planet = new Planet("j<2~`", "-", " ", 2);
	}
	
	@Test
	public void Test()
	{
		
	}

}
