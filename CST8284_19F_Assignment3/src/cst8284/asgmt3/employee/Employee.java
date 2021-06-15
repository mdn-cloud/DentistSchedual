package cst8284.asgmt3.employee;
import java.util.Scanner;

/**
 * Employee class:
 * <p> - This is an abstract class created to hold the Employee's information which
 * will guarantee to override all of its abstract methods to the subclasses.
 * @author Mukta Debnath
 * @version 1.0
 * 
 */

public abstract class Employee {
	/**
	 * fullName:
	 * <p> - Represents the employee's full name.
	 */
	private String fullName;
	
	/**
	 * Employee():
	 * <p> - No arg constructor to initialize instance of Employee with the default value("unknown")
	 */
	protected Employee(){this("unknown");}
	
	/**
	 * Employee(String):
	 * <p> - Parameterized constructor will pass a string (fullName) as a parameter.
	 * <p> - Creates an Employee with a specified full name.
	 * @param fullName the employee's full name
	 * 
	 */
	protected Employee(String fullName) {setName(fullName);}
	
	/**
	 * An instance of Scanner to get input from users
	 */
	protected static Scanner scan = new Scanner(System.in);
	
    /**
     * setName():
     * <p> - This method sets the employee's fullName.
     * @param fullName A String containing the employee's fullName.
     */
	public void setName(String fullName) {this.fullName = fullName;}
	
	/**
	 * getName():
    * <p> - This method gets the fullName of Employee 
    * @return A String representing the employee's fullName
    */
	public String getName() {return fullName;}

	public abstract String getActivityType();

	/**
	 * toString():
	 * <p> - This method has been overridden from the superclass to return a string representation of the Employee 
	 * @return A string representing the employee's fullName
	 * 
	 */
	@Override
	public String toString() {return getName();}
}