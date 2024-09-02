import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Volodya", "228");
        Movie movie1 = new Movie("Titanic", "Drama", LocalDateTime.now().plusHours(4));
        Seat seat1 = new Seat(10, true);

        Order originalOrder = new Order(client1, movie1, seat1);

        Order clonedOrder = originalOrder.clone();

        System.out.println("Original Order: " + originalOrder);
        System.out.println("\n");
        System.out.println("Cloned Order: " + clonedOrder);
    }
}
