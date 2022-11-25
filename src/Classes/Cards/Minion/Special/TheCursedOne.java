package Classes.Cards.Minion.Special;

import Classes.Cards.Minion.Minion;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({"mana", "attackDamage", "health", "description", "colors", "name"})

public class TheCursedOne extends Minion {
    public TheCursedOne(int mana, int health, String description, ArrayList<String> colors, String name) {
        super(mana, health, 0, description, colors, name);
        setFrozen(false);
    }

    @Override
    public void execSpecialAbility() {
        //TODO
    }
}
