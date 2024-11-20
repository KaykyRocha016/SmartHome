package Mediator.Devices;

import Mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    void sendMessage(String message);
    void receiveMessage(String message);
    String getName();
}