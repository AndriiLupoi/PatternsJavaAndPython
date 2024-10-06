// Реалізація реального сервісу бронювання місць
public class RealSeatBookingService implements SeatBookingService {
    @Override
    public void bookSeat(Client client, Movie movie, Seat seat) {
        if (!seat.isBooked()) {
            seat.setBooked(true); // Бронюємо місце
            Order order = new Order(client, movie, seat); // Створюємо замовлення
            System.out.println(order);
        } else {
            System.out.println("Це місце вже заброньоване.");
        }
    }
}