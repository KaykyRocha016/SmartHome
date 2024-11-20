package NoMediator.Devices;

public class Curtain extends Device {
    private boolean isOpen;

    public Curtain(String name) {
        super(name);
        this.isOpen = false; // Default is closed
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
    public void toggle() {
        if (isOpen) {
            close();
        } else {
            open();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | State: " + (isOpen ? "OPEN" : "CLOSED");
    }
}

