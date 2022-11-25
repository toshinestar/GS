package Classes.Action;

public class UseHeroAbility extends Action{
    private int affectedRow;

    public UseHeroAbility(String command, int affectedRow) {
        super(command);
        this.affectedRow = affectedRow;
    }

    public int getAffectedRow() {
        return affectedRow;
    }

    public void setAffectedRow(int affectedRow) {
        this.affectedRow = affectedRow;
    }
}
