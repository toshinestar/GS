package Classes.Cards.Environment;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({"mana", "description", "colors", "name"})

public class Firestorm extends Environment{
    public Firestorm(String name, int mana, String description, ArrayList<String> colors) {
        super(name, mana, description, colors);
    }

    @Override
    public void action() {
        //TODO
    }
}
