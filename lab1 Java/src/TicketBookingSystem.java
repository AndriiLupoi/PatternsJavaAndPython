import java.util.List;
import java.util.ArrayList;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;
    private List<Order> orders;

    public TicketBookingSystem() {
        orders = new ArrayList<>();
    }

    public static synchronized TicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new TicketBookingSystem();
        }
        return instance;
    }

    public void addOrder(Client client, Movie movie, Seat seat) {
        if (!seat.isBooked()) {
            orders.add(new Order(client, movie, seat));
            seat.setBooked(true);
        } else {
            System.out.println("Seat " + seat.getSeatNumber() + " is already booked.");
        }
    }

    @Override
    public String toString() {
        return "Orders{" + orders +
                '}';
    }

}
