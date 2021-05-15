package exceptions;

public class NegativeValueException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -32695366262527978L;

	/**
	 * Thrown when a negative value (< 0 ) is inputted
	 * @param errorMessage an error message
	 */
	public NegativeValueException(String errorMessage){
		super(errorMessage);
	}
}
