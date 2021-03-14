// This class represents the parent class for all types of sensors and detectors.
public class SecurityDevice {

    // The device ID of the hardware.
    public String deviceID;

    // Stores the status of if battery is low.
    public static boolean isBatteryLow;

    // Stores the state of connection.
    public static boolean isConnected = true;

    // Stores if the device is on.
    public static boolean isOn = true;
    
    public String DeviceName;
    

    // Contructor of the class.
    // @param deviceID the device ID of the device.
    public SecurityDevice(String deviceID) {
        this.deviceID = deviceID;
    }

    // Returns the status of the device.
    public String doStatusCheck() {
        String sts = "\n" + deviceID + "\n";
        if(isConnected)
            sts += "Device is connected \n";
        else
            sts += "Device is not connected \n";
        
        if(isOn)
            sts += "Device is On \n";
        else
            sts += "Device is Off \n";
        
        if(isBatteryLow)
            sts += "Device's battery is Low";
        
        return sts;
    }

    // Sends an alert if the any sensor / detector is triggered.
    public static void sendAlert(String displayText, String id) {
        BaseStation.SendAlert(displayText, id);
    }

    // Returns the device ID of the device.
    public String getDeviceID() {
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