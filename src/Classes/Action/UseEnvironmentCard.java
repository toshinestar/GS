package Classes.Action;

public class UseEnvironmentCard extends Action{
    private int handIdx;
    private int affectedRow;
    public UseEnvironmentCard(String command, int handIdx, int affectedRow) {
        super(command);
        this.handIdx = handIdx;
        this.affectedRow = affectedRow;
    }

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
    }

    public int getAffectedRow() {
        return affectedRow;
    }

    public void setAffectedRow(int affectedRow) {
        this.affectedRow = affectedRow;
    }
}
