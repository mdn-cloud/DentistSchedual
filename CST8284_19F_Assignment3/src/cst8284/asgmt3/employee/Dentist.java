package cst8284.asgmt3.employee;

/**
 * Dentist class: 
 * <p> - It is a concrete subclass of the {@link Employee} abstract superclass 
 * <p> - All of Employee superclass's abstract method(s) will guaranteed to override in this class as a concrete method 
 * @author Mukta Debnath
 * @version 1.0
 *
 */

public class Dentist extends Employee {
	/**
	 * workDescription:
	 * <p> - A String type of array to hold four different kind of work category 
	 * 
	 */
	private static String[] workDescription = {"Assessment", "Filling", "Crown", "Cosmetic Repair"};
 
	/**
	 * Dentist(String):
	 * <p> - Parameterized constructor is passing the fullName of Dentist which is chained with the super
	 * class {@link Employee} by using the word "super". 
	 * @param fullName is a String containing the dentist's full name.  
	 */
	public Dentist(String fullName) {
		super (fullName);
	}
	
	/**
	 * getActivityType():
	 * <p> - This method has been overridden from the extended superclass {@link Employee}
	 * to return the current activity of dentist
	 * @return A string representing the dentist's workDescripition.
	 */
	public String getActivityType() {
		System.out.println("Enter a selection from the following menu:");
		int i = 1;
		for (String description: workDescription)
			System.out.println(i++ + "." + description);
		int ch = scan.nextInt();
		scan.nextLine(); // 'eat' the next line in the buffer
		System.out.println();  // add a space
		return workDescription[ch-1];
	}
}
