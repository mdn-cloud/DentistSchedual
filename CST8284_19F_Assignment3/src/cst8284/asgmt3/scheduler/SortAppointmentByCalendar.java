package cst8284.asgmt3.scheduler;
import java.util.Comparator;

/**
 * SortAppointmentByCalendar class:
 * <p> - This class can be used to sort the appointments by the calendar date made by the users.
 * <br> - Will guarantee to override the compare method because it implements the Comparator interface.
 * @author Mukta Debnath
 * @version 1.1
 */
public class SortAppointmentByCalendar implements Comparator<Appointment>{

	/**
	 * compare():
	 * <p> - This method will perform to compare the two appointments parameters for order based on the Appointment Calendar 
	 * for example if the ap1 is earlier than ap2 it will return a negative integer.
	 * @param ap1 refers to a instance of Appointment.
	 * @param ap2 refers to a instance of Appointment.
	 * @return An int (integer) value like zero, or a positive or a negative integer to compare the calendar appointments. 
	 */
	@Override
	public int compare(Appointment ap1, Appointment ap2) {
		return ap1.getCalendar().compareTo(ap2.getCalendar());
	}
}