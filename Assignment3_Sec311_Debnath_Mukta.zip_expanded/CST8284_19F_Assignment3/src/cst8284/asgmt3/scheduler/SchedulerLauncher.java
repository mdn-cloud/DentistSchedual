package cst8284.asgmt3.scheduler;
import cst8284.asgmt3.employee.Dentist;

/**
 * SchedulerLauncher:
 * <p> This is the class where the code execute in the main method. 
 * @author Mukta Debnath
 * @version 1.0
 */
public class SchedulerLauncher {

	/**
	 * main():
	 * <p> - Where you make a Scheduler object and use the launch method to start the code to make the whole Appointment project.
	 * @param args supplies command-line arguments as an array of String objects
	 */
	public static void main(String[] args) {
		(new Scheduler(new Dentist("Dr. Andrews"))).launch();
	}
}
