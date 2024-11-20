package Mediator.Devices;

public class Lamp extends Device {
    private boolean isOn;

    public Lamp(String name) {
        super(name);
        this.isOn = false;
    }

    public void toggle() {
        isOn = !isOn;
        System.out.println(getName() + " is now " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public void receiveMessage(String message) {
        if (message.contains("toggle lamp")) {
            toggle();
        } else if (message.contains("turn on lamp")) {
            isOn = true;
            System.out.println(getName() + " is now ON");
        } else if (message.contains("turn off lamp")) {
            isOn = false;
            System.out.println(getName() + " is now OFF");
        }
    }
}

