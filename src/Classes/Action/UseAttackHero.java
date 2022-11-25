package Classes.Action;

import Classes.Coordinates;

public class UseAttackHero extends Action{
    private Coordinates cardAttacker;
    public UseAttackHero(String command, fileio.Coordinates cardAttacker) {
        super(command);
        this.cardAttacker = new Coordinates(cardAttacker.getX(), cardAttacker.getY());
    }

    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public void setCardAttacker(Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }
}
