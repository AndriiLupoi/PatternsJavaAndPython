public class Order {
    private Client client;
    private Movie movie;
    private Seat seat;

    public Order(Client client, Movie movie, Seat seat) {
        this.client = client;
        this.movie = movie;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Order{" + "client=" + client + ", movie=" + movie + ", seat=" + seat + '}';
    }
}
