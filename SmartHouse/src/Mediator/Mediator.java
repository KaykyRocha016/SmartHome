package Mediator;

import Mediator.Devices.Component;

public interface Mediator {
    void registerComponent(Component component);
    void sendMessage(String message, Component sender);
}

