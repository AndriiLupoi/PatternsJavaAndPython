import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Створюємо замовлення за допомогою патерну Будівельник
        Order order1 = new Order.Builder()
                .setClient(new Client("Volodya", "228"))
                .setMovie(new Movie("Titanic", "Drama", LocalDateTime.now().plusHours(4)))
                .setSeat(new Seat(10, false))
                .build();

        Order order2 = new Order.Builder()
                .setClient(new Client("Petya", "822"))
                .setMovie(new Movie("Titanic", "Drama", LocalDateTime.now().plusHours(6)))
                .setSeat(new Seat(9, true))
                .build();

        System.out.println(order1);
        System.out.println(order2);
    }
}
