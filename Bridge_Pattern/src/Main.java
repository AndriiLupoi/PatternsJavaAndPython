public class Main {
    public static void main(String[] args) {
        // Використання стандартного місця
        SeatImplementor standardSeat = new StandardSeatImplementor();
        SeatBooking standardBooking = new StandardSeatBooking(standardSeat);

        standardBooking.bookSeat();  // Бронюємо стандартне місце
        standardBooking.releaseSeat();  // Вивільняємо стандартне місце

        // Використання зовнішнього місця
        ExternalSeat externalSeat = new ExternalSeat("100");
        SeatImplementor externalSeatImplementor = new ExternalSeatImplementor(externalSeat);
        SeatBooking externalBooking = new StandardSeatBooking(externalSeatImplementor);

        externalBooking.bookSeat();  // Бронюємо зовнішнє місце
        externalBooking.releaseSeat();  // Вивільняємо зовнішнє місце
    }
}
