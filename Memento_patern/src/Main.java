
public class Main {
    public static void main(String[] args) {
        Booking booking = new Booking();
        Caretaker caretaker = new Caretaker();

        // Створюємо та зберігаємо різні стани бронювання
        booking.setState("Місце №1: Бронювання розпочате");
        caretaker.add(booking.saveStateToMemento());

        booking.setState("Місце №1: Підтверджено");
        caretaker.add(booking.saveStateToMemento());

        booking.setState("Місце №1: Оплачено");
        caretaker.add(booking.saveStateToMemento());

        // Відновлення станів бронювання
        System.out.println("\nВідновлення стану до попередньої дії:");
        booking.getStateFromMemento(caretaker.get(1));

        System.out.println("\nВідновлення стану до першої дії:");
        booking.getStateFromMemento(caretaker.get(0));
    }
}


