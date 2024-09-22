// Головний клас для тестування патерну Composite
public class Main {
    public static void main(String[] args) {
        // Створюємо окремі місця
        SeatComponent seat1 = new SingleSeat(1);
        SeatComponent seat2 = new SingleSeat(2);
        SeatComponent seat3 = new SingleSeat(3);

        // Створюємо групу місць
        SeatGroup seatGroup = new SeatGroup();
        seatGroup.addSeat(seat1);  // Додаємо місце 1 до групи
        seatGroup.addSeat(seat2);  // Додаємо місце 2 до групи
        seatGroup.addSeat(seat3);  // Додаємо місце 3 до групи

        // Заброньовуємо всю групу місць
        seatGroup.reserve();
        System.out.println("Чи вся група заброньована? " + seatGroup.isReserved());  // Перевіряємо статус бронювання

        // Вивільняємо всю групу місць
        seatGroup.release();
        System.out.println("Чи вся група вивільнена? " + seatGroup.isReserved());  // Перевіряємо статус після вивільнення
    }
}