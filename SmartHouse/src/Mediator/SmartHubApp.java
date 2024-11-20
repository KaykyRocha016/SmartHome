package Mediator;

import Mediator.Devices.Component;
import java.util.ArrayList;
import java.util.List;

public class SmartHubApp implements Mediator {
    private final List<Component> components = new ArrayList<>();

    @Override
    public void registerComponent(Component component) {
        if (!components.contains(component)) {
            components.add(component);
            component.setMediator(this);
            System.out.println(component.getName() + " registered with Mediator.");
        }
    }

    @Override
    public void sendMessage(String message, Component sender) {
        System.out.println(sender.getName() + " sends message: " + message);

        for (Component component : components) {
            if (component != sender) {
                component.receiveMessage(message);
            }
        }
    }
}


