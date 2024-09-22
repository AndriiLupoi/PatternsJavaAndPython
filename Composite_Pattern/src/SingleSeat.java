// Лист (окреме місце)
// Представляє окреме місце і реалізує всі методи для роботи з ним
class SingleSeat implements SeatComponent {
    private int seatNumber;  // Номер місця
    private boolean reserved;  // Статус бронювання

    // Конструктор для створення місця з певним номером
    public SingleSeat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;  // Спочатку місце не заброньоване
    }

    // Метод для бронювання місця
    @Override
    public void reserve() {
        reserved = true;
        System.out.println("Місце " + seatNumber + " заброньовано.");
    }

    // Метод для вивільнення місця
    @Override
    public void release() {
        reserved = false;
        System.out.println("Місце " + seatNumber + " вивільнено.");
    }

    // Метод для перевірки, чи заброньоване місце
    @Override
    public boolean isReserved() {
        return reserved;
    }
}