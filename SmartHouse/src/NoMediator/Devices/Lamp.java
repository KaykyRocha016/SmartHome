package NoMediator.Devices;

public class Lamp extends Device {
    private int brightness;

    public Lamp(String name) {
        super(name);
        this.brightness = 100;
    }

    public void setBrightness(int level) {
        if (level < 0) {
            level = 0;
        } else if (level > 100) {
            level = 100;
        }

        this.brightness = level;
        System.out.println(getName() + " brightness set to " + brightness + "%");
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public void toggle() {
        super.toggle();
        if (!isOn()) {
            System.out.println(getName() + " is OFF, brightness reset to 100%");
            brightness = 100;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Brightness: " + brightness + "%";
    }
}

