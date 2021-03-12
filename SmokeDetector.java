// This class represents the Smoke Detecotr class in the wireless security system.
public class SmokeDetector extends SecurityDevice {

    // The device ID of the hardware.
    public static final String deviceID = "SmokeDetector";
    private static int mySmokeLevel;
    private static final int mySmokeThreshold = 50;
    private static boolean isArmed;

    public SmokeDetector() {
        super(deviceID);
        mySmokeLevel = 0;
        isArmed = true;
    }

    public int getSmokeLevel() {
        return mySmokeLevel;
    }

    public void armDevice(boolean isArmed) {
        if (isArmed) {
            System.out.println("Smoke Sensor armed.");
        } else {
            System.out.println("Smoke Sensor disarmed.");
        }
    }

    public void sendAlert() {
        if (isArmed && (mySmokeLevel > mySmokeThreshold)) {
            super.sendAlert("ALERT! SMOKE  DETECTED!", deviceID);
        } else {
            super.sendAlert("No Smoke Detected", deviceID);
        }
    }

    public void setSmokeLevel(int level){
        this.mySmokeLevel = level;
    }
    
    // Method that sends a message to the MobileNumber class.
    void SendMessage() {
    }
}