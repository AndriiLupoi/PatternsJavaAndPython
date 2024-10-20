// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створення нового контексту замовлення
        BookingContext booking = new BookingContext();

        // Перехід через стани
        booking.proceed();  // Створено
        booking.proceed();  // Оплачено
        booking.proceed();  // Скасовано
    }
}
