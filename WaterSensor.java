/*
 * GROUP 1
 * by: Christian Wall
 * TCSS 360 - Winter 2021 Project
 */


public class WaterSensor {
	
//  Driver Method for testing.
//	public static void main(String[] args) {
//		WaterSensor sensor = new WaterSensor();
//		sensor.setWaterLevel(100);
//		sensor.armDevice(false);
//		sensor.sendAlert();
//
//	}
	
	//current water level
	private int waterLevel;
	//Boolean for alert
	public boolean alert;
	//Boolean for device armed
	private boolean armed;
	
	//Initial values for WaterSensor.
    public WaterSensor() {
    	waterLevel = 0;
    	alert = false;
    	armed= true;
    }
    //Chooses if whether or not to arm device.
    public void armDevice(boolean arm) {
    	if (arm) {
    		armed = true;
    		System.out.println("Water Sensor armed.");
    	}
    	else {
    		armed = false;
    		System.out.println("Water Sensor disarmed.");
    	}
    	
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
    	if (alert && armed) {
    		System.out.println("ALERT! WATER ISSUE DETECTED!");
    	}
    	else {
    		System.out.println("Water Sensor detects no problems.");
    	}
    	
    }
    //Sends alarm messages and checks for water levels.
    public void sendAlert() {
    	if(checkWaterLevel() && armed) {
    		alert = true;
    		sendMessage();
    	}
    	else {
    		alert = false;
    		sendMessage();
    	}
    	
    }
    //resets Water Sensor to initial values.
    public void reset() {
    	waterLevel = 0;
    	alert = false;
    	armed = true;
    }

}
