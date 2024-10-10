// Клас Booking, який має можливість створювати та відновлювати свій стан через Memento
public class Booking {
    private String state;

    public void setState(String state) {
        System.out.println("Змінюємо стан бронювання: " + state);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // Створення Memento для збереження поточного стану
    public BookingMemento saveStateToMemento() {
        System.out.println("Збереження стану: " + state);
        return new BookingMemento(state);
    }

    // Відновлення стану з Memento
    public void getStateFromMemento(BookingMemento memento) {
        state = memento.getState();
        System.out.println("Відновлення стану: " + state);
    }
}
