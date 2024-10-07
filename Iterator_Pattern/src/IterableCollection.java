// Інтерфейс колекції, яка підтримує ітератор
public interface IterableCollection<T> {
    Iterator<T> createIterator();  // Створює ітератор для колекції
}
