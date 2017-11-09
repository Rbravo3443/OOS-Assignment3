package planet.detail;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Planet {
	private SimpleStringProperty planetName;
	private SimpleStringProperty diameterkm;
	private double diameterm;
	private SimpleStringProperty temperatureF;
	private double temperatureC;
	private SimpleIntegerProperty Numberofmoon;
	public Planet(String planetName, String diameterkm, String temperatureF,int Numberofmoon )throws InvalidPlanetException{
		try{
			this.planetName = new SimpleStringProperty();
			this.diameterkm = new SimpleStringProperty();
			this.temperatureF = new SimpleStringProperty();
			this.Numberofmoon = new SimpleIntegerProperty();
			setPlanetName(planetName);
			setDiameterkm(diameterkm);
			setTemperatureF(temperatureF);
			setNumberofmoon(Numberofmoon);
		}
		catch(InvalidPlanetException e){
			throw new InvalidPlanetException(e);
		}
	}
	
	public String getPlanetName() {
		return planetName.getValue();
	}
	public void setPlanetName(String planetName) {
		if(!isValidPlanet(planetName))
			throw new InvalidPlanetException("Planet Name is invalid");
		this.planetName.setValue(planetName);
	}
	public String getDiameterkm() {
		return diameterkm.getValue();
	}
	public void setDiameterkm(String diameterkm) {
		if(!isValiddiameterNumber(diameterkm))
			throw new InvalidPlanetException("Diameter is Invalid");
		this.diameterkm.setValue(diameterkm);
		//System.out.println(this.getDiameterkm());
	}
	
	public String getTemperatureF() {
		return temperatureF.getValue();
	}
	public void setTemperatureF(String temperatureF) {
		if(!isValidTemperature(temperatureF))
			throw new InvalidPlanetException("Temperature in Farheneit is Invalid");
		this.diameterkm.setValue(temperatureF);
	}


	public int getNumberofmoon() {
		return Numberofmoon.getValue();
	}
	public void setNumberofmoon(int numberofmoon) {
		if(!isValidNumberofMoons(numberofmoon)){
			throw new InvalidPlanetException("Moon Numbers is invalid");
		}
		this.Numberofmoon.setValue(numberofmoon);
	}
	
	public String Far_To_Cel(double Far){ 
		this.temperatureC = ((Far)-32)*(0.5556);
		return Double.toString(this.temperatureC);
	}
	
	public String KM_To_M(double km){
		this.diameterm = km * 1000;
		return Double.toString(diameterm);
	}
	private boolean isValidNameLength(String testName){
		if(testName.length() > 1 &&  testName.length() < 255)
			return true;
		return false;
	}
	public boolean isValidPlanet(String PlanetName){
		boolean isvalid = false;
		for(int i = 0; i < PlanetName.length(); i++){
			 char c = PlanetName.charAt(i);
			 if((isValidNameLength(PlanetName)) &&
					 (Character.isDigit(c) ||Character.isLetter(c)||
							 Character.isWhitespace(c)||c == '-'|| c == '.')){
				 isvalid = true;
			 }
			 else{
			 isvalid = false;
			 }
		}
		return isvalid;
	}
	public boolean isValidFields(String PlanetName, String testDiameter, String temperature, int moons){
		boolean valid = false;
		if(isValidPlanet(PlanetName) && isValiddiameterNumber(testDiameter) &&  isValidTemperature(temperature) && isValidNumberofMoons(moons)){
			valid = true;
		}
		else{
			valid = false;
		}
		return valid;
	}
	private boolean isValidrealNumber(String testDiameter){
		try{
			 	Double.parseDouble(testDiameter);
		}
		catch (NumberFormatException e){
			return false;
		}
		return true;
	}
	public boolean isValiddiameterNumber(String testDiameter){
		if(isValidrealNumber(testDiameter) && (0 > Double.parseDouble(testDiameter) ||
				Double.parseDouble(testDiameter) < 1000 )){
			return true;
		}
		return false;
	}
	public boolean isValidTemperature(String testTemp){
		if(isValidrealNumber(testTemp) && (-273.15 > Double.parseDouble(testTemp) || 
				Double.parseDouble(testTemp) < 500)){
			return true;
		}
		return false;
	}
	public boolean isValidNumberofMoons(int NumberofMoons){
		if(NumberofMoons < 0 || NumberofMoons > 1000){
			return false;
		}
		return true;
	}
}
