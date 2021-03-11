/*
 * TCSS 360 Winter 2021
 * Group 1, Project Assignment 3
 * Author: Kenneth Copeland
 */

public class SecurityCamera {

	private boolean motionStatus;
	private boolean armedStatus;
	public boolean alert;

	public SecurityCamera() {
		this.motionStatus = false;
		this.armedStatus = true;
	}

	// Method getMotionStatus: used to retrieve the motion status of the camera

	boolean getMotionStatus() {
		return this.motionStatus;
	}

	// Method armDevice is used to arm and disarm the camera

	void armDevice(boolean isArmed) {
		this.armedStatus = isArmed;
		if (isArmed) {
			System.out.print("Security Camera armed.");
		} else {
			System.out.print("Security Camera disarmed.");
		}
	}

	// Method that generates an alert.

	void sendAlert() {
		if (this.armedStatus && this.motionStatus) {
			System.out.print("ALERT! Security Camera detects motion.");
		} else if (this.armedStatus) {
			System.out.print("No motion detected by Security Camera.");
		} else {
			System.out.print("The Security Camera is not armed.");
		}
	}

	// Method that sends a message to the MobileNumber class.

	void SendMessage() {

	}
}
