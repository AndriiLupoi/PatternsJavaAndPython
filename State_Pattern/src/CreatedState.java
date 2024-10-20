// Конкретний стан: Створено
public class CreatedState implements BookingState {
    @Override
    public void handle(BookingContext context) {
        System.out.println("Замовлення створено. Очікує на оплату.");
        context.setState(new PaidState());  // Перехід до стану "Оплачено"
    }
}
