from datetime import datetime, timedelta

class Client:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Client(name='{self.name}', number='{self.number}')"


class Movie:
    def __init__(self, title, genre, appointment_time):
        self.title = title
        self.genre = genre
        self.appointment_time = appointment_time

    def __str__(self):
        return f"Movie(title='{self.title}', genre='{self.genre}', showTime={self.appointment_time})"


class Seat:
    def __init__(self, seat_number, is_booked=False):
        self.seat_number = seat_number
        self.is_booked = is_booked

    def __str__(self):
        return f"Seat(seatNumber={self.seat_number}, isBooked={self.is_booked})"


class Order:
    def __init__(self, client, movie, seat):
        self.client = client
        self.movie = movie
        self.seat = seat

    def __str__(self):
        return f"Order(client={self.client}, movie={self.movie}, seat={self.seat})"

    def __repr__(self):
        return self.__str__()


class TicketBookingSystem:
    _instance = None

    def __init__(self):
        self.orders = []

    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = cls()
        return cls._instance

    def add_order(self, client, movie, seat):
        if not seat.is_booked:
            self.orders.append(Order(client, movie, seat))
            seat.is_booked = True
        else:
            print(f"Seat {seat.seat_number} is already booked.")

    def __str__(self):
        return f"Orders({self.orders})"

    def __repr__(self):
        return self.__str__()


if __name__ == "__main__":
    manager = TicketBookingSystem.get_instance()

    client1 = Client("Volodya", "228")
    client2 = Client("Petya", "822")

    movie1 = Movie("Titanic", "Drama", datetime.now() + timedelta(hours=4))
    movie2 = Movie("Birds", "Drama", datetime.now() + timedelta(hours=4))

    seat1 = Seat(10, False)
    seat2 = Seat(5, True)

    manager.add_order(client1, movie1, seat1)
    manager.add_order(client2, movie2, seat2)

    print(manager)
