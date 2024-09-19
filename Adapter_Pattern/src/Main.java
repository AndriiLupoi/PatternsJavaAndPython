public class Main {
    public static void main(String[] args) {
        // Створюємо зовнішнє місце
        ExternalSeat externalSeat = new ExternalSeat("100");

        // Адаптуємо це місце під інтерфейс Seat
        Seat seat = new SeatAdapter(externalSeat);

        // Використовуємо методи інтерфейсу Seat через адаптер
        seat.setBooked(true);  // Забронюємо місце
        System.out.println(seat);  // Друк статусу

        seat.setBooked(false);  // Звільняємо місце
        System.out.println(seat);  // Друк статусу
    }
}
