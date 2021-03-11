/**
 * TCSS 360 - Project 3
 * 
 * @author hphobbs
 * @version Winter 2021
 *
 */

public class SmokeSensor extends SecurityDevice {

	private static int mySmokeLevel;
	private static final int mySmokeThreshold = 50;
	private static boolean myAlert = false;
	private static boolean isArmed = true;

	public SmokeSensor() {
		super(deviceID);
		mySmokeLevel = 0;
	}

	public int getSmokeLevel() {
		return mySmokeLevel;
	}

	private void armDevice(boolean isArmed) {
		if (isArmed) {
			isArmed = true;
			System.out.println("Smoke Sensor armed.");
		} else {
			isArmed = false;
			System.out.println("Smoke Sensor disarmed.");
		}
	}

	public static void sendAlert() {
		if (isArmed && (mySmokeLevel >= mySmokeThreshold)) {
			myAlert = true;
			System.out.println("ALERT! SMOKE  DETECTED!");
		} else {
			myAlert = false;
			System.out.println("Not Smoke Detected");
		}

	}

	/*
	 * Stop Alerting a Fire
	 */
	public void reset() {
		myAlert = false;
		isArmed = true;
	}
}
