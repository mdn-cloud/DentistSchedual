package cst8284.asgmt3.scheduler;
import java.io.Serializable;

/**
 * TelephoneNumber class:
 * <p> - This class will help to make and retrieve all the information about the phone number.
 * @author Mukta Debnath
 * @version 1.0
 */

public class TelephoneNumber implements Serializable {
	/**
	 * serialVersionUID:
	 * <p> - Declared the serialVersionUID for Serializable interface.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * areaCode:
	 * <p> - Declared the area code  
	 */
	private int areaCode;
	
	/**
	 * lineNumber:
	 * <p> - Declared the line number 
	 */
	private int lineNumber;
	 /**
	  * prefix:
	  * <p> - Declared the prefix 
	  */
	private int prefix;
	
	/**
	 * TelephoneNumber(String phoneNumber):
	 * <p> - The method takes one String with the whole phone number and splits it into 3 different variables like 
	 * areaCode, lineNumber, and prefix.
	 * <br> - Used Integer.parseInt() method for casting the variables types from String to int
	 * @param phoneNumber is a String of a complete phone number; for example: 613-456-7894
	 */
	public TelephoneNumber(String phoneNumber) {
		int areaCode = Integer.parseInt(phoneNumber.split("-")[0].trim());
		int prefix = Integer.parseInt(phoneNumber.split("-")[1].trim());
		int lineNumber = Integer.parseInt(phoneNumber.split("-")[2].trim());
		setAreaCode(areaCode); setPrefix(prefix); setLineNumber(lineNumber);
	}
	
	/**
	 * getAreaCode(): 
	 * <p> - Getter makes to return an int value of the areaCode of phone number.
	 * @return An int areaCode of phone number. 
	 */
	public int getAreaCode() {return areaCode;}
	
	/**
	 * setAreaCode():
	 * <p> - Sets an int value of areaCode of the phone number.
	 * @param areaCode An int areaCode of phone number.
	 */
	public void setAreaCode(int areaCode) {this.areaCode = areaCode;}
	
	/**
	 * getPrefix(): 
	 * <p> - Getter to return an int value of the prefix of phone number.
	 * @return An int prefix of phone number.
	 */
	public int getPrefix() { return prefix;}
	
	/**
	 * setPrefix():
	 * <p> - This sets an int value of prefix of the phone number.
	 * @param prefix An int prefix of phone number
	 */
	public void setPrefix(int prefix) {this.prefix = prefix;}
	
	/**
	 * getLineNumber():
	 * <p> - This getter is to return an int value of the lineNumber.
	 * @return An int lineNumber of the phone number.
	 */
	public int getLineNumber() {return lineNumber;}
	
	/**
	 * setLineNumber():
	 * <p> - A setter to set the line number of the phone number.
	 * @param lineNumber is an int lineNumber of phone number.
	 */
	public void setLineNumber(int lineNumber) {this.lineNumber = lineNumber;}
	
	/**
	 * toString():
	 * <p> - This method has been overridden from the superclass to return a string representation of the TelephoneNumber 
	 * @return A string combination of areaCode, prefix, and lineNumber like (613) 456-1222
	 */
	public String toString() {return "(" + getAreaCode() +") "+ getPrefix() + "-" + getLineNumber();}
}
