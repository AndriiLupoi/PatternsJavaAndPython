# Клас Memento зберігає стан бронювання
class BookingMemento:
    def __init__(self, state: str):
        self._state = state

    def get_state(self) -> str:
        return self._state


# Клас Booking, який має можливість створювати та відновлювати свій стан через Memento
class Booking:
    def __init__(self):
        self._state = ""

    def set_state(self, state: str):
        print(f"Змінюємо стан бронювання: {state}")
        self._state = state

    def get_state(self) -> str:
        return self._state

    # Створення Memento для збереження поточного стану
    def save_state_to_memento(self) -> BookingMemento:
        print(f"Збереження стану: {self._state}")
        return BookingMemento(self._state)

    # Відновлення стану з Memento
    def get_state_from_memento(self, memento: BookingMemento):
        self._state = memento.get_state()
        print(f"Відновлення стану: {self._state}")


# Клас Caretaker зберігає об'єкти Memento
class Caretaker:
    def __init__(self):
        self._memento_list = []

    def add(self, memento: BookingMemento):
        self._memento_list.append(memento)

    def get(self, index: int) -> BookingMemento:
        return self._memento_list[index]

if __name__ == "__main__":
    booking = Booking()
    caretaker = Caretaker()

    # Створюємо та зберігаємо різні стани бронювання
    booking.set_state("Місце №1: Бронювання розпочате")
    caretaker.add(booking.save_state_to_memento())

    booking.set_state("Місце №1: Підтверджено")
    caretaker.add(booking.save_state_to_memento())

    booking.set_state("Місце №1: Оплачено")
    caretaker.add(booking.save_state_to_memento())

    # Відновлення станів бронювання
    print("\nВідновлення стану до попередньої дії:")
    booking.get_state_from_memento(caretaker.get(1))

    print("\nВідновлення стану до першої дії:")
    booking.get_state_from_memento(caretaker.get(0))
