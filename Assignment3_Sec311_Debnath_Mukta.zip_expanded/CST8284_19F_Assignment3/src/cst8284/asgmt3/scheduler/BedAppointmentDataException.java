package cst8284.asgmt3.scheduler;

/**
 * BedAppointmentDataException class:
 * <p> This class has access to properties and methods
 * of RuntimeException superclass and catch any data
 * input error from the user input.
 * @author Mukta Debnath
 * @version 1.0
 */
public class BedAppointmentDataException extends java.lang.RuntimeException {
	
	/**
	 * serialVersionUID:
	 * <p> - Declared the serialVersionUID for Serializable interface.
	 */
	public static final long serialVersionUID = 1L;
	
	/**
	 * description:
	 * <p> - Description of the BedAppointmentDataException problem
	 */
	private String description;

	/**
	 * BedAppointmentDataException():
	 * <p> - This is a default constructor of the class with no argument 
	 * <p> - Chained to the BedAppointmentDataException(String, String) constructor to initialize the instance of BedAppointmentDataException
	 */
	public BedAppointmentDataException() {
		this("Please try again", "Bad data entered");
	}

	/**
	 * BedAppointmentDataException(String, String):
	 * <p> - Parameterized constructor passing two strings into it
	 * <p> - Chained to the superclass constructor to initialize the instance of BedAppointmentDataException
	 * @param s takes a string passed to the superclass constructor
	 * @param description is the description of the errors
	 */
	public BedAppointmentDataException(String s, String description) {
		super(s);
		setDescription(description);
	}

	/**
	 * getDescription():
	 * <p> - Method returns current description of error
	 * @return A string representing the description of error
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * setDescription():
	 * <p> - Sets the description of the current error
	 * @param description is the description of the current error
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * toString():
	 * <P> - This method has been overridden from the superclass to return a string representation of the BedAppointmentDataException 
	 * @return A string combination of description, and message from the superclass 
	 */
	@Override

	public String toString() {
		return (getDescription() + "\n" + getMessage());
	}

}
