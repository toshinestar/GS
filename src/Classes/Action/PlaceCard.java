package Classes.Action;

import Classes.Cards.Card;
import Classes.Cards.Minion.Minion;
import Classes.Cards.Minion.Special.Disciple;
import Classes.Cards.Minion.Special.Miraj;
import Classes.Cards.Minion.Special.TheCursedOne;
import Classes.Cards.Minion.Special.TheRipper;
import Classes.Cards.Minion.Standard.Berserker;
import Classes.Cards.Minion.Standard.Goliath;
import Classes.Cards.Minion.Standard.Sentinel;
import Classes.Cards.Minion.Standard.Warden;
import Classes.Decks;
import Classes.Game;
import Classes.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PlaceCard extends Action{
    private int handIdx;
    @JsonProperty("error")
    private String error = null;

    public PlaceCard(String command, int handIdx) {
        super(command);
        this.handIdx = handIdx;
    }


        public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public void exec(Game game, Player playerOne, Player playerTwo, Decks playingPlayer1, Decks playingPlayer2) {
        if(game.getCurrentPlayerIdx() == 1) {
            if(playerOne.getHand().get(handIdx) instanceof Minion) {
                if(playerOne.getMana() >= ((Minion) playerOne.getHand().get(handIdx)).getMana()) {
                    if(playerOne.getHand().get(handIdx) instanceof Berserker) {
                        if(game.findSpot(game.getTable()[3]) >= 0) {
                            game.setCardInTable((Berserker) playerOne.getHand().get(handIdx), 3, game.findSpot(game.getTable()[3]));
                            playerOne.setMana(playerOne.getMana() - ((Berserker) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);
                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof Goliath) {
                        if(game.findSpot(game.getTable()[3]) >= 0) {
                            game.setCardInTable((Goliath) playerOne.getHand().get(handIdx), 3, game.findSpot(game.getTable()[3]));
                            playerOne.setMana(playerOne.getMana() - ((Goliath) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof Sentinel) {
                        if(game.findSpot(game.getTable()[3]) >= 0) {
                            game.setCardInTable((Sentinel) playerOne.getHand().get(handIdx), 3, game.findSpot(game.getTable()[3]));
                            playerOne.setMana(playerOne.getMana() - ((Sentinel) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);
                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof Warden) {
                        if(game.findSpot(game.getTable()[3]) >= 0) {
                            game.setCardInTable((Warden) playerOne.getHand().get(handIdx), 3, game.findSpot(game.getTable()[3]));
                            playerOne.setMana(playerOne.getMana() - ((Warden) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof Disciple) {
                        if(game.findSpot(game.getTable()[2]) >= 0) {
                            game.setCardInTable((Disciple) playerOne.getHand().get(handIdx), 2, game.findSpot(game.getTable()[0]));
                            playerOne.setMana(playerOne.getMana() - ((Disciple) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof Miraj) {
                        if(game.findSpot(game.getTable()[2]) >= 0) {
                            game.setCardInTable((Miraj) playerOne.getHand().get(handIdx), 2, game.findSpot(game.getTable()[0]));
                            playerOne.setMana(playerOne.getMana() - ((Miraj) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof TheCursedOne) {
                        if(game.findSpot(game.getTable()[2]) >= 0) {
                            game.setCardInTable((TheCursedOne) playerOne.getHand().get(handIdx), 2, game.findSpot(game.getTable()[0]));
                            playerOne.setMana(playerOne.getMana() - ((TheCursedOne) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerOne.getHand().get(handIdx) instanceof TheRipper) {
                        if(game.findSpot(game.getTable()[2]) >= 0) {
                            game.setCardInTable((TheRipper) playerOne.getHand().get(handIdx), 2, game.findSpot(game.getTable()[0]));
                            playerOne.setMana(playerOne.getMana() - ((TheRipper) playerOne.getHand().get(handIdx)).getMana());
                            playerOne.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                }
                else error = "Not enough mana to place card on table.";
            }
            else
                error = "Cannot place environment card on table.";
        }
        else if(game.getCurrentPlayerIdx() == 2) {
            if(playerTwo.getHand().get(handIdx) instanceof Minion) {
                if(playerTwo.getMana() >= ((Minion) playerTwo.getHand().get(handIdx)).getMana()) {
                    if(playerTwo.getHand().get(handIdx) instanceof Berserker) {
                        if(game.findSpot(game.getTable()[0]) >= 0) {
                            game.setCardInTable((Berserker) playerTwo.getHand().get(handIdx), 0, game.findSpot(game.getTable()[3]));
                            playerTwo.setMana(playerTwo.getMana() - ((Berserker) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);
                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof Goliath) {
                        if(game.findSpot(game.getTable()[0]) >= 0) {
                            game.setCardInTable((Goliath) playerTwo.getHand().get(handIdx), 0, game.findSpot(game.getTable()[3]));
                            playerTwo.setMana(playerTwo.getMana() - ((Goliath) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof Sentinel) {
                        if(game.findSpot(game.getTable()[0]) >= 0) {
                            game.setCardInTable((Sentinel) playerTwo.getHand().get(handIdx), 0, game.findSpot(game.getTable()[0]));
                            playerTwo.setMana(playerTwo.getMana() - ((Sentinel) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof Warden) {
                        if(game.findSpot(game.getTable()[0]) >= 0) {
                            game.setCardInTable((Warden) playerTwo.getHand().get(handIdx), 0, game.findSpot(game.getTable()[0]));
                            playerTwo.setMana(playerTwo.getMana() - ((Warden) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof Disciple) {
                        if(game.findSpot(game.getTable()[1]) >= 0) {
                            game.setCardInTable((Disciple) playerTwo.getHand().get(handIdx), 1, game.findSpot(game.getTable()[1]));
                            playerTwo.setMana(playerTwo.getMana() - ((Disciple) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof Miraj) {
                        if(game.findSpot(game.getTable()[1]) >= 0) {
                            game.setCardInTable((Miraj) playerTwo.getHand().get(handIdx), 1, game.findSpot(game.getTable()[1]));
                            playerTwo.setMana(playerTwo.getMana() - ((Miraj) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof TheCursedOne) {
                        if(game.findSpot(game.getTable()[1]) >= 0) {
                            game.setCardInTable((TheCursedOne) playerTwo.getHand().get(handIdx), 1, game.findSpot(game.getTable()[1]));
                            playerTwo.setMana(playerTwo.getMana() - ((TheCursedOne) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                    if(playerTwo.getHand().get(handIdx) instanceof TheRipper) {
                        if(game.findSpot(game.getTable()[1]) >= 0) {
                            game.setCardInTable((TheRipper) playerTwo.getHand().get(handIdx), 1, game.findSpot(game.getTable()[1]));
                            playerTwo.setMana(playerTwo.getMana() - ((TheRipper) playerTwo.getHand().get(handIdx)).getMana());
                            playerTwo.getHand().remove(handIdx);

                        }
                        else error = "Cannot place card on table since row is full.";
                        return;
                    }
                }
                else error = "Not enough mana to place card on table.";
            }
            else
                error = "Cannot place environment card on table.";
        }
    }


    @Override
    public String toString() {
        return "PlaceCard{" +
                "error='" + error + '\'' +
                '}';
    }
}
