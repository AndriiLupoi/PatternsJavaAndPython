// Головна програма
public class Main {
    public static void main(String[] args) {
        // Створюємо колекцію місць
        SeatCollection seatCollection = new SeatCollection();

        // Додаємо кілька місць
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);
        Seat seat3 = new Seat(3);
        Seat seat4 = new Seat(4);

        seat2.setBooked(true); // Заброньовуємо місце №2

        seatCollection.addSeat(seat1);
        seatCollection.addSeat(seat2);
        seatCollection.addSeat(seat3);
        seatCollection.addSeat(seat4);

        // Створюємо ітератор для колекції місць
        Iterator<Seat> seatIterator = seatCollection.createIterator();

        // Обходимо всі місця за допомогою ітератора
        while (seatIterator.hasNext()) {
            Seat seat = seatIterator.next();
            System.out.println(seat);
        }
    }
}
