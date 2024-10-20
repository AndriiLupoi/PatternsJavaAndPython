// Конкретна стратегія: Оплата через PayPal
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " грн через PayPal. Email: " + email);
    }
}
