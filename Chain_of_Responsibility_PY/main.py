# Абстрактний клас для обробників
class BookingHandler:
    def __init__(self):
        self.next_handler = None

    def set_next_handler(self, next_handler):
        self.next_handler = next_handler

    def handle_request(self, client, movie, seat):
        raise NotImplementedError("You should implement this method!")


# Конкретний обробник для перевірки наявності місця
class AvailabilityHandler(BookingHandler):
    def handle_request(self, client, movie, seat):
        if not seat.is_booked():
            print("Місце доступне для бронювання.")
            seat.set_booked(True)  # Бронюємо місце
        else:
            print("Місце вже заброньоване.")

        # Передаємо запит далі в ланцюжку, якщо є наступний обробник
        if self.next_handler:
            self.next_handler.handle_request(client, movie, seat)


# Конкретний обробник для перевірки ролі користувача
class RoleCheckHandler(BookingHandler):
    def handle_request(self, client, movie, seat):
        if client.is_admin_user():  # Зміна тут
            print("Адміністратор може бронювати будь-яке місце.")
        else:
            print("Перевірка звичайного користувача. Користувач не може змінити вже заброньоване місце.")

        if self.next_handler:
            self.next_handler.handle_request(client, movie, seat)


# Клас клієнта
class Client:
    def __init__(self, name, number, is_admin):
        self.name = name
        self.number = number
        self.is_admin = is_admin

    def is_admin_user(self):  # Зміна тут
        return self.is_admin

    def __str__(self):
        return f"Client(name='{self.name}', number='{self.number}', is_admin={self.is_admin})"


# Клас місця
class Seat:
    def __init__(self, seat_number):
        self.seat_number = seat_number
        self.booked = False

    def is_booked(self):
        return self.booked

    def set_booked(self, booked):
        self.booked = booked

    def __str__(self):
        return f"Seat(seat_number={self.seat_number}, booked={self.booked})"


# Клас фільму
class Movie:
    def __init__(self, title, genre):
        self.title = title
        self.genre = genre

    def __str__(self):
        return f"Movie(title='{self.title}', genre='{self.genre}')"


# Головний блок
if __name__ == "__main__":
    # Створюємо клієнтів та фільми
    client1 = Client("Volodya", "228", True)  # Адміністратор
    client2 = Client("Petya", "822", False)   # Звичайний користувач

    movie1 = Movie("Titanic", "Драма")
    movie2 = Movie("Avatar", "Наукова фантастика")

    # Створюємо місця
    seat1 = Seat(1)
    seat2 = Seat(2)

    # Створюємо обробники
    availability_handler = AvailabilityHandler()
    role_check_handler = RoleCheckHandler()

    # Формуємо ланцюжок обробників
    availability_handler.set_next_handler(role_check_handler)

    # Обробляємо бронювання
    print("Бронювання клієнтом 1:")
    availability_handler.handle_request(client1, movie1, seat1)

    print("\nБронювання клієнтом 2:")
    availability_handler.handle_request(client2, movie2, seat1)  # Спроба бронювати вже зайняте місце
