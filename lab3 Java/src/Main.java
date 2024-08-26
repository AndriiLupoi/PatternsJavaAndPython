import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ClientFactory clientFactory = new ClientFactory();
        MovieFactory movieFactory = new MovieFactory();
        SeatFactory seatFactory = new SeatFactory();
        OrderFactory orderFactory = new OrderFactory();

        Client client1 = clientFactory.createClient("Volodya", "228");
        Movie movie1 = movieFactory.createMovie("Titanic", "Drama", LocalDateTime.now().plusHours(4));
        Seat seat1 = seatFactory.createSeat(10, false);

        Order originalOrder = orderFactory.createOrder(client1, movie1, seat1);


        System.out.println("Original Order: " + originalOrder);
    }
}