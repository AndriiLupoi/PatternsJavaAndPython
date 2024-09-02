from abc import ABC, abstractmethod

class BookingFactory(ABC):
    @abstractmethod
    def create_client(self, name, number):
        pass

    @abstractmethod
    def create_movie(self, title, genre, show_time):
        pass

    @abstractmethod
    def create_seat(self, seat_number, is_booked):
        pass

    @abstractmethod
    def create_order(self, client, movie, seat):
        pass


class ConcreteBookingFactory(BookingFactory):
    def create_client(self, name, number):
        return Client(name, number)

    def create_movie(self, title, genre, show_time):
        return Movie(title, genre, show_time)

    def create_seat(self, seat_number, is_booked):
        return Seat(seat_number, is_booked)

    def create_order(self, client, movie, seat):
        return Order(client, movie, seat)

class Client:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Client(name='{self.name}', number='{self.number}')"

class Movie:
    def __init__(self, title, genre, show_time):
        self.title = title
        self.genre = genre
        self.show_time = show_time

    def __str__(self):
        return f"Movie(title='{self.title}', genre='{self.genre}', show_time='{self.show_time}')"

class Seat:
    def __init__(self, seat_number, is_booked):
        self.seat_number = seat_number
        self.is_booked = is_booked

    def __str__(self):
        return f"Seat(seat_number={self.seat_number}, is_booked={self.is_booked})"

class Order:
    def __init__(self, client, movie, seat):
        self.client = client
        self.movie = movie
        self.seat = seat

    def __str__(self):
        return f"Order(client={self.client}, movie={self.movie}, seat={self.seat})"

if __name__ == "__main__":
    factory = ConcreteBookingFactory()

    client = factory.create_client("Volodya", "228")
    movie = factory.create_movie("Titanic", "Drama", "2024-08-19 18:00")
    seat = factory.create_seat(10, False)
    order = factory.create_order(client, movie, seat)

    print(order)
