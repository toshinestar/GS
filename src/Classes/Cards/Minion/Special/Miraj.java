package Classes.Cards.Minion.Special;

import Classes.Cards.Minion.Minion;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({"mana", "attackDamage", "health", "description", "colors", "name"})

public class Miraj extends Minion {
    public Miraj(int mana, int health, int attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name);
        setFrozen(false);
    }

    @Override
    public void execSpecialAbility() {
        //TODO
    }

    @Override
    public String toString() {
        return "mana=" + getMana() +
                "attackDamage=" + getAttackDamage() +
                "health=" + getHealth() +
                "description" + getDescription() +
                "colors=" + getColors() +
                "name=" + getName();
    }
}
