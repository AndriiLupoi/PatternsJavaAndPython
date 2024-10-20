// Конкретний стан: Оплачено
public class PaidState implements BookingState {
    @Override
    public void handle(BookingContext context) {
        System.out.println("Замовлення оплачено. Місця заброньовані.");
        context.setState(new CancelledState());  // Перехід до стану "Скасовано"
    }
}
