package Classes.Action;

public class GetPlayerMana extends Action{
    private int playerIdx;

    public GetPlayerMana(String command, int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }
}
