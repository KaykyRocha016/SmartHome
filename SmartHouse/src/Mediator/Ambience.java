package Mediator;

import Mediator.Devices.Component;
import java.util.ArrayList;
import java.util.List;

public class Ambience {
    private String name;
    private final List<Component> components = new ArrayList<>();
    private Mediator mediator;

    public Ambience(String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean addComponent(Component component) {
        if (!components.contains(component)) {
            components.add(component);
            if (mediator != null) {
                mediator.registerComponent(component);
            }
            return true;
        }
        return false;
    }

    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Ambience: [Name: " + name + " | Components: " + components + "]";
    }
}

