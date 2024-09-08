class Order:
    def __init__(self, builder):
        self.client = builder.client
        self.movie = builder.movie
        self.seat = builder.seat

    def __str__(self):
        return f"Order(client={self.client}, movie={self.movie}, seat={self.seat})"

    # Клас Builder для побудови об'єктів Order
    class Builder:
        def __init__(self):
            self.client = None
            self.movie = None
            self.seat = None

        def set_client(self, client):
            self.client = client
            return self

        def set_movie(self, movie):
            self.movie = movie
            return self

        def set_seat(self, seat):
            self.seat = seat
            return self

        def build(self):
            return Order(self)
class Seat:
    def __init__(self, seat_number, is_booked):
        self.seat_number = seat_number
        self.is_booked = is_booked

    def __str__(self):
        return f"Seat(seat_number={self.seat_number}, is_booked={self.is_booked})"
class Client:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Client(name={self.name}, number={self.number})"

class Movie:
    def __init__(self, title, genre, appointment_time):
        self.title = title
        self.genre = genre
        self.appointment_time = appointment_time

    def __str__(self):
        return f"Movie(title={self.title}, genre={self.genre}, showTime={self.appointment_time})"
from datetime import datetime, timedelta

if __name__ == "__main__":
    # Створюємо замовлення за допомогою патерну Будівельник
    order1 = Order.Builder() \
        .set_client(Client("Volodya", "228")) \
        .set_movie(Movie("Titanic", "Drama", datetime.now() + timedelta(hours=4))) \
        .set_seat(Seat(10, False)) \
        .build()

    order2 = Order.Builder() \
        .set_client(Client("Petya", "822")) \
        .set_movie(Movie("Titanic", "Drama", datetime.now() + timedelta(hours=6))) \
        .set_seat(Seat(9, True)) \
        .build()

    print(order1)
    print(order2)
