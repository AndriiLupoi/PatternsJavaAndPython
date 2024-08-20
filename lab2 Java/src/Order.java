public class Order implements TickedBookingSystemPrototype {
    private Client client;
    private Movie movie;
    private Seat seat;

    public Order(Client client, Movie movie, Seat seat) {
        this.client = client;
        this.movie = movie;
        this.seat = seat;
    }

    @Override
    public Order clone() {
        return new Order(client.clone(), movie.clone(), seat.clone());
    }

    @Override
    public String toString() {
        return "Order{" + "client=" + client + ", movie=" + movie + ", seat=" + seat + '}';
    }
}
