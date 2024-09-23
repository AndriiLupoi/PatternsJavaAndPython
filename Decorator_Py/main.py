from abc import ABC, abstractmethod

# Базовий інтерфейс для бронювання місця
class SeatBooking:
    def book(self):
        raise NotImplementedError

    def get_price(self):
        raise NotImplementedError


# Конкретна реалізація бронювання місця
class StandardSeatBooking(SeatBooking):
    def book(self):
        print("Standard seat booked.")

    def get_price(self):
        return 100.0  # Стандартна ціна за місце


# Абстрактний клас декоратора, який буде розширювати функціонал бронювання
class SeatBookingDecorator(SeatBooking):
    @abstractmethod
    def __init__(self, seat_booking):
        self.decorated_seat_booking = seat_booking

    @abstractmethod
    def book(self):
        self.decorated_seat_booking.book()

    @abstractmethod
    def get_price(self):
        return self.decorated_seat_booking.get_price()


# Конкретний декоратор для додавання попкорну
class PopcornDecorator(SeatBookingDecorator):
    def book(self):
        super().book()
        self.add_popcorn()

    def get_price(self):
        return super().get_price() + 50.0  # Додаємо вартість попкорну

    def add_popcorn(self):
        print("Popcorn added to booking.")


# Конкретний декоратор для додавання напою
class DrinkDecorator(SeatBookingDecorator):
    def book(self):
        super().book()
        self.add_drink()

    def get_price(self):
        return super().get_price() + 30.0  # Додаємо вартість напою

    def add_drink(self):
        print("Drink added to booking.")


# Тестовий клас для демонстрації Decorator Pattern
def main():
    # Створюємо стандартне бронювання місця
    standard_booking = StandardSeatBooking()

    print("=== Бронювання без додаткових послуг ===")
    standard_booking.book()
    print(f"Загальна ціна: {standard_booking.get_price()} UAH")

    # Додаємо попкорн до бронювання
    popcorn_booking = PopcornDecorator(StandardSeatBooking())

    print("\n=== Бронювання з попкорном ===")
    popcorn_booking.book()
    print(f"Загальна ціна: {popcorn_booking.get_price()} UAH")

    # Додаємо попкорн та напій до бронювання
    full_booking = DrinkDecorator(PopcornDecorator(StandardSeatBooking()))

    print("\n=== Бронювання з попкорном і напоєм ===")
    full_booking.book()
    print(f"Загальна ціна: {full_booking.get_price()} UAH")


if __name__ == "__main__":
    main()
