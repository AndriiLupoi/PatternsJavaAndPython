// Конкретна стратегія: Оплата карткою
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " грн через картку. Номер картки: " + cardNumber);
    }
}
