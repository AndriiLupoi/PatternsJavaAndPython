public class Seat implements TickedBookingSystemPrototype {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber, boolean isBooked) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
    }

    @Override
    public Seat clone() {
        return new Seat(this.seatNumber, this.isBooked);
    }

    @Override
    public String toString() {
        return "Seat{" + "seatNumber=" + seatNumber + ", isBooked=" + isBooked + '}';
    }
}
