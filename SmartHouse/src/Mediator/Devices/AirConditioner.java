package Mediator.Devices;

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

    @Override
    public void receiveMessage(String message) {
        if (message.contains("set temperature")) {
            String[] words = message.split(" ");
            for (String word : words) {
                try {
                    int temp = Integer.parseInt(word);
                    setTemperature(temp);
                    return;
                } catch (NumberFormatException ignored) {
                }
            }
        }
    }
}
