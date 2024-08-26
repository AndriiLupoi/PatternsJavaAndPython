class SeatFactory {
    public Seat createSeat(int seatNumber, boolean isBooked) {
        return new Seat(seatNumber, isBooked);
    }
}