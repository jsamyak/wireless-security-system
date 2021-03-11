
public class SmokeDetector extends SecurityDevice {

    private static int mySmokeLevel;
    private static final int mySmokeThreshold = 50;
    private static boolean myAlert;
    private static boolean isArmed;

    public SmokeDetector() {
        super(deviceID);
        mySmokeLevel = 0;
        myAlert = false;
        isArmed = true;
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
            super.sendAlert("ALERT! SMOKE  DETECTED!");
        } else {
            myAlert = false;
            super.sendAlert("No Smoke Detected");
        }
    }
}