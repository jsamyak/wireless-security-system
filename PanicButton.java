/*
 * GROUP 1
 * by: Christian Wall
 * TCSS 360 - Winter 2021 Project
 */


public class PanicButton extends SecurityDevice{

//  Driver method for testing.
//	public static void main(String[] args) {
//		PanicButton button = new PanicButton();
//		turnOn();
//		button.onSilentAlarmMode(true);
//		button.setRange(50);
//		button.pressButton();
//
//	}
	
    // The device ID of the hardware.
    public static String deviceID = "panicbutton";
	//Boolean for alert
	public boolean alert;
	//Boolean for device armed
	private boolean armed;
	//Distance from BaseStation
	private int distance;
	
	//Initial values for WaterSensor.
    public PanicButton() {
    	super(deviceID);
    	distance = 0;
    	alert = false;
    	armed= true;
    }
    //Chooses whether or not Panic Button is on silent or not
    public void onSilentAlarmMode(boolean mode) {
    	if (mode) {
    		armed = false;
    		System.out.println("Panic Button is now on Silent Mode.");
    	}
    	else {
    		armed = true;
    		System.out.println("Panic Button is off Silent Mode.");
    	}
    }
    //Sets the range you are from the device
    public void setRange(int range) {
    	distance = range;
    }
    //Method that allows you to press panic button.
    public void pressButton() {
    	if (isInRange()) {
    		sendAlert();
    		startAlarm();
    		notifyAuthority();
    	}
    	else {
    		
    	}
    }
    //Method that chooses correct alarm output.
    private void startAlarm() {
    	if (armed && isOn) {
    		alert = true;
    		System.out.println("ALERT! PANIC BUTTON PRESSED!");
    	}
    	else {
    		System.out.println("Panic Button was pressed on silent mode.");
    	}
    }
    //Method that notifies if the authorities have been called.
    private void notifyAuthority() {
    	if (armed && isOn) {
    		System.out.println("The nearby authorities are on their way!");
    	}
    	else {
    		System.out.println("The authorities have not been contacted.");
    	}
    }
    //used to check for if device is in range of Base Station.
    private boolean isInRange() {
    	if(distance < 100) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
