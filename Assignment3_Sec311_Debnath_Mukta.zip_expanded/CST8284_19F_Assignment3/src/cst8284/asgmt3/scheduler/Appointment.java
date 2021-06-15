package cst8284.asgmt3.scheduler;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Appointment class:
 * <p> - This class is designed to make an appointment for patients 
 * <br> -It contains information to make an appointment for patients
 *  @author Mukta Debnath
 *  @version 1.1
 *
 */
public class Appointment implements Serializable {
	/**
	 * serialVersionUID:
	 * <p> - Declared the serialVersionUID for Serializable interface.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * aptDate:
	 * <p> - Declared the {@link Calendar} type aptDate to hold the date.
	 */
	private Calendar aptDate;

	/**
	 * firstName:
	 * <p> - Declared the firstName to hold the place for the first name. 
	 */
	private String firstName;

	/**
	 * lastName:
	 * <p> - Declared the lastName to hold the place for the last name. 
	 */
	private String lastName;

	/**
	 * phone:
	 * <p>  - Declared the {@link TelephoneNumber} type aptDate to hold the date.
	 */
	private TelephoneNumber phone;

	/**
	 * activity
	 * <p> - Declared the {@link Activity} type activity to hold the type of the activity.
	 */
	private Activity activity;
	
	/**
	 * Appointment():
	 *<p> - Parameterized constructor with four parameters which is chained with the Appointment(Calendar, String, String, TelephoneNumber,  Activity) constructor.
	 * @param cal is a Calendar of an appointment.
	 * @param fullName is single String made by two separate String.
	 * @param phone is the TelephoneNumber of the patient. 
	 * @param act is a activity that choose by the patient. 
	 */
	public Appointment(Calendar cal, String fullName, TelephoneNumber phone, Activity act) {
		this(cal, fullName.trim().split(" ")[0], fullName.trim().split(" ")[1], phone, act);
	}

	/**
	 * Appointment():
	 * <p> - Parameterized constructor contains five parameters to construct the new Appointment object with the given parameters pass into it.
	 * @param cal is a Calendar of an appointment.
	 * @param firstName is the first name of the patient to make the appointment.
	 * @param lastName is the last name of the patient to make the appointment.
	 * @param phone is the TelephoneNumber of the patient.
	 * @param act is a activity that choose by the patient.
	 */

	public Appointment(Calendar cal, String firstName, String lastName, TelephoneNumber phone, Activity act) {
		setFirstName(firstName.trim()); 
		setLastName(lastName.trim());
		setCalendar(cal); 
		setPhone(phone);
		setActivity(act);
	}

	/**
	 * getCalendar():
	 * <p> - This method is use to return the value of Calendar date/
	 * @return A date of an Appointment
	 */
	public Calendar getCalendar() {return aptDate;}
	
	/**
	 * setCalendar():
	 * <p> - Set the value of Calendar date. 
	 * @param aptDate is an appointment date.
	 */
	public void setCalendar(Calendar aptDate) {this.aptDate = aptDate;}

	/**
	 * getFirstName():
	 * <p> - Method returns a string of firstName of the patient.
	 * @return A String called firstName to retrieve the first name.
	 */
	public String getFirstName() {return firstName; }

	/**
	 * setFirstName():
	 * <p> - Method sets the value of firstName.
	 * @param firstName is the first name of the patients to make the appointment.
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}

	/**
	 * getLastName():
	 * <p> - Method returns a string of lastName.
	 * @return A String called lastName to retrieve the last name of patients.
	 */
	public String getLastName() {return lastName;}

	/**
	 * <p> - Method sets the value of lastName.
	 * @param lastName is the last name of the patients to make the appointment.
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}

	/**
	 * getPhone():
	 * <p> Method returns a TelephoneNumber of patient.
	 * @return A telephone number.
	 */
	public TelephoneNumber getPhone() {return phone;}

	/**
	 * setPhone():
	 * <p> Method sets the value of TelephoneNumber.
	 * @param phone is the TelephoneNumber of the patient.
	 */
	public void setPhone(TelephoneNumber phone) {this.phone = phone;}

	/**
	 * getActivity():
	 * <p> - Is a method returns a TelephoneNumber of patient.
	 * @return An activity   
	 */
	public Activity getActivity() {return activity;}

	/**
	 * setActivity():
	 * <p> - Method sets the value of Activity.
	 * @param activity is a activity that choose by the patient.
	 */
	public void setActivity(Activity activity) {this.activity = activity;}

	/**
	 * toString():
	 * <p> - This method has been overridden from the superclass to return a string representation of the appointment 
	 * @return A string combines the information about the appoint
	 */
	public String toString() {
		return getCalendar().getTime().toString() + "\n" +
				getFirstName() + " " + getLastName() + "\n" + 
				getPhone().toString() + "\n" +
				getActivity().toString();
	}

}
