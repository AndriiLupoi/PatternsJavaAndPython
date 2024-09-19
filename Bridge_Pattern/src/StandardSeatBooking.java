public class StandardSeatBooking extends SeatBooking {
    public StandardSeatBooking(SeatImplementor implementor) {
        super(implementor);
    }

    @Override
    public void bookSeat() {
        implementor.reserve();
    }

    @Override
    public void releaseSeat() {
        implementor.release();
    }
}
