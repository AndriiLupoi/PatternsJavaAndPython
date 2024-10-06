from datetime import datetime, timedelta

class Client:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Клієнт: {self.name}, Номер: {self.number}"

class Movie:
    def __init__(self, title, genre, appointment_time):
        self.title = title
        self.genre = genre
        self.appointment_time = appointment_time

    def __str__(self):
        return f"Фільм: {self.title}, Жанр: {self.genre}, Час показу: {self.appointment_time}"

class Seat:
    def __init__(self, seat_number):
        self.seat_number = seat_number
        self.booked = False

    def is_booked(self):
        return self.booked

    def set_booked(self, booked):
        self.booked = booked

    def __str__(self):
        status = "Заброньоване" if self.booked else "Доступне"
        return f"Місце {self.seat_number}: {status}"

# Інтерфейс для бронювання місць
class SeatBookingService:
    def book_seat(self, client, movie, seat):
        raise NotImplementedError

# Реальна реалізація сервісу для бронювання
class RealSeatBookingService(SeatBookingService):
    def book_seat(self, client, movie, seat):
        seat.set_booked(True)
        print(f"{client} забронював місце {seat} на фільм {movie}")

# Проксі клас
class SeatBookingProxy(SeatBookingService):
    def __init__(self, is_admin):
        self.real_service = RealSeatBookingService()  # Реальний сервіс
        self.is_admin = is_admin  # Роль користувача

    def book_seat(self, client, movie, seat):
        if self.is_admin:
            # Перевіряємо, чи місце вже заброньоване
            if not seat.is_booked():
                self.real_service.book_seat(client, movie, seat)
            else:
                print("Місце вже заброньоване.")
        else:
            print("Доступ заборонено. Тільки адміністратори можуть бронювати місця.")

# Головна функція
if __name__ == "__main__":
    # Створюємо клієнтів і фільми
    client1 = Client("Volodya", "228")
    client2 = Client("Petya", "822")

    movie1 = Movie("Titanic", "Драма", datetime.now() + timedelta(hours=4))
    movie2 = Movie("Avatar", "Наукова фантастика", datetime.now() + timedelta(hours=6))

    # Створюємо місця
    seat1 = Seat(1)
    seat2 = Seat(2)

    # Використовуємо проксі для бронювання
    booking_proxy_admin = SeatBookingProxy(True)  # Адміністратор
    booking_proxy_user = SeatBookingProxy(False)  # Звичайний користувач

    # Адміністратор бронює місце
    booking_proxy_admin.book_seat(client1, movie1, seat1)

    # Звичайний користувач намагається бронювати місце
    booking_proxy_user.book_seat(client2, movie2, seat2)

    # Адміністратор намагається знову забронювати те саме місце
    booking_proxy_admin.book_seat(client1, movie1, seat1)
