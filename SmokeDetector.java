
public class SmokeDetector extends SecurityDevice {

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

    private void armDevice(boolean isArmed) {
        if (isArmed) {
            System.out.println("Smoke Sensor armed.");
        } else {
            System.out.println("Smoke Sensor disarmed.");
        }
    }

    public void sendAlert() {
        if (isArmed && (mySmokeLevel >= mySmokeThreshold)) {
            super.sendAlert("ALERT! SMOKE  DETECTED!");
        } else {
            super.sendAlert("No Smoke Detected");
        }
    }

    // Method that sends a message to the MobileNumber class.
    void SendMessage() {
    }
}