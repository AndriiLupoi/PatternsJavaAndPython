// Базовий клас для компонентів, які будуть взаємодіяти через медіатор.
public abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendEvent(String event) {
        mediator.notify(this, event);
    }
}
