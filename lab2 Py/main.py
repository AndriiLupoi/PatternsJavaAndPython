from copy import deepcopy
from datetime import datetime, timedelta

class TicketBookingSystemPrototype:
    def clone(self):
        return deepcopy(self)

class Client(TicketBookingSystemPrototype):
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Client{{name='{self.name}', number='{self.number}'}}"

class Movie(TicketBookingSystemPrototype):
    def __init__(self, title, genre, show_time):
        self.title = title
        self.genre = genre
        self.show_time = show_time

    def __str__(self):
        return f"Movie{{title='{self.title}', genre='{self.genre}', showTime={self.show_time}}}"

class Seat(TicketBookingSystemPrototype):
    def __init__(self, seat_number, is_booked):
        self.seat_number = seat_number
        self.is_booked = is_booked

    def __str__(self):
        return f"Seat{{seatNumber={self.seat_number}, isBooked={self.is_booked}}}"

class Order(TicketBookingSystemPrototype):
    def __init__(self, client, movie, seat):
        self.client = client
        self.movie = movie
        self.seat = seat

    def __str__(self):
        return f"Order{{client={self.client}, movie={self.movie}, seat={self.seat}}}"

if __name__ == "__main__":
    client1 = Client("Volodya", "228")
    movie1 = Movie("Titanic", "Drama", datetime.now() + timedelta(hours=4))
    seat1 = Seat(10, False)

    original_order = Order(client1, movie1, seat1)

    cloned_order = original_order.clone()

    print(f"Original Order: {original_order}\n")
    print(f"Cloned Order: {cloned_order}")
