package planet.detail;

public class InvalidPlanetException extends RuntimeException {

	public InvalidPlanetException(RuntimeException e) {
		super(e);
	}

	public InvalidPlanetException(String message) {
		super(message);
	}

}
