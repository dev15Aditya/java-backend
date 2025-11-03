public enum SeatCategory {
    SILVER(120),
    GOLD(180),
    PLATINIUM(250);

    private final int price;

    private SeatCategory(int price) {
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
