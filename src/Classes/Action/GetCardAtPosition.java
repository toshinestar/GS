package Classes.Action;

public class GetCardAtPosition extends Action{
    private int x;
    private int y;

    public GetCardAtPosition(String command, int x, int y) {
        super(command);
        this.x = x;
        this.y = y;
    }
}
