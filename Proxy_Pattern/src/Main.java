import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Створюємо клієнтів та фільми
        Client client1 = new Client("Volodya", "228");
        Client client2 = new Client("Petya", "822");

        Movie movie1 = new Movie("Titanic", "Драма", LocalDateTime.now().plusHours(4));
        Movie movie2 = new Movie("Avatar", "Наукова фантастика", LocalDateTime.now().plusHours(6));

        // Створюємо місця
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);

        // Використовуємо Proxy для бронювання
        SeatBookingProxy bookingProxyAdmin = new SeatBookingProxy(true);  // Адміністратор
        SeatBookingProxy bookingProxyUser = new SeatBookingProxy(false);  // Звичайний користувач

        // Адміністратор бронює місце
        bookingProxyAdmin.bookSeat(client1, movie1, seat1);

        // Звичайний користувач намагається бронювати місце
        bookingProxyUser.bookSeat(client2, movie2, seat2);
    }
}
