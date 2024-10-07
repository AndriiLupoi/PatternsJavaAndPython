// Клас користувача, який взаємодіє з медіатором для купівлі квитків.
public class User extends Component {
    public User(Mediator mediator) {
        super(mediator);
    }

    public void buyTicket() {
        System.out.println("Користувач: хочу купити квиток.");
        sendEvent("buyTicket");
    }

    public void receiveTicket() {
        System.out.println("Користувач: отримав квиток.");
    }
}

