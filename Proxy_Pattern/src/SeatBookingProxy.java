public class SeatBookingProxy implements SeatBookingService {
    private RealSeatBookingService realSeatBookingService;
    private boolean isAdmin; // Чи є користувач адміністратором

    public SeatBookingProxy(boolean isAdmin) {
        this.realSeatBookingService = new RealSeatBookingService(); // Створюємо реальний сервіс
        this.isAdmin = isAdmin; // Призначаємо роль користувача
    }

    @Override
    public void bookSeat(Client client, Movie movie, Seat seat) {
        if (isAdmin) {
            // Перевірка чи місце вже заброньоване
            if (!seat.isBooked()) {
                // Якщо місце не заброньоване, бронюємо
                realSeatBookingService.bookSeat(client, movie, seat);
            } else {
                System.out.println("Місце вже заброньоване.");
            }
        } else {
            // Якщо користувач не адмін, відмовляємо у доступі
            System.out.println("Доступ заборонено. Тільки адміністратори можуть бронювати місця.");
        }
    }
}
