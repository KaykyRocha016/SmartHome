package Mediator.Devices;

public class Curtain extends Device {
    private boolean isOpen;

    public Curtain(String name) {
        super(name);
        this.isOpen = false;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println(getName() + " is now OPEN");
        } else {
            System.out.println(getName() + " is already OPEN");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println(getName() + " is now CLOSED");
        } else {
            System.out.println(getName() + " is already CLOSED");
        }
    }

    @Override
    public void receiveMessage(String message) {
        if (message.contains("open curtain")) {
            open();
        } else if (message.contains("close curtain")) {
            close();
        }
    }
}

