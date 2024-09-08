public class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber, boolean isBooked) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Seat{" + "seatNumber=" + seatNumber + ", isBooked=" + isBooked + '}';
    }
}
