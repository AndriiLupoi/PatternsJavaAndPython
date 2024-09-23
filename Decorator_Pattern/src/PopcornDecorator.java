// Конкретний декоратор для додавання попкорну
class PopcornDecorator extends SeatBookingDecorator {
    public PopcornDecorator(SeatBooking seatBooking) {
        super(seatBooking);
    }

    @Override
    public void book() {
        super.book();
        addPopcorn();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 50.0; // Додаємо вартість попкорну
    }

    private void addPopcorn() {
        System.out.println("Popcorn added to booking.");
    }
}