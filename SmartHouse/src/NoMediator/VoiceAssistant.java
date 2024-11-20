package NoMediator;

import NoMediator.Devices.*;

import java.util.List;

public class VoiceAssistant {
    private String name;
    private Ambience ambiance;

    public VoiceAssistant(String name, Ambience ambiance) {
        this.name = name;
        this.ambiance = ambiance;
    }

    public void processCommand(String command) {
        if (command == null || command.isEmpty()) {
            System.out.println("No command provided.");
            return;
        }

        command = command.toLowerCase();

        if (command.contains("turn on")) {
            handleTurnOn(command);
        } else if (command.contains("turn off")) {
            handleTurnOff(command);
        } else if (command.contains("set brightness")) {
            handleSetBrightness(command);
        } else if (command.contains("open")) {
            handleOpenCurtain(command);
        } else if (command.contains("close")) {
            handleCloseCurtain(command);
        } else if (command.contains("set temperature")) {
            handleSetTemperature(command);
        } else {
            System.out.println("Sorry, I did not understand that command.");
        }
    }

    private void handleTurnOn(String command) {
        for (Device device : ambiance.getDevices()) {
            if (command.contains(device.getName().toLowerCase())) {
                device.activate(true);
                return;
            }
        }
        System.out.println("Device not found for the 'turn on' command.");
    }

    private void handleTurnOff(String command) {
        for (Device device : ambiance.getDevices()) {
            if (command.contains(device.getName().toLowerCase())) {
                device.activate(false);
                return;
            }
        }
        System.out.println("Device not found for the 'turn off' command.");
    }

    private void handleSetBrightness(String command) {
        for (Device device : ambiance.getDevices()) {
            if (device instanceof Lamp && command.contains(device.getName().toLowerCase())) {
                int brightness = extractValueFromCommand(command);
                if (brightness != -1) {
                    ((Lamp) device).setBrightness(brightness);
                } else {
                    System.out.println("Please specify a valid brightness value (0-100).");
                }
                return;
            }
        }
        System.out.println("Lamp not found for the 'set brightness' command.");
    }

    private void handleOpenCurtain(String command) {
        for (Device device : ambiance.getDevices()) {
            if (device instanceof Curtain && command.contains(device.getName().toLowerCase())) {
                ((Curtain) device).open();
                return;
            }
        }
        System.out.println("Curtain not found for the 'open' command.");
    }

    private void handleCloseCurtain(String command) {
        for (Device device : ambiance.getDevices()) {
            if (device instanceof Curtain && command.contains(device.getName().toLowerCase())) {
                ((Curtain) device).close();
                return;
            }
        }
        System.out.println("Curtain not found for the 'close' command.");
    }

    private void handleSetTemperature(String command) {
        for (Device device : ambiance.getDevices()) {
            if (device instanceof AirConditioner && command.contains(device.getName().toLowerCase())) {
                int temperature = extractValueFromCommand(command);
                if (temperature != -1) {
                    ((AirConditioner) device).setTemperature(temperature);
                } else {
                    System.out.println("Please specify a valid temperature value.");
                }
                return;
            }
        }
        System.out.println("AC not found for the 'set temperature' command.");
    }

    private int extractValueFromCommand(String command) {
        try {
            String[] words = command.split(" ");
            for (String word : words) {
                try {
                    return Integer.parseInt(word);
                } catch (NumberFormatException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
