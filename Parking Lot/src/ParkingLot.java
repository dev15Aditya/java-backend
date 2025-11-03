
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Slot> slots;
    private double totalRevenue;

    public ParkingLot(int capacity){
        slots = new ArrayList<>();

        for(int i = 1; i <= capacity; i++){
            slots.add(new Slot(i));
        }

        totalRevenue = 0;
    }

    public void parkVehicle(String number, VehicleType type){
        for(Slot s: slots){
            if(s.isEmpty()){
                s.assignVehicle(new Vehicle(number, type));
                System.out.println(type + " " + number + " parked at slot " + s.getId());
                displayStatus();
                return;
            }
        }

        System.out.println("Sorry! Parking full.");
    }

    public void removeVehicle(String number){
        for(Slot s: slots){
            Vehicle v = s.getVehicle();
            if(v != null && v.getNumber().equals(number)){
                double fee = v.calculateFee();
                s.removeVehicle();
                totalRevenue += fee;
                System.out.println(v.getType() + " " + number + " removed from slot " + s.getId());
                System.out.println("Parking fee: " + fee);
                displayStatus();
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }


    public void displayStatus(){
        System.out.println("\n==== PARKING STATUS ====");
        for(Slot s: slots){
            if(s.isEmpty()){
                System.out.println("Slot " + s.getId() + ": [Empty]");
            } else {
                Vehicle v = s.getVehicle();
                System.out.println("Slot " + s.getId() + ": " + v.getType() + " " + v.getNumber() +
                        " (since " + v.getEntryTimeFormatted() + ")");
            }
        }
        System.out.println("=========================");
    }

    public double getTotalRevenue(){
        return totalRevenue;
    }
}
