package Classes.Action;

import Classes.Decks;
import Classes.Game;
import Classes.Player;

public abstract class Action {
    private String command;

    public Action(String command) {
        this.command = command;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {}

    @Override
    public String toString() {
        return "command='" + command + '\'';
    }
}
