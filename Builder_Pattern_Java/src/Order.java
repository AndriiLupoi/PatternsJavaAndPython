public class Order {
    private Client client;
    private Movie movie;
    private Seat seat;

    // Приватний конструктор для використання тільки в Builder
    private Order(Builder builder) {
        this.client = builder.client;
        this.movie = builder.movie;
        this.seat = builder.seat;
    }

    @Override
    public String toString() {
        return "Order{" + "client=" + client + ", movie=" + movie + ", seat=" + seat + '}';
    }

    // Клас Builder для побудови об'єктів Order
    public static class Builder {
        private Client client;
        private Movie movie;
        private Seat seat;

        public Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public Builder setSeat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
