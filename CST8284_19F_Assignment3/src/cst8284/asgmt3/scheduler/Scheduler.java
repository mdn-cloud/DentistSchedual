package cst8284.asgmt3.scheduler;
import java.util.Scanner;
import cst8284.asgmt3.employee.Employee;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Scheduler Class:
 * <p>This class designed to provides functions of {@link Appointment} for example:
 * <br> -add, 
 * <br> -delete,
 * <br> -update, and
 * <br> -display 
 * @author Mukta Debnath
 * @version 1.0 
 */
public class Scheduler {

	/**
	 * scan:
	 * <p> - An instance of Scanner class to get input from user.
	 */
	private static Scanner scan = new Scanner(System.in);
	/**
	 * appointments:
	 * <p> - An ArrayList to hold the appointment object.
	 */
	private ArrayList<Appointment> appointments = new ArrayList<>();
	/**
	 * employee:
	 * <p> - An employee object to hold the name of {@link Employee} and the type of activities.
	 */
	private Employee employee;

	/**
	 * SAVE_APPOINTMENT: 
	 * <p> - Declared and assigned a constant value 1 to save the appointment. 
	 */
	private static final int SAVE_APPOINTMENT = 1;
	
	/**
	 * DELETE_APPOINTMEN:
	 * <p> - Declared and assigned a constant value 2 to delete the appointment.
	 */
	private static final int DELETE_APPOINTMENT = 2;
	
	/**
	 *CHANGE_APPOINTMENT:
	 *<p> - Declared and assigned a constant value 3 to change the appointment.
	 */
	private static final int CHANGE_APPOINTMENT = 3;
	
	/**
	 * DISPLAY_APPOINTMENT:
	 * <p> - Declared and assigned a constant value 4 to display the appointment.
	 */
	private static final int DISPLAY_APPOINTMENT = 4;
	
	/**
	 * DISPLAY_SCHEDULE:
	 * <p> - Declared and assigned a constant value 5 to display the schedule.
	 */
	private static final int DISPLAY_SCHEDULE = 5; 
	
	/**
	 * SAVE_APPOINTMENTS_TO_FILE:
	 * <p> - Declared and assigned a constant value 6 to save the appointments to the file.
	 */
	private static final int SAVE_APPOINTMENTS_TO_FILE = 6;
	/**
	 * LOAD_APPOINTMENTS_FROM_FILE:
	 * <p> - Declared and assigned a constant value 7 to load the appointments from the file.
	 */
	private static final int LOAD_APPOINTMENTS_FROM_FILE = 7; 
	/**
	 * EXIT:
	 * <p> - Declared and assigned a constant value 0 to exit 
	 */
	private static final int EXIT = 0;

	/**
	 * Scheduler():
	 * <p> - This is an initialized constructor to create a scheduler instance.
	 * @param emp is an employee instance contains the name of the Employee.
	 */
	public Scheduler(Employee emp) {
		System.out.println("Scheduling appointments for " + emp);
		setEmployee(emp);
	}

	/**
	 * setEmployee(): 
	 * <p>This will set the current employee to the scheduler instance.
	 * @param emp is an employee instance.
	 */
	private void setEmployee(Employee emp) {
		this.employee = emp;
	}

	/**
	 * getEmployee():
	 * <p> - The getter method will return the current employee of the scheduler.
	 * @return - Current instance of employee.
	 */
	private Employee getEmployee() {
		return employee;
	}

	/**
	 * launch():
	 *<p> Contains a 'do while' loop to control the execution of the application like exit or continue. 
	 *<br>This method will handle the BedAppointmentDataException.
	 */
	public void launch() {
		int choice = 0;
		do {
			try {
				choice = displayMenu();
				executeMenuItem(choice);
			} catch (BedAppointmentDataException e) {
				System.out.println(e.toString());
			}
		} while (choice != EXIT);

	}

