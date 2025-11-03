public class Seat {
    private int seatNo;
    private SeatCategory category;
    private boolean booked;

    public Seat(int seatNo, SeatCategory category){
        this.seatNo = seatNo;
        this.category = category;
        this.booked = false;
    }

    public int getSeatNo(){
        return seatNo;
    }

    public SeatCategory getCategory(){
        return category;
    }

    public boolean isBooked(){
        return booked;
    }

    public void book(){
        this.booked = true;
    }

    public void cancel(){
        this.booked = false;
    }

    @Override
    public String toString() {
        return "[" + seatNo + " " + category + (booked ? " X" : " ✓") + "]";
    }
}


