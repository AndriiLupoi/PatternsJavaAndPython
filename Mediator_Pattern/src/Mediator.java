import java.awt.*;

// Інтерфейс, який визначає методи для координації взаємодії між учасниками.
public interface Mediator {
    void notify(Component sender, String event);
}

