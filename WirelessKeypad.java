import java.util.ArrayList;
import java.util.List;

/*
 * This class is for the wireless keypad of the home security system. This
 * class is responsible for login procedures, adding/removing mobile numbers, 
 * turning the system on and off, and displaying alerts to the user.
 */
public class WirelessKeypad {

	// Stores the main password for the system
	final private static String masterPass = "1234";

	// Stores the deviceID for the wireless keypad
	final public static String deviceID = "wirelesskeypad";

	// Stores the current system mode. activate/deactivate/home/away
	String currentMode;

	// Stores the password input by the user
	private String password;

	// List that stores all the mobile numbers in the system
	private static List<String> mobileNumbers = new ArrayList<String>();

	/*
	 * Constructor
	 */
	public WirelessKeypad() {
            
	}

	/*
	 * This method checks to see if the password entered by the user matches the
	 * masterpass for the system.
	 * 
	 * @param password is the password entered by the user
	 */
	public static boolean checkPassword(String password) {
		if (password.equals(masterPass)) {
			return true;
		}
		return false;
	}

	/*
	 * This method sets the mode of the system by sending the mode state to the
	 * basestation.
	 * 
	 * @param theMode is the mode set by the user
	 */
	public static String setMode(String theMode) {
		BaseStation.changeMode(theMode);
                if(theMode.equals("deactivate"))
                    return ("System is deactivated now! Be careful");
                
		return ("The mode has been changed to " + theMode);
	}

        static String alertt  = "";
        
	/*
	 * This method displays an alert to the user. The alert is triggered if one of
	 * the system devices discovers a problem.
	 * 
	 * @param alert is the alert sent by a device
	 * 
	 * @param id is for the id of the device that sends the alert
	 */
	public static void displayAlert(String alert, String id) {
		alertt =  alertt + "\n" + ("Alert!! \nReceived from Device " + id + " : " + alert);
	}
        
        public String getAlert(){
            String str = alertt;
            alertt = "";
            return str;
        }

	/*
	 * This method displays an message to the user. The message is triggered if one
	 * of the system devices discovers a problem.
	 * 
	 * @param message is the message sent by a device
	 * 
	 * @param id is for the id of the device that sends the message
	 */
	public static void displayMessage(String msg, String id) {
		System.out.println("Message!! \nReceived from Device " + id + " : " + msg);
	}

	/*
	 * This method checks the status of the devices within the system. The result
	 * will be printed
	 * 
	 * @param deviceID is the id for an individual device in the system.
	 */
	public  String checkStatus(String deviceID) {
            
            return BaseStation.checkStatus(deviceID);
	}

	/*
	 * This method removes a mobile phone number from the list of numbers in the
	 * system.
	 * 
	 * @param mobileNumber is the number the user selects to be removed from the
	 * system
	 */
	public static String removeMobileNo(String mobileNumber) {
		for (String number : mobileNumbers) {
			if (number.equals(mobileNumber)) {
				mobileNumbers.remove(number);
				 return ("Your mobile phone number has successfully been removed!");
			}
		}
                
                return "NO Number found in database!";
	}

	/*
	 * This method adds a mobile phone number to the list of numbers in the system.
	 * 
	 * @param mobileNumber is the number the user selects to be added to the system
	 */
	public static String addMobileNo(String mobileNumber) {
            String regexStr = "^[0-9]{10}$";

            if (mobileNumbers.contains(mobileNumber))
            {
                return ("Your mobile phone number is already in the system.");
            }
            if (mobileNumber.matches(regexStr))
            {
                mobileNumbers.add(mobileNumber);
                return ("Your mobile phone number has successfully been added!");
            } else {
                return ("Invalid number. Please enter a 10 digit phone number.");
            }    
       }

	/*
	 * This method turns off the system.
	 */
	private static void turnOff() {
		BaseStation.turnOff();
		System.out.println("The system has been turned off.");

	}

	/*
	 * This method turns on the system.
	 */
	private static void turnOn() {
		BaseStation.turnOn();
		System.out.println("The system has been turned on.");

	}
}
