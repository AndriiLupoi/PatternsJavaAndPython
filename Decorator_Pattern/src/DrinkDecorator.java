// Конкретний декоратор для додавання напою
class DrinkDecorator extends SeatBookingDecorator {
    public DrinkDecorator(SeatBooking seatBooking) {
        super(seatBooking);
    }

    @Override
    public void book() {
        super.book();
        addDrink();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 30.0; // Додаємо вартість напою
    }

    private void addDrink() {
        System.out.println("Drink added to booking.");
    }
}
