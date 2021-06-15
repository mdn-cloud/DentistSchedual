package cst8284.asgmt3.scheduler;
import java.io.Serializable;

/**
 * Activity class:
 * <p> - The purpose of the Activity class is to contain the information about activities to make an appointments 
 * @author Mukta Debnath
 * @version 1.1
 *
 */
public class Activity implements Serializable {
	
	/**
	 * serialVersionUID:
	 * <p> - Declared the serialVersionUID for Serializable interface.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * descriptionOfWork:
	 * <p> - Declare the variable descriptionOfWork to hold the description of Activity.
	 */
	private String descriptionOfWork;
	
	/**
	 * category:
	 * <p> - Declare the variable category to hold the category of Activity.
	 */
	private String category;
	
	/**
	 * Activity():
	 * <p> - Parameterized constructor passing the description and category of activity 
	 * @param description is a description of Activity
	 * @param category is a category of Activity 
	 */
	public Activity(String description, String category) {
		setDescription(description);
		setCategory(category);
	}
	
	/**
	 * getDescription():
	 * <p> - This method is designed for to return the value of descriptionOfWork which is declared as a 
	 * private variable in this class.
	 * @return A descriptionOfWork for example description of activity or work set by the setDescription.
	 */
	public String getDescription() {return descriptionOfWork;}
	
	/**
	 * setDescription():
	 * <p> - Setter is to set the description of required activity.
	 * @param description is the description of the Activity.
	 */
	public void setDescription(String description) {this.descriptionOfWork = description;}
	

	/**
	 * getCategory():
	 * <p> - This method is designed for to return the value of category which is declared as a 
	 * private variable in this class.
	 * @return The category of activity or work set by the setDescription.
	 */
	public String getCategory() {return category;}
	
	/**
	 * setCategory():
	 * <p> - Setter is to set the category of required activity.
	 * @param category is a string representing the category of the Activity.
	 */
	public void setCategory(String category) {this.category = category;}
	
	/**
	 * toString():
	 * <p> - This method has been overridden from the superclass to return a string representation of the Activity.
	 * @return A String combination of category and description. 
	 */
	public String toString() {return getCategory() + "\n" + getDescription();}
}