	/**
	 * displayMenu():
	 * <p> - Designed to print the menu options and then prompt the the user choice from the menu options 
	 * @return An integer constant value based on user's choice.
	 */
	private int displayMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(SAVE_APPOINTMENT + ". Save appointment\n" + DELETE_APPOINTMENT + ". Remove appointment\n"
				+ CHANGE_APPOINTMENT + ". Change appointment\n" + DISPLAY_APPOINTMENT + ". Get appointment\n"
				+ DISPLAY_SCHEDULE + ". Display schedule\n" + SAVE_APPOINTMENTS_TO_FILE + ". Backup appointments\n"
				+ LOAD_APPOINTMENTS_FROM_FILE + ". Load appointments\n" + EXIT + ". Exit program");
		int ch = scan.nextInt();
		scan.nextLine(); // 'eat' the next line in the buffer
		System.out.println();
		return ch;
	}

	
	/**
	 * executeMenuItem():
	 * <p> - Method is passing a parameter called choice. 
	 * <p> - This method will execute the menu list by calling different functions based on the user's input.
	 * * @param choice is an integer value from user's choice
	 * */
	private void executeMenuItem(int choice) {
		switch (choice) {
		case SAVE_APPOINTMENT:
			saveAppointment(makeAppointmentFromUserInput());
			break;
		case DELETE_APPOINTMENT:
			deleteAppointment(makeCalendarFromUserInput(false));
			break;
		case CHANGE_APPOINTMENT:
			changeAppointment(makeCalendarFromUserInput(false));
			break;
		case DISPLAY_APPOINTMENT:
			displayAppointment(makeCalendarFromUserInput(false));
			break;
		case DISPLAY_SCHEDULE:
			displayDaySchedule(makeCalendarFromUserInput(true));
			break;
		case SAVE_APPOINTMENTS_TO_FILE:
			saveAppointmentsToFile(getAppointments(), "CurrentAppointments.apts");
			break;
		case LOAD_APPOINTMENTS_FROM_FILE:
			loadAppointmentsFromFile("CurrentAppointments.apts", getAppointments());
			break;
		case EXIT:
			System.out.println("Exiting Scheduler\n\n");
			break;
		default:
			System.out.println("Invalid choice: try again. (Select " + EXIT + " to exit.)\n");
		}
		System.out.println(); // add blank line after each output
	}
    /**
     * getResponseTo():
     * <p>This method will take a string as a parameter and will print it out to display
     * @param s is a string indicating a message that needs to be printed 
     * @return users' choice
     */
	private static String getResponseTo(String s) {
		System.out.print(s);
		return (scan.nextLine());
	}
	
	/**
	 * makeAppointmentFromUserInput():
	 * <p> - This is an Appointment type method that prompts users to provide information to make an appointment.
	 * <br> - Checks the validation of the user's input.    
	 * @return An appointment type object of new Appointment.
	 */

	private Appointment makeAppointmentFromUserInput() {

		String fullName = getResponseTo("Enter Client Name (as FirstName LastName): ");
		
		if (fullName.trim().isEmpty() || fullName == null) {
			throw new BedAppointmentDataException("Must enter a value", "Empty or null value entered");
		}
		
		if (fullName.matches(".*[^a-zA-Z|.| |'|-].*")) {
			throw new BedAppointmentDataException(
					"Name cannot include characters other than alphabetic characters, the dash (-), the period (.), and the apostrophe (‘)",
					"Illegal characters in name");
		}

		if (fullName.length() > 30) {
			throw new BedAppointmentDataException("Name cannot exceed 30 characters", "Name exceeds maximum length");
		}

		String phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): ");
		
		if (phoneNumber.trim().isEmpty() || phoneNumber == null) {
			throw new BedAppointmentDataException("Must enter a value", "Empty or null value entered");
		}

		if (phoneNumber.length() < 12) {
			throw new BedAppointmentDataException("Missing digit(s); correct format is AAA-PPP-NNNN, "
					+ "where AAA is the area code and PPP-NNNN is the local number", "Incorrect format");
		}

		if (phoneNumber.matches(".*[^0-9|-].*")) {
			throw new BedAppointmentDataException("Telephone numbers can only contain numbers or the character ‘-‘",
					"Bad character(s) in input string");
		}
			
		if (phoneNumber.length() > 12) {
				throw new BedAppointmentDataException("Telephone numbers can only contain numbers or the character ‘-‘",
			                "Bad character(s) in input string");
		}
		if (phoneNumber.charAt(0) == '0' || phoneNumber.charAt(0) == '1') {
			throw new BedAppointmentDataException("Area code can’t start with a ‘0’ or a ‘1’ ", "Invalid number");
		}

		
		TelephoneNumber phone = new TelephoneNumber(phoneNumber);
		Calendar cal = makeCalendarFromUserInput(false);

		String activity = getResponseTo("Enter Activity: ");
		Activity act = new Activity(activity, getEmployee().getActivityType());
		return (new Appointment(cal, fullName, phone, act));
	}

	 /**
	 * makeCalendarFromUserInput():
     * <p> - Takes a boolean value as parameter.
     * <br> - Prompts the user for the date and time of appointment by calling getResponseTo method twice, 
     * once for the date and a second time for the hour. 
     * <br> - Processes the two strings into year, month, 
     * day and hour values.
     * <br> - And then instantiates a new Calendar object using one of the overloaded 
     * Calendar set() method.
     * <br> - This method is also checks the validation of the dates. 
     * @param suppressHour is a boolean value set as <br> - true <br>when time is required and <br> - false <br> when time is required for a calendar
     * @return A calendar type of new {@link Calendar} object 
     */
	private static Calendar makeCalendarFromUserInput(boolean suppressHour) {
		Calendar cal = Calendar.getInstance();
		int hour = 0;

		cal.clear();
		String date = getResponseTo("Appointment Date (entered as DDMMYYYY): ");

		if (date.trim().isEmpty() || date == null) {
			throw new BedAppointmentDataException("Must enter a value", "Empty or null value entered");
		}

		if (date.matches(".*[^0-9].*") || date.length() != 8) {
			throw new BedAppointmentDataException("Bad calendar date entered; format is DDMMYYYY",
					"Bad calendar format");

		}
		
		//reference : https://stackoverflow.com/questions/49225273/java-calendar-how-to-validate-date
		try {
		LocalDate.parse("date", DateTimeFormatter.ofPattern("ddMMyyyy"));
		}catch(Exception e) {
			throw new BedAppointmentDataException("Bad calendar date entered; format is DDMMYYYY",
					"Bad calendar format");
		}
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4)) - 1; // offset by one to account for zero-based month in
																// Calendar
		int year = Integer.parseInt(date.substring(4, 8));

		if (!suppressHour) {
			String time = getResponseTo("Appointment Time: ");
			hour = processTimeString(time);
		}

		cal.set(year, month, day, hour, 0);
		return (cal);
	}
	 /**
	  * processTimeString():
     * <p> - Method that takes the String time that reads in any of the stated formats
     * <br> - Returns an integer value according to the correct 24-hour format value.
     * @param t is the time which is passing through the method as a string
     * @return An int value according to the correct 24-hour format
     */
	private static int processTimeString(String t) {
		int hour = 0;
		t = t.trim();
		if (t.contains(":"))
			hour = Integer.parseInt(t.split(":")[0]);
		else if (t.contains(" "))
			hour = Integer.parseInt(t.split(" ")[0]);
		else
			hour = Integer.parseInt(t);
		return ((hour < 8) ? hour + 12 : hour);
	}
	
	/**
	 * findAppointment():
	 * <p> - This method takes an calendar instance as parameter,
	 * <br> - Searches the appointment ArrayList by calling Collections' sort and binarySearch methods. 
	 * <br> - It returns the appointment if an appointment with same calendar value passed is found, and if not found it returns null.
	 * @param cal is a calendar value passed as parameter 
	 * @return An appointment if found or return null if not found
	 */
	private Appointment findAppointment(Calendar cal) {
		SortAppointmentByCalendar sort = new SortAppointmentByCalendar();
		Appointment a = new Appointment(cal, "abc abc", null, null);
		Collections.sort(getAppointments(), sort);
		int i = Collections.binarySearch(getAppointments(), a, sort);

		if (i < 0) {
			return null;
		}
		return getAppointments().get(i);
	}
	
	 /**
	  * saveAppointment():
	  * <p> - Method that takes an appointment as a parameter, 
	  * <br> - Checks to see if the appointment already exists by calling findAppointment() to see any of matching Calendar objects exist 
	  * in the appointments ArrayList.
	  * <br> - Checks if findAppointment() returns null, then that time is available, and the new Appointment is safely booked or added 
	  * into the array list, if not,then the attempt is aborted, 
	  * <br> - Print a message to inform the user that the attempt is successful or unsuccessful.
	  * @param apt is an Appointment object passed as a parameter
	  * @return A boolean  <br> - true <br> if successful the condition or <br> - false <br> if fail the condition
	  */
	private boolean saveAppointment(Appointment apt) {
		Calendar cal = apt.getCalendar(); // Check that the appointment does not already exist
		if (findAppointment(cal) == null) { // Time slot available, okay to add appointment
			getAppointments().add(apt);
			System.out.println("Appointment saved.");
			return true;
		} // else time slot taken, need to make another choice
		System.out.println("Cannot save; an appointment at that time already exists");
		return false;
	}

	/**
	 * deleteAppointment():
	 * <p> - Method that takes a calendar object as a parameter, 
	 * <br> - Searches and display details of the appointment, 
	 * <br> - Prompts the user to confirm if its okay to delete the appointment.
	 * <br> - If the user's input is yes, it remove the appointment object from the array list 
	 * and returns true if successful or false if not
	 * @param cal calendar object passed as a parameter to the method
	 * @return A boolean  <br> - true <br> if successful the condition or <br> - false <br> if fail the condition
	 */
	private boolean deleteAppointment(Calendar cal) {
		if (displayAppointment(cal)) { // display existing appointment on this date/time
			String okToChange = getResponseTo("\nEnter 'Yes' to delete this appointment");
			if (okToChange.trim().equals("Yes")) { // okay to proceed with change/deletion?
				getAppointments().remove(findAppointment(cal));
				System.out.println("Appointment deleted");
				return true;
			} else
				System.out.println("Request cancelled");
		}
		return false; // Appointment didn't exist at the date/time specified
	}

	/**
	 * changeAppointment():
	 * <p> - Takes calendar object as c parameter.
	 * <br> - This method designed to change the date and time of an appointments which is already exist.
	 * <br> - It prompts the user for the calendar value of the appointment to change as well as displays details of the appointment 
	 * by calling the displayAppointment method, 
	 * <br> - Also prompts the user to confirm the change the appointment if it is correct. if the user's input is yes, it prompts the
	 * user to enter the new date and time to make a new calendar from the user input, 
	 * <br> Checks that date and time is available or not by calling findAppointment method. If available, then the appointment
	 * is updated with the new values and returns true or false if fail the condition
	 * @param cal is a calendar object passed as a parameter
	 * @return A boolean  <br> - true <br> if successful the condition or <br> - false <br> if fail the condition
	 */
	private boolean changeAppointment(Calendar cal) {
		if (displayAppointment(cal)) { // display existing appointment on this date/time
			String okToChange = getResponseTo("\nEnter 'Yes' to change the date and time of this appointment ");
			if (okToChange.trim().equals("Yes")) {
				System.out.println("Enter new date and time");
				Calendar newCal = makeCalendarFromUserInput(false); // get new date/time
				if (findAppointment(newCal) == null) { // appointment time not already taken
					findAppointment(cal).setCalendar(newCal); // set new date/time in appointment
					System.out.println("Appointment re-booked\n");
					return true; // new appointment time set
				} else
					System.out.println("That time is already booked for an appointment\n");
			} else
				System.out.println("Request cancelled");
		}
		return false; // Appointment does not exist, was unavailable, or cancelled
	}
	
	/**
	 * displayAppointment():
	 * <p> - It takes calendar object as a parameter, 
	 * <br> - This method is used to display a particular appointment's details, 
	 * <br> - Prompts the user for a calendar value for the appointment check to see if the appointment with the passed 
	 * calendar value is exist or not by calling the displayAppointment method.
	 * <br> - If it happen, it calls the displayAppointment method to output the details of the appointment, if not, it prints a message telling the user no appointment
	 * for the given date and time
	 * @param cal is a calendar object passed as a parameter
	 * @return A boolean  <br> - true <br> if successful the condition or <br> - false <br> if fail the condition
	 */

	private boolean displayAppointment(Calendar cal) {
		Appointment apt = findAppointment(cal);
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		System.out.print((apt != null) ? "\n\n" + apt.toString() + "\n" : // Output the appointment as a string to the
																			// console, otherwise...
				"No appointment scheduled between " + hr + ":00 and " + (hr + 1) + ":00\n");
		return (apt != null);
	}

	/**
	 * displayDaySchedule(): 
	 * <p> - This method takes calendar object as parameter and displays all appointments for a particular day. 
	 * <br> - Prompts the user for a calendar date (without time) for the appointment and displays details of all the appointments for that day 
	 * @param cal is a calendar object passed as a parameter through this method.
	 */
	
	private void displayDaySchedule(Calendar cal) {
		for (int hrCtr = 8; hrCtr < 17; hrCtr++) {
			cal.set(Calendar.HOUR_OF_DAY, hrCtr);
			displayAppointment(cal);
		}
	}

	/**
	 * saveAppointmentsToFile():
	 * <p> - This method takes the ArrayList of Appointment type and a String saveFile 
	 * <br> - Designed to save the appointments in the ArrayList to the file in the system.
	 * @param apts is an instance of ArrayList to hold the {@link Appointment} type of appointment 
	 * @param saveFile Name of the file to store the appointments
	 * @return A boolean  <br> - true <br> if successful the condition or <br> - false <br> if fail the condition
	 */
	private static boolean saveAppointmentsToFile(ArrayList<Appointment> apts, String saveFile) {
		try (FileOutputStream fos = new FileOutputStream(saveFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for (Appointment apt : apts)
				oos.writeObject(apt);
			System.out.println("Appointment data saved to " + saveFile);
			return true;
		} catch (IOException e) {
			System.out.println("Failed to load appointments from " + saveFile);
			return false;
		}
	}

	/**
	 * loadAppointmentsFromFile():
	 * <p> - This method takes the ArrayList of Appointment type and a source file as a string 
	 * <br> - Designed to load the appointments from the file to the ArrayList when the method is called. 
	 * @param sourceFile contain the information that will be loaded from the file
	 * @param apts is an instance of ArrayList to hold the {@link Appointment} type from the file
	 * @return A boolean -true if the EOFException is caught (means successful) and -false if ClassNotFoundException or IOException is caught
	 */
	private static boolean loadAppointmentsFromFile(String sourceFile, ArrayList<Appointment> apts) {
		apts.clear(); // remove all existing appointments from the ArrayList before loading from file
		try (FileInputStream fis = new FileInputStream(sourceFile);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			while (true)
				apts.add((Appointment) ois.readObject());
		} catch (EOFException ex) {
			System.out.println("Appointments successfully loaded from " + sourceFile);
			return true;
		} catch (IOException | ClassNotFoundException e) {
			return false;
		}
	}
	
	/**
	 * getAppointments():
	 * <p> This method returns the ArrayList of {@link Appointment}. 
	 * @return An ArrayList
	 */

	private ArrayList<Appointment> getAppointments() {
		return appointments;
	}

}
