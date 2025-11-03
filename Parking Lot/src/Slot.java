public class Slot {
    private int id;
    private Vehicle parkedVehicle;

    public Slot(int id){
        this.id = id;
    }

    public boolean isEmpty(){
        return parkedVehicle == null;
    }

    public void assignVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
    }

    public void removeVehicle(){
        this.parkedVehicle = null;
    }

    public int getId(){
        return id;
    }

    public Vehicle getVehicle(){
        return parkedVehicle;
    }
}
