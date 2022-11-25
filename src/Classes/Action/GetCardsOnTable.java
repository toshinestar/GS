package Classes.Action;

import Classes.Cards.Card;
import Classes.Decks;
import Classes.Game;
import Classes.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GetCardsOnTable extends Action{

    @JsonProperty("output")
    private ArrayList<Card> output = new ArrayList<>();
    public GetCardsOnTable(String command) {
        super(command);
    }


    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 5; j++)
                if(game.getTable()[i][j] != null)
                    output.add(game.getTable()[i][j]);
    }

    @Override
    public String toString() {
        return "command=" + getCommand() +
                "output=" + output;
    }
}
