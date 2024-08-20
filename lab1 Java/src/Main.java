import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem manager = TicketBookingSystem.getInstance();

        Client client1 = new Client("Volodya", "228");
        Client client2 = new Client("Petya", "822");

        Movie movie1 = new Movie("Titanic", "Drama", LocalDateTime.now().plusHours(4));
        Movie movie2 = new Movie("Titanic", "Drama", LocalDateTime.now().plusHours(6));

        Seat seat1 = new Seat(10,false);
        Seat seat2 = new Seat(9,true);

        manager.addOrder(client1, movie1, seat1);
        manager.addOrder(client2, movie2, seat2);

        System.out.println(manager.getInstance());
    }
}