import java.util.ArrayList;
import java.util.List;

// Конкретний клас Subject
public class TicketBookingSystem implements Subject {
    private List<Observer> observers;
    private String message; // Повідомлення, яке буде сповіщене спостерігачам

    public TicketBookingSystem() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Метод для зміни стану та сповіщення спостерігачів
    public void newBooking(String message) {
        this.message = message;
        System.out.println("Квиток заброньовано: " + message);
        notifyObservers();
    }
}
