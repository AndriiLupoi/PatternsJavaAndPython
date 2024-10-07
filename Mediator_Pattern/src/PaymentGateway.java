// Клас для обробки платежів через медіатор.
public class PaymentGateway extends Component {
    public PaymentGateway(Mediator mediator) {
        super(mediator);
    }

    public void processPayment() {
        System.out.println("Платіжна система: обробка платежу.");
        sendEvent("paymentProcessed");
    }
}
