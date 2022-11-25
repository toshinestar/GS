package Classes.Action;

import Classes.Cards.Minion.Minion;
import Classes.Decks;
import Classes.Game;
import Classes.Player;

public class EndPlayerTurn extends Action{

    public EndPlayerTurn(String command) {
        super(command);
    }

    @Override
    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {
        if(game.getCurrentPlayerIdx() == 1) {
            playerOne.addInHand(playingPlayer1.getCards().get(0));
            playingPlayer1.getCards().remove(0);
            for(int i = 0; i < 5; i++) {
                if(game.getTable()[2][i] != null)
                    ((Minion)game.getTable()[2][i]).setFrozen(false);
                if(game.getTable()[3][i] != null)
                    ((Minion)game.getTable()[3][i]).setFrozen(false);
            }
            game.setAddedMana(game.getAddedMana() + 1);
            game.setCurrentPlayerIdx(2);
            playerOne.setMana(playerOne.getMana() + game.getAddedMana() / 2 + 1);
        }
        else if(game.getCurrentPlayerIdx() == 2) {
            playerTwo.addInHand(playingPlayer2.getCards().get(0));
            playingPlayer2.getCards().remove(0);

            for(int i = 0; i < 5; i++) {
                if(game.getTable()[0][i] != null)
                    ((Minion)game.getTable()[0][i]).setFrozen(false);
                if(game.getTable()[1][i] != null)
                    ((Minion)game.getTable()[1][i]).setFrozen(false);
            }
            game.setAddedMana(game.getAddedMana() + 1);
            game.setCurrentPlayerIdx(1);
            playerTwo.setMana(playerTwo.getMana() + game.getAddedMana() / 2 + 1);
        }
    }
}
