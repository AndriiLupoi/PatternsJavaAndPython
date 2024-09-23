// Абстрактний клас декоратора, який буде розширювати функціонал бронювання
abstract class SeatBookingDecorator implements SeatBooking {
    protected SeatBooking decoratedSeatBooking;

    public SeatBookingDecorator(SeatBooking seatBooking) {
        this.decoratedSeatBooking = seatBooking;
    }

    @Override
    public void book() {
        decoratedSeatBooking.book();
    }

    @Override
    public double getPrice() {
        return decoratedSeatBooking.getPrice();
    }
}