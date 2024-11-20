package NoMediator.Devices;

import NoMediator.Keypad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Device {
    private String name;
    private boolean isOn;
    private final List<Keypad> triggers = new ArrayList<>();

    public Device(String name) {
        this.name = name;
        this.isOn = false;
    }

    public boolean addTrigger(Keypad keypad) {
        if (!triggers.contains(keypad)) {
            triggers.add(keypad);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void activate(boolean turnOn) {
        this.isOn = turnOn;
        if (turnOn) {
            System.out.println(name + " is now ON");
        } else {
            System.out.println(name + " is now OFF");
        }
    }

    public void toggle() {
        this.isOn = !this.isOn;
        System.out.println(name + " is now " + (isOn ? "ON" : "OFF"));
    }

    public void displayState() {
        System.out.println(name + " is currently " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(name, device.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Device [ Name: '" + name + "' | Status: " + (isOn ? "ON" : "OFF") + " | Triggers: " + triggers + " ]";
    }
}
