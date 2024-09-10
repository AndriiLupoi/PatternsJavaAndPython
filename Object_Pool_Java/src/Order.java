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
        return "Order Details: \n" +
                "Client: " + client + "\n" +
                "Movie: " + movie + "\n" +
                "Seat: " + seat + "\n" +
                "-------------------------------";
    }
}
