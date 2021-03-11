package packageForbaseStation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseStation {
	
	//serial number of the base station
	int SerialNo;
	
	//map containing deviceID as key and value as security device object
	HashMap<Integer, SecurityDevice> allDevices;
	
	//keypad object
	WirelessKeypad theKeypad;
	
	//some boolean variables
	boolean isOn;
	boolean isOff;
	boolean hasLowBattery;
	
	//If base station is on power saving mode
	boolean onBetteryMode;
	
	//Device ID for the base station
	int myDeviceID;
	 
	/**
	 * Constructor
	 * @param requires list of all linked devices in the system as a List<>
	 */
	public BaseStation(List<SecurityDevice> linkedDevice) {
		
		//initialize the hashmap
		allDevices = new HashMap<>();
		
		//add all security devices in the map<> 
		for(SecurityDevice d : linkedDevice) {
			
			allDevices.put(d.DeviceID, d);			
		}
	}
	
	/**
	 * Method to check status of the given device ID
	 * @param DeviceID int type
	 * @return String representation of the check status 
	 */
	public String checkStatus(int DeviceID) {
		
		//calls the device's check status method
		String status = (allDevices.get(DeviceID)).checkStatus();
		
		return status;
	}
	
	public boolean activateDevice(int DeviceID) {
		
		//if device is inactive, then activate and return true to notify it is been activated
		if(!allDevices.get(DeviceID).isActive) {
			
			allDevices.get(DeviceID).isActive = true;
			return true;
		}
		
		//False if it is already activated
		return false;
	}
	
	public boolean dactivateDevice(int DeviceID) {
		
		//if device is active, then deactivate and return true to notify it is been deactivated
		if(allDevices.get(DeviceID).isActive) {
			
			allDevices.get(DeviceID).isActive = false;
			return true;
		}
		
		//False if it is already deactivated
		return false;
	}
	
	public boolean isConnected(int DeviceID) {
		
		//return true if the device is active and false it not.
		return allDevices.get(DeviceID).isActive;
	}
	
	/**
	 * Method to broadcast the message received from securityDevice 
	 * @param theMessage the string message, int the id of the device 
	 */
	public void BroadCastMessage(String theMessage, int id) {
		
		theKeypad.BroadCastMessage(theMessage,	id);
	}
	
	/**
	 * Method to sendAlert to the wireless keypad 
	 * @param theAlert alert message as string
	 * @param id int id of the device
	 */
	public void SendAlert(String theAlert, int id) {		
		theKeypad.sendAlert(theAlert, id);
	}
	
	/**
	 * Method to change current mode of the system
	 * @param theMode string mode value received from keypad
	 */
	public void changeMode(String theMode) {
		
		if((theMode.toLowerCase()).equals("deactivate")) {
			
			//Iterate over the device and deactivate all of them
			for(int key: allDevices.keySet()) {				
				allDevices.get(key).isActive = false;
			}
		}
		else if((theMode.toLowerCase()).equals("activate") || (theMode.toLowerCase()).equals("away")) {
			
			//Iterate over the device and activate all of them
			for(int key: allDevices.keySet()) {				
				allDevices.get(key).isActive = true;
			}
		}
		else if((theMode.toLowerCase()).equals("home")) {
			
			//Iterate over the device and deactivate all of in house camera
			for(int key: allDevices.keySet()) {		
				
				//only deactivates the in house camera
				if(allDevices.get(key).DeviceName.equals("camera")) {
					allDevices.get(key).isActive = false;
				}
			}
		}
	}
	
	/**
	 * Method to get all sync devices with our system
	 * @return list of current sync devices
	 */
	public List<SecurityDevice> getAllSyncDevices(){
		
		List<SecurityDevice> list = new ArrayList<>();
		
		//iterate over the list of security devices
		for(int key : allDevices.keySet()) {
			
			//add to the return list only if the component is active
			if(allDevices.get(key).isActive) {
				list.add(allDevices.get(key));
			}
		}
		
		return list;
	}
	
	/**
	 * method to turn on the base station and on all linked devices
	 */
	public void turnOn() {
		
		this.isOff = false;
		this.isOn = true;
		
		//Iterate over the device and turn on all device
		for(int key: allDevices.keySet()) {		
			
			allDevices.get(key).isOn = true;
			allDevices.get(key).isOff = false;
		}
		
	}
	
	/**
	 * method to turn off the base station and also off all linked devices
	 */
	public void turnOff() {
		
		this.isOff = true;
		this.isOn = false;
		
		//Iterate over the device and turn on all device
		for(int key: allDevices.keySet()) {		
			
			allDevices.get(key).isOn = false;
			allDevices.get(key).isOff = true;
		}
		
	}
}

class WirelessKeypad{
	
	public WirelessKeypad() {
		//constructor
	}
	
	public void sendAlert(String alert, int id) {
		System.out.println("Alert!! \nReceived from Device "+ id +" : " + alert);
	}

	public void BroadCastMessage(String msg, int id) {
		System.out.println("Message!! \nReceived from Device "+ id +" : " + msg);
	}
}

class SecurityDevice{
	
	int DeviceID;
	boolean isActive;
	boolean isOn;
	boolean isOff;
	String DeviceName;
	
	public String checkStatus() {
		return "temp check status";
	}
	
}
