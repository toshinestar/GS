package Classes.Action;

import Classes.Cards.Card;
import Classes.Cards.Heroes.Hero;
import Classes.Decks;
import Classes.Game;
import Classes.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPlayerHero extends Action{
    private int playerIdx;
    @JsonProperty("output")
    private Hero output;
    public GetPlayerHero(String command, int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
    }

    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {
        if(playerIdx == 1)
            output = playerOne.getHero();
        else if(playerIdx == 2)
            output = playerTwo.getHero();
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public String toString() {
        return "{command=" + getCommand() +
                ", playerIdx=" + playerIdx +
                ", output=" + output.toString() + "}";
    }
}
