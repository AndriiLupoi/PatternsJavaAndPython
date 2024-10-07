// Основний клас для запуску системи.
public class Main {
    public static void main(String[] args) {
        TicketMediator mediator = new TicketMediator();

        User user = new User(mediator);
        Cinema cinema = new Cinema(mediator);
        PaymentGateway paymentGateway = new PaymentGateway(mediator);

        mediator.setUser(user);
        mediator.setCinema(cinema);
        mediator.setPaymentGateway(paymentGateway);

        // Користувач купує квиток
        user.buyTicket();
    }
}
