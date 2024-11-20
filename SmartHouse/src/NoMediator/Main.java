package NoMediator;

import NoMediator.Devices.*;

public class Main {
    public static void main(String[] args) {
        // Setup
        Localization house = new Localization("Smart Home");
        Ambience livingRoom = new Ambience("Living Room");
        house.addAmbience(livingRoom);

        // Devices and Modules
        Lamp lamp1 = new Lamp("Ceiling Lamp");
        Curtain curtain = new Curtain("Window Curtain");
        AirConditioner ac = new AirConditioner("AC Unit");

        // Adding to living room
        livingRoom.addDevice(lamp1);
        livingRoom.addDevice(curtain);
        livingRoom.addDevice(ac);

        // Create the voice assistant for the living room
        VoiceAssistant assistant = new VoiceAssistant("Alexa", livingRoom);
        livingRoom.setVoiceAssistant(assistant);

        // Simulate voice commands for the living room ambiance
        livingRoom.processVoiceCommand("Turn on Ceiling Lamp");
        livingRoom.processVoiceCommand("Set brightness of Ceiling Lamp to 80");
        livingRoom.processVoiceCommand("Open Window Curtain");
        livingRoom.processVoiceCommand("Set temperature AC Unit to 22");
        livingRoom.processVoiceCommand("Turn off Ceiling Lamp");

        System.out.println("\nFinal state:");
        System.out.println(house);
    }
}
