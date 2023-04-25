package view;


public abstract class AbstractComponent<T> implements Component {

    protected ComponentType type;
    protected final view.AbstractComponent<T> service;

    protected AbstractComponent(ComponentType type, view.AbstractComponent<T> service) {
        this.type = type;
        this.service = service;
    }

    public ComponentType getType() {
        return type;
    }

}