// Клас Memento зберігає стан бронювання
public class BookingMemento {
    private final String state;

    public BookingMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
