// Головний клас
public class Main {
    public static void main(String[] args) {
        Booking booking = new Booking();

        // Використання стратегії оплати карткою
        booking.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        booking.processPayment(200.0);

        // Використання стратегії оплати через PayPal
        booking.setPaymentStrategy(new PayPalPayment("user123@gmail.com"));
        booking.processPayment(350.0);
    }
}
