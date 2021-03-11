// This class represents the Water sensor class in the wireless security system.
public class WaterSensor extends SecurityDevice {

	public static String deviceID = "watersensor";
	// current water level
	private int waterLevel;

	// Initial values for WaterSensor.
	public WaterSensor() {
		super(deviceID);
		waterLevel = 0;
	}

	// Sets water level to be tested
	public void setWaterLevel(int level) {
		waterLevel = level;
	}

	// Getter for Water Level
	public int getWaterLevel() {
		return waterLevel;
	}

	// Private method that checks for correct water level. 50 is the threshold!
	private boolean checkWaterLevel() {
		if (waterLevel > 50) {
			return true;
		} else {
			return false;
		}
	}

	// Sends Water Sensor Messages.
	public void sendAlert() {
		if (checkWaterLevel() && isOn) {
			super.sendAlert("ALERT! WATER ISSUE DETECTED!");
		} else {
			super.sendAlert("Water Sensor detects no problems.");
		}

	}

	public void sendMessage() {

	}

	// resets Water Sensor to initial values.
	public void reset() {
		waterLevel = 0;
	}

}
