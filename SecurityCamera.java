// This class represents the Security Camera class in the wireless security system.
public class SecurityCamera extends SecurityDevice {

	// The device ID of the hardware.
	public static final String deviceID = "SecurityCamera";
	private static boolean motionStatus;
	private static boolean armedStatus;
	public static boolean alert;

	public SecurityCamera() {
		super(deviceID);
		motionStatus = false;
		armedStatus = true;
	}

	// Method getMotionStatus: used to retrieve the motion status of the camera
	boolean getMotionStatus() {
		return motionStatus;
	}

	void record() {

	}

	void takeSnapshot() {

	}

	// Method armDevice is used to arm and disarm the camera
	void armDevice(boolean isArmed) {
		armedStatus = isArmed;
		if (isArmed) {
			System.out.print("Security Camera armed.");
		} else {
			System.out.print("Security Camera disarmed.");
		}
	}

	// Method that generates an alert.
	public void sendAlert() {
		if (armedStatus && motionStatus) {
			super.sendAlert("ALERT! Security Camera detects motion.", deviceID);
		} else if (armedStatus) {
			super.sendAlert("No motion detected by Security Camera.", deviceID);
		} else {
			super.sendAlert("The Security Camera is not armed.", deviceID);
		}
	}

	// Method that sends a message to the MobileNumber class.
	void SendMessage() {
	}
}
