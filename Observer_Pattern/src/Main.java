public class Main {
    public static void main(String[] args) {
        // Створення системи бронювання
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        // Створення користувачів
        User user1 = new User("Volodya");
        User user2 = new User("Petya");
        User user3 = new User("Olena");

        // Додаємо користувачів як спостерігачів
        bookingSystem.addObserver(user1);
        bookingSystem.addObserver(user2);
        bookingSystem.addObserver(user3);

        // Нова подія бронювання
        bookingSystem.newBooking("Місце №12, Фільм: Avatar");

        // Вилучаємо одного спостерігача та додаємо нове бронювання
        bookingSystem.removeObserver(user2);
        bookingSystem.newBooking("Місце №15, Фільм: Titanic");
    }
}
