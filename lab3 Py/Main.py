from datetime import datetime, timedelta

class Client:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __str__(self):
        return f"Client{{name='{self.name}', number='{self.number}'}}"

class Movie:
    def __init__(self, title, genre, show_time):
        self.title = title
        self.genre = genre
        self.show_time = show_time

    def __str__(self):
        return f"Movie{{title='{self.title}', genre='{self.genre}', showTime={self.show_time}}}"

class Seat:
    def __init__(self, seat_number, is_booked):
        self.seat_number = seat_number
        self.is_booked = is_booked

    def __str__(self):
        return f"Seat{{seatNumber={self.seat_number}, isBooked={self.is_booked}}}"

class Order:
    def __init__(self, client, movie, seat):
        self.client = client
        self.movie = movie
        self.seat = seat

    def __str__(self):
        return f"Order{{client={self.client}, movie={self.movie}, seat={self.seat}}}"

class ClientFactory:
    def create_client(self, name, number):
        return Client(name, number)

class MovieFactory:
    def create_movie(self, title, genre, show_time):
        return Movie(title, genre, show_time)

class SeatFactory:
    def create_seat(self, seat_number, is_booked):
        return Seat(seat_number, is_booked)

class OrderFactory:
    def create_order(self, client, movie, seat):
        return Order(client, movie, seat)

if __name__ == "__main__":
    client_factory = ClientFactory()
    movie_factory = MovieFactory()
    seat_factory = SeatFactory()
    order_factory = OrderFactory()

    client1 = client_factory.create_client("Volodya", "228")
    movie1 = movie_factory.create_movie("Titanic", "Drama", datetime.now() + timedelta(hours=4))
    seat1 = seat_factory.create_seat(10, False)

    original_order = order_factory.create_order(client1, movie1, seat1)

    print("Original Order: ", original_order)
