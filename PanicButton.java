// This class represents the Panic button class in the wireless security system.
public class PanicButton extends SecurityDevice {

	// The device ID of the hardware.
	public static final String deviceID = "Panicbutton";
	// Boolean for alert
	public boolean alert;
	// Boolean for device armed
	private boolean armed;
	// Distance from BaseStation
	private int distance;

	// Initial values for WaterSensor.
	public PanicButton() {
		super(deviceID);
		distance = 0;
		alert = false;
		armed = true;
	}

	// Chooses whether or not Panic Button is on silent or not
	public String onSilentAlarmMode(boolean mode) {
		if (mode) {
			armed = false;
			return ("Panic Button is now on Silent Mode.");
		} else {
			armed = true;
			return ("Panic Button is off Silent Mode.");
		}
	}

	// Sets the range you are from the device
	public void setDistance(int range) {
		distance = range;
	}

	// Method that allows you to press panic button.
	public void pressButton() {
		if (isInRange()) {
			super.sendAlert("ALARM ACTIVATED", deviceID);
			startAlarm();
			notifyAuthority();
		} else {

		}
	}

	// Method that chooses correct alarm output.
	private void startAlarm() {
		if (armed && isConnected) {
			alert = true;
			super.sendAlert("ALARM! PANIC BUTTON PRESSED!", deviceID);
		} else {
			super.sendAlert("Panic Button was pressed on silent mode.", deviceID);
		}
	}

	// Method that notifies if the authorities have been called.
	private void notifyAuthority() {
		if (armed && isConnected) {
			super.sendAlert("The nearby authorities are on their way!", deviceID);
		} else {
			super.sendAlert("The authorities have not been contacted.", deviceID);
		}
	}

	// used to check for if device is in range of Base Station.
	private boolean isInRange() {
		if (distance < 100) {
			return true;
		} else {
			return false;
		}
	}

}
