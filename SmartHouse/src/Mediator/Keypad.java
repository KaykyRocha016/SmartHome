package Mediator;

import Mediator.Devices.Device;

public class Keypad extends Device {

    public Keypad(String name) {
        super(name);
    }

    public void pressButton(String command) {
        System.out.println(getName() + " pressed: " + command);
        sendMessage(command);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(getName() + " received a message: " + message);
    }
}

