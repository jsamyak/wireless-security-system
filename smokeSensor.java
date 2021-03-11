/**
 * TCSS 360 - Project 3
 * 
 * @author hphobbs
 * @version Winter 2021
 *
 */

public class smokeSensor {

	private int mySmokeLevel = 0;
	private static int mySmokeThreshold = 50;
	private boolean myAlert = false;
	private boolean isArmed = true;

	public void setSmokeLevel(int theSmokeLevel) {
		mySmokeLevel = theSmokeLevel;

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

	public void sendAlert() {
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
