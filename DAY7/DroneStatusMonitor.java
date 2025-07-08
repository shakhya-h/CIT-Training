import java.util.*;

class InvalidBatteryException extends Exception {
    public InvalidBatteryException(String message) {
        super(message);
    }
}

public class DroneStatusMonitor {
    public static void main(String[] args) {
        HashMap<Integer, Double> droneBatteryMap = new HashMap<>();
        try {
            addDrone(droneBatteryMap, 1, 45.0);
            addDrone(droneBatteryMap, 2, 10.0);    
            addDrone(droneBatteryMap, 3, 90.5);
            addDrone(droneBatteryMap, 4, 15.0);    
           // addDrone(droneBatteryMap, 5, 102.0);   

            System.out.println(" Drone Battery Status:");
            for (Map.Entry<Integer, Double> entry : droneBatteryMap.entrySet()) {
                int droneID = entry.getKey();
                double battery = entry.getValue();
                String status = (battery <= 15) ? "Needs Recharge" : "OK";
                System.out.println("Drone ID: " + droneID + "  Battery: " + battery + "%  " + status);
                Double maxValue = Collections.max(droneBatteryMap.values());
                System.out.println("The drone with the maximum battery is:");
            }

        } catch (InvalidBatteryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addDrone(HashMap<Integer, Double> map, int droneID, double battery) throws InvalidBatteryException {
        if (battery > 100) {
            throw new InvalidBatteryException("Battery cannot exceed 100% for Drone ID: " + droneID);
        }
        map.put(droneID, battery);
    }
}