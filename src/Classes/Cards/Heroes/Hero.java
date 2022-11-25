package Classes.Cards.Heroes;

import Classes.Cards.Card;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Hero extends Card {
    private int mana;
    private String description;
    private ArrayList<String> colors;

    private String name;
    private int health = 30;

    public Hero(int mana, String description, ArrayList<String> colors, String name) {
        super(name);
        this.mana = mana;
        this.description = description;
        this.colors = colors;
        this.name = name;
    }

//    public Boolean isAlive() {
//        return health > 0;
//    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    @Override
    public String toString() {
        return "mana=" + mana +
                ", description='" + description + '\'' +
                ", colors=" + colors +
                ", name='" + getName() + '\'' +
                ", health=" + health;
    }
}
