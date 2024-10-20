// Конкретний стан: Скасовано
public class CancelledState implements BookingState {
    @Override
    public void handle(BookingContext context) {
        System.out.println("Замовлення скасовано. Кошти повернуто.");
    }
}
