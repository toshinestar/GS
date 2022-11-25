package Classes.Action;

import Classes.Cards.Card;
import Classes.Decks;
import Classes.Game;
import Classes.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GetCardsInHand extends Action{
    private int playerIdx;
    @JsonProperty("output")
    private ArrayList<Card> output = new ArrayList<>();
    public GetCardsInHand(String command, int playerIdx) {
        super(command);
        this.playerIdx = playerIdx;
    }

    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {
        if(playerIdx == 1)
            output.addAll(playerOne.getHand());
        else if(playerIdx == 2)
            output.addAll(playerTwo.getHand());
    }



    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public String toString() {
        return "command=" + getCommand() +
                "playerIdx=" + playerIdx +
                ", output=" + output;
    }
}
