class SeatComponent:
    def reserve(self):
        raise NotImplementedError("Цей метод повинен бути реалізований.")

    def release(self):
        raise NotImplementedError("Цей метод повинен бути реалізований.")

    def is_reserved(self):
        raise NotImplementedError("Цей метод повинен бути реалізований.")


# Лист (окреме місце)
class SingleSeat(SeatComponent):
    def __init__(self, seat_number):
        self.seat_number = seat_number  # Номер місця
        self.reserved = False  # Спочатку місце не заброньоване

    # Метод для бронювання місця
    def reserve(self):
        self.reserved = True
        print(f"Місце {self.seat_number} заброньовано.")

    # Метод для вивільнення місця
    def release(self):
        self.reserved = False
        print(f"Місце {self.seat_number} вивільнено.")

    # Метод для перевірки, чи заброньоване місце
    def is_reserved(self):
        return self.reserved


# Композит (група місць)
class SeatGroup(SeatComponent):
    def __init__(self):
        self.seats = []  # Список компонентів (окремих місць або інших груп)

    # Додає місце в групу
    def add_seat(self, seat):
        self.seats.append(seat)

    # Видаляє місце з групи
    def remove_seat(self, seat):
        self.seats.remove(seat)

    # Метод для бронювання всіх місць у групі
    def reserve(self):
        for seat in self.seats:
            seat.reserve()  # Бронюємо кожне місце окремо
        print("Група місць заброньована.")

    # Метод для вивільнення всіх місць у групі
    def release(self):
        for seat in self.seats:
            seat.release()  # Вивільняємо кожне місце окремо
        print("Група місць вивільнена.")

    # Метод для перевірки, чи заброньовані всі місця в групі
    def is_reserved(self):
        return all(seat.is_reserved() for seat in self.seats)  # Перевіряємо всі місця


# Головний клас для тестування патерну Composite
def main():
    # Створюємо окремі місця
    seat1 = SingleSeat(1)
    seat2 = SingleSeat(2)
    seat3 = SingleSeat(3)

    # Створюємо групу місць
    seat_group = SeatGroup()
    seat_group.add_seat(seat1)  # Додаємо місце 1 до групи
    seat_group.add_seat(seat2)  # Додаємо місце 2 до групи
    seat_group.add_seat(seat3)  # Додаємо місце 3 до групи

    # Заброньовуємо всю групу місць
    seat_group.reserve()
    print(f"Чи вся група заброньована? {seat_group.is_reserved()}")  # Перевіряємо статус бронювання

    # Вивільняємо всю групу місць
    seat_group.release()
    print(f"Чи вся група вивільнена? {seat_group.is_reserved()}")  # Перевіряємо статус після вивільнення


if __name__ == "__main__":
    main()
