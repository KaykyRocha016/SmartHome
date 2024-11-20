package NoMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Localization {
    private String name;
    private final List<Ambience> ambiences = new ArrayList<>();

    public Localization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public boolean addAmbience(Ambience ambience) {
        if (!ambiences.contains(ambience)) {
            ambiences.add(ambience);
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localization that = (Localization) o;
        return Objects.equals(name, that.name) && Objects.equals(ambiences, that.ambiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ambiences);
    }

    @Override
    public String toString() {
        return "Localization: [" + "Local Name: '" + name + "' | Ambiences: " + ambiences + "]";
    }
}
