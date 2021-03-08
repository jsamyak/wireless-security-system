// This class represents the parent class for all types of sensors and detectors.
public class SecurityDevice {

    // The device ID of the hardware.
    public static String deviceID;

    // Stores the status of if battery is low.
    public static boolean isBatteryLow;

    // Stores the state of connection.
    public static boolean isConnected;

    // Stores if the device is on.
    public static boolean isOn;

    // Contructor of the class.
    // @param deviceID the device ID of the device.
    public SecurityDevice(String deviceID) {
        deviceID = SecurityDevice.deviceID;
    }

    // Returns the status of the device.
    public static boolean doStatusCheck() {
        return isConnected;
    }

    // Sends an alert if the any sensor / detector is triggered.
    public static void sendAlert() {
        System.out.println("SECURITY ALERT");
    }

    // Returns the device ID of the device.
    public static String getDeviceID() {
        return deviceID;
    }

    // Turns on the device.
    public static void turnOn() {
        isOn = true;
    }

    // Turns off the device.
    public static void turnOff() {
        isOn = false;
    }
}