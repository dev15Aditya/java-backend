public enum VehicleType {
    CAR(50),
    BIKE(30);

    private final int ratePerHour;

    VehicleType(int rate) {
        this.ratePerHour = rate;
    }

    public int getRate() {
        return ratePerHour;
    }
}
