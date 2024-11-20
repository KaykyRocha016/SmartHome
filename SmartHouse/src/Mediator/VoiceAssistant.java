package Mediator;

import Mediator.Devices.Device;

public class VoiceAssistant extends Device {

    public VoiceAssistant(String name) {
        super(name);
    }

    public void processCommand(String command) {
        System.out.println("Voice Assistant processing command: " + command);
        sendMessage(command);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Voice Assistant received message: " + message);
    }
}
