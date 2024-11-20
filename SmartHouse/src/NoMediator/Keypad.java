package NoMediator;

import java.util.Objects;

public class Keypad {
    private String name;

    public Keypad(String name) {
        this.name = name;
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
        Keypad keypad = (Keypad) o;
        return Objects.equals(name, keypad.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Keypad: [ Name: '" + name + "' ]";
    }
}

