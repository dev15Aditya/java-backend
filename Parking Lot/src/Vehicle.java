
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehicle {
    private String number;
    private VehicleType type;
    private LocalDateTime entryTime;

    public Vehicle(String number, VehicleType type){
        this.number = number;
        this.type = type;
        this.entryTime = LocalDateTime.now();
    }

    public String getNumber(){
        return number;
    }

    public VehicleType getType(){
        return type;
    }

    public String getEntryTimeFormatted(){
        return entryTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public double calculateFee(){
        LocalDateTime exitTime = LocalDateTime.now();
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        double hours = Math.ceil(minutes/60.0);

        if(hours == 0) hours = 1;
        return hours * type.getRate();
    }
}
