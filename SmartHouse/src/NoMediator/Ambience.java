package NoMediator;

import NoMediator.Devices.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ambience {
    private String name;
    private final List<Device> devices = new ArrayList<>();
    private final List<Keypad> keypads = new ArrayList<>();
    private VoiceAssistant voiceAssistant;

    public Ambience(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public boolean addDevice(Device device){
        if (!devices.contains(device)){
            devices.add(device);
            return true;
        }

        return false;
    }

    public boolean removeDevice(Device device){
        if (devices.contains(device)){
            devices.remove(device);
            return true;
        }

        return false;
    }

    public List<Keypad> getKeypads() {
        return keypads;
    }

    public boolean addKeypad(Keypad keypad){
        if (!keypads.contains(keypad)){
            keypads.add(keypad);
            return true;
        }

        return false;
    }

    public boolean removeKeypad(Keypad keypad){
        if (keypads.contains(keypad)){
            keypads.remove(keypad);
            return true;
        }

        return false;
    }

    public void setVoiceAssistant(VoiceAssistant voiceAssistant) {
        this.voiceAssistant = voiceAssistant;
    }

    public void processVoiceCommand(String command) {
        if (voiceAssistant != null) {
            voiceAssistant.processCommand(command);
        } else {
            System.out.println("No voice assistant assigned to this ambiance.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ambience ambience = (Ambience) o;
        return Objects.equals(name, ambience.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Ambience [ Name: " + name + " | Devices: " + devices + " | Keypads: " + keypads + "]";
    }

}
