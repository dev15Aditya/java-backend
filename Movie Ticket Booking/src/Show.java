
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Show {
    private int id;
    private Movie movie;
    private LocalDateTime time;
    private List<Seat> seats;

    public Show(int id, Movie movie, LocalDateTime time, int totalSeatsPerCategory){
        this.id = id;
        this.movie = movie;
        this.time = time;
        this.time = time;
        int seatNo = 1;
        for(SeatCategory cat: SeatCategory.values()){
            for(int i = 0; i < totalSeatsPerCategory; i++){
                seats.add(new Seat(seatNo++, cat));
            }
        }
    }

    public int getId(){
        return id;
    }
    public Movie getMovie(){
        return movie;
    }
    public LocalDateTime getTime(){
        return time;
    }

    public void displaySeats(){
        System.out.println("\nSeats for " + movie.getTitle() + " (" + 
            time.format(DateTimeFormatter.ofPattern("dd MMM HH:mm")) + "):");

        
    }
}
