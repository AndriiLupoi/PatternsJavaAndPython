// Конкретний медіатор, який координує взаємодію між компонентами системи бронювання.
public class TicketMediator implements Mediator {
    private User user;
    private Cinema cinema;
    private PaymentGateway paymentGateway;

    public void setUser(User user) {
        this.user = user;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Метод для обробки повідомлень від різних компонентів
    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof User && event.equals("buyTicket")) {
            System.out.println("Медіатор: користувач хоче купити квиток.");
            cinema.bookSeat();
        } else if (sender instanceof Cinema && event.equals("seatBooked")) {
            System.out.println("Медіатор: місце заброньовано, обробка платежу.");
            paymentGateway.processPayment();
        } else if (sender instanceof PaymentGateway && event.equals("paymentProcessed")) {
            System.out.println("Медіатор: оплата пройшла успішно. Видача квитка.");
            user.receiveTicket();
        }
    }
}
