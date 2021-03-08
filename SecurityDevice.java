public class SecurityDevice {
    public static String deviceID;
    public static boolean isBatteryLow;
    public static boolean isConnected;
    public static boolean isOn;
    public static boolean isOff;

    public SecurityDevice(String deviceID) {
        deviceID = SecurityDevice.deviceID;
    }

    public static boolean doStatusCheck() {
        return isConnected;
    }

    public static void sendAlert() {
        System.out.println("SECURITY ALERT");
    }

    public static String getDeviceID() {
        return deviceID;
    }

    public static void turnOn() {
        isOn = true;
        isOff = false;
    }

    public static void turnOff() {
        isOff = true;
        isOn = false;
    }
}