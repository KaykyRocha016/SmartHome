package NoMediator.Devices;

public class AirConditioner extends Device {
    private int temperature;

    public AirConditioner(String name) {
        super(name);
        this.temperature = 24;
    }

    public void setTemperature(int temperature) {
        if (temperature < 16 || temperature > 30) {
            System.out.println("Invalid temperature for " + getName() + ". Must be between 16 and 30°C.");
            return;
        }

        this.temperature = temperature;

        System.out.println(getName() + " temperature set to " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void activate(boolean turnOn) {
        super.activate(turnOn);
        if (turnOn) {
            System.out.println(getName() + " is ON at " + temperature + "°C");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Temperature: " + temperature + "°C";
    }
}

