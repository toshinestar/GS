package Classes.Action;

import Classes.Decks;
import Classes.Game;
import Classes.Player;

public class GetPlayerTurn extends Action{

    private int output;
    public GetPlayerTurn(String command) {
        super(command);
    }

    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {
        output = game.getCurrentPlayerIdx();
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "command=" + getCommand() +
                ", output=" + output;
    }
}
