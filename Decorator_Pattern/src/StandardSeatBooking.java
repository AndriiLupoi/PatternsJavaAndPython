// Конкретна реалізація бронювання місця
class StandardSeatBooking implements SeatBooking {
    @Override
    public void book() {
        System.out.println("Standard seat booked.");
    }

    @Override
    public double getPrice() {
        return 100.0; // Стандартна ціна за місце
    }
}