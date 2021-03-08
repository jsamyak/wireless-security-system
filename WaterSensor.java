/*
 * GROUP 1
 * by: Christian Wall
 * TCSS 360 - Winter 2021 Project
 */


public class WaterSensor extends SecurityDevice{
	
//  Driver Method for testing.
	public static void main(String[] args) {
		WaterSensor sensor = new WaterSensor();
		turnOn();
		sensor.setWaterLevel(100);
		sensor.sendMessage();

	}
	//
	public static String deviceID = "watersensor";
	//current water level
	private int waterLevel;

	
	//Initial values for WaterSensor.
    public WaterSensor() {
    	super(deviceID);
    	waterLevel = 0;
    }
    //Sets water level to be tested
    public void setWaterLevel(int level) {
    	waterLevel = level;
    }
    //Getter for Water Level
    public int getWaterLevel() {
    	return waterLevel;
    }
    //Private method that checks for correct water level. 50 is the threshold!
    private boolean checkWaterLevel() {
    	if (waterLevel > 50) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    //Sends Water Sensor Messages.
    public void sendMessage() {
    	if (checkWaterLevel() && isOn) {
    		sendAlert();
    		System.out.println("ALERT! WATER ISSUE DETECTED!");
    	}
    	else {
    		System.out.println("Water Sensor detects no problems.");
    	}
    	
    }

    //resets Water Sensor to initial values.
    public void reset() {
    	waterLevel = 0;
    }

}
