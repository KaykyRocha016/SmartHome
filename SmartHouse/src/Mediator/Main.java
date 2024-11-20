package Mediator;

import Mediator.Devices.AirConditioner;
import Mediator.Devices.Curtain;
import Mediator.Devices.Lamp;

public class Main {
    public static void main(String[] args) {
        SmartHubApp mediator = new SmartHubApp();
        Localization house = new Localization("House N180");

        Ambience livingRoom = new Ambience("Living Room");
        livingRoom.setMediator(mediator);

        house.addAmbience(livingRoom);

        Lamp lamp = new Lamp("Living Room Lamp");

        Curtain curtain = new Curtain("Living Room Curtain");

        AirConditioner ac = new AirConditioner("Living Room AC");

        VoiceAssistant assistant = new VoiceAssistant("Alexa");
        Keypad keypad = new Keypad("Wall Keypad");

        livingRoom.addComponent(lamp);
        livingRoom.addComponent(curtain);
        livingRoom.addComponent(ac);
        livingRoom.addComponent(assistant);
        livingRoom.addComponent(keypad);

        assistant.processCommand("turn on lamp");
        keypad.pressButton("open curtain");
        assistant.processCommand("set temperature 22");
        keypad.pressButton("turn off lamp");
    }
}

