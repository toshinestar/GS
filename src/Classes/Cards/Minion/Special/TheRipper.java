package Classes.Cards.Minion.Special;

import Classes.Cards.Minion.Minion;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
@JsonPropertyOrder({"mana", "attackDamage", "health", "description", "colors", "name"})

public class TheRipper extends Minion {
    public TheRipper(int mana, int health, int attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name);
        setFrozen(false);
    }

    @Override
    public void execSpecialAbility() {
        //TODO
    }
}
