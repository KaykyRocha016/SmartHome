package Mediator.Devices;

import Mediator.Mediator;

public abstract class Device implements Component {
    private Mediator mediator;
    private String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        if (mediator != null) {
            mediator.sendMessage(message, this);
        }
    }

    @Override
    public abstract void receiveMessage(String message);

    public String getName() {
        return name;
    }
}

