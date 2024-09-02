public class PremiumSeat implements Seat {
    private int seatNumber;
    private boolean isBooked;

    public PremiumSeat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    @Override
    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public void book() {
        this.isBooked = true;
    }

    @Override
    public String toString() {
        return "PremiumSeat{" + "seatNumber=" + seatNumber + ", isBooked=" + isBooked + '}';
    }
}
