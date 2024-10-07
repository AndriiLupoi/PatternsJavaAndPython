// Клас кінотеатру, що надає місця для бронювання через медіатора.
public class Cinema extends Component {
    public Cinema(Mediator mediator) {
        super(mediator);
    }

    public void bookSeat() {
        System.out.println("Кінотеатр: бронювання місця.");
        sendEvent("seatBooked");
    }
}

