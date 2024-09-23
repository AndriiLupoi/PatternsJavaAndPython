public class Main {
    public static void main(String[] args) {
        // Створюємо стандартне бронювання місця
        SeatBooking standardBooking = new StandardSeatBooking();

        System.out.println("=== Бронювання без додаткових послуг ===");
        standardBooking.book();
        System.out.println("Загальна ціна: " + standardBooking.getPrice() + " UAH");

        // Додаємо попкорн до бронювання
        SeatBooking popcornBooking = new PopcornDecorator(new StandardSeatBooking());

        System.out.println("\n=== Бронювання з попкорном ===");
        popcornBooking.book();
        System.out.println("Загальна ціна: " + popcornBooking.getPrice() + " UAH");

        // Додаємо попкорн та напій до бронювання
        SeatBooking fullBooking = new DrinkDecorator(new PopcornDecorator(new StandardSeatBooking()));

        System.out.println("\n=== Бронювання з попкорном і напоєм ===");
        fullBooking.book();
        System.out.println("Загальна ціна: " + fullBooking.getPrice() + " UAH");
    }
}