class OrderFactory {
    public Order createOrder(Client client, Movie movie, Seat seat) {
        return new Order(client, movie, seat);
    }
}