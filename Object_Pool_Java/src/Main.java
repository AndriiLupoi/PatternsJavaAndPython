import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація пулу місць
        SeatPool seatPool = new SeatPool(10);

        // Створюємо клієнтів і фільми
        Client client1 = new Client("Volodya", "228");
        Client client2 = new Client("Petya", "822");

        Movie movie1 = new Movie("Titanic", "Drama", LocalDateTime.now().plusHours(4));
        Movie movie2 = new Movie("Avatar", "Sci-Fi", LocalDateTime.now().plusHours(6));

        // Бронювання місць через Object Pool
        Seat seat1 = seatPool.acquireSeat();
        if (seat1 != null) {
            seat1.setBooked(true);
            Order order1 = new Order(client1, movie1, seat1);
            System.out.println(order1);
        }

        Seat seat2 = seatPool.acquireSeat();
        if (seat2 != null) {
            seat2.setBooked(true);
            Order order2 = new Order(client2, movie2, seat2);
            System.out.println(order2);
        }

        // Повертаємо місця в пул після використання
        seatPool.releaseSeat(seat1);
        seatPool.releaseSeat(seat2);

        System.out.println("Available seats after release: " + seatPool.getAvailableSeats());
    }
}
