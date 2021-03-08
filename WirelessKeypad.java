import java.util.ArrayList;
import java.util.List;

/*
 * This class is for the wireless keypad of the home security system. This
 * class is responsible for login procedures, adding/removing mobile numbers, 
 * turning the system on and off, and displaying alerts to the user.
 */
public class WirelessKeypad {

	//Stores the main password for the system
	final private static String masterPass = "1234";
	
	//Stores the deviceID for the wireless keypad
	final public static String deviceID = "1";
	
	//is this needed?
	String currentMode;
	
	//is this needed?
	private String password;
	
	//List that stores all the mobile numbers in the system
	private static List<String> mobileNumbers = new ArrayList<String>();
	
	/*
	 * Constructor
	 */
	public WirelessKeypad() {
		
				
	}
	
	/*
	 * This method checks to see if the password entered by the user matches the masterpass
	 * for the system.
	 * @param password is the password entered by the user
	 */
	public static boolean checkPassword(String password)
	{
		if (password == masterPass)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * This method displays an alert to the user. The alert is triggered
	 * if one of the system devices discovers a problem.
	 * @param alert is the alert sent by a device
	 * @param id is for the id of the device that sends the alert
	 */
	public static void displayAlert(String alert, int id) 
	{
		System.out.println("Alert!! \nReceived from Device "+ id +" : " + alert);
	}
	
	/*
	 * This method displays an message to the user. The message is triggered
	 * if one of the system devices discovers a problem.
	 * @param message is the message sent by a device
	 * @param id is for the id of the device that sends the message
	 */
	public static void displayMessage(String msg, int id) 
	{
		System.out.println("Message!! \nReceived from Device "+ id +" : " + msg);
	}
	
	/*
	 * This method checks the status of the devices within the system.
	 * The result will be printed
	 * @param deviceID is the id for an individual device in the system.
	 */
	public static void checkStatus(String deviceID)
	{		
		System.out.println("Status Check is complete");
		System.out.println("");
	}
	
	/* IN PROGRESS
	 * This method adds a device to the list of devices in the system.
	 */
//	public static void addDevice(String deviceID)
//	{
		//how does adddevice interact with the devicelist in Basestation class
//	}
	
	/*
	 * This method removes a mobile phone number from the list of numbers in the system.
	 * @param mobileNumber is the number the user selects to be removed from the system
	 */
	private static void removeMobileNo(String mobileNumber)
	{
		for (String number : mobileNumbers)
		{
			if (number == mobileNumber) 
			{
				mobileNumbers.remove(number);
				System.out.println("Your mobile phone number has successfully been removed!");
			}
		}
	}
	
	/*
	 * This method adds a mobile phone number to the list of numbers in the system.
	 * @param mobileNumber is the number the user selects to be added to the system
	 */
	private static void addMobileNo(String mobileNumber)
	{
		mobileNumbers.add(mobileNumber);
		
		System.out.println("Your mobile phone number has successfully been added!");
	}
	
	/*
	 * This method turns off the system.
	 */
	private static void turnOff()
	{
		BaseStation.turnOff();
		System.out.println("The system has been turned off.");
		
	}
	
	/*
	 * This method turns on the system.
	 */
	private static void turnOn()
	{
		BaseStation.turnOn();
		System.out.println("The system has been turned on.");
		
	}
}
