package Mediator;

import java.util.ArrayList;
import java.util.List;

public class Localization {
    private String name;
    private final List<Ambience> ambiences = new ArrayList<>();

    public Localization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addAmbience(Ambience ambience) {
        if (!ambiences.contains(ambience)) {
            ambiences.add(ambience);
            return true;
        }
        return false;
    }

    public List<Ambience> getAmbiences() {
        return new ArrayList<>(ambiences);
    }

    @Override
    public String toString() {
        return "Localization: [" + "Name: '" + name + "' | Ambiences: " + ambiences + "]";
    }
}

