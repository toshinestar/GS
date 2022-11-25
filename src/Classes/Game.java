package Classes;

import Classes.Action.*;
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
import fileio.ActionsInput;

import java.util.ArrayList;

public class Game {
    private StartGame startGame = new StartGame();
    private ArrayList<Action> actions = new ArrayList<>();

    private int currentPlayerIdx = startGame.getStartingPlayer();

    private Player playerOne;
    private Player playerTwo;

    private Decks playingPlayerOne;
    private Decks playingPlayerTwo;

    private Minion[][] table = new Minion[4][5];
    private int addedMana = 2;

    public Decks getPlayingPlayerOne() {
        return playingPlayerOne;
    }

    public void setPlayingPlayerOne(Decks playingPlayerOne) {
        this.playingPlayerOne = playingPlayerOne;
    }

    public Decks getPlayingPlayerTwo() {
        return playingPlayerTwo;
    }

    public void setPlayingPlayerTwo(Decks playingPlayerTwo) {
        this.playingPlayerTwo = playingPlayerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void initActionList(ArrayList<ActionsInput> actionList) {
        for (ActionsInput actionsInput : actionList)
            switch (actionsInput.getCommand()) {
                case "getPlayerDeck" ->
                        actions.add(new GetPlayerDeck(actionsInput.getCommand(), actionsInput.getPlayerIdx()));
                case "getPlayerHero" ->
                        actions.add(new GetPlayerHero(actionsInput.getCommand(), actionsInput.getPlayerIdx()));
                case "getPlayerTurn" -> actions.add(new GetPlayerTurn(actionsInput.getCommand()));
                case "endPlayerTurn" -> actions.add(new EndPlayerTurn(actionsInput.getCommand()));
                case "placeCard" -> actions.add(new PlaceCard(actionsInput.getCommand(), actionsInput.getHandIdx()));
                case "getCardsInHand" ->
                        actions.add(new GetCardsInHand(actionsInput.getCommand(), actionsInput.getPlayerIdx()));
                case "getPlayerMana" ->
                        actions.add(new GetPlayerMana(actionsInput.getCommand(), actionsInput.getPlayerIdx()));
                case "getCardsOnTable" -> actions.add(new GetCardsOnTable(actionsInput.getCommand()));
                case "getEnvironmentCardsInHand" ->
                        actions.add(new GetEnvironmentCardsInHand(actionsInput.getCommand()));
                case "useEnvironmentCard" ->
                        actions.add(new UseEnvironmentCard(actionsInput.getCommand(), actionsInput.getHandIdx(), actionsInput.getAffectedRow()));
                case "getCardAtPosition" ->
                        actions.add(new GetCardAtPosition(actionsInput.getCommand(), actionsInput.getX(), actionsInput.getY()));
                case "cardUsesAttack" ->
                        actions.add(new CardUsesAttack(actionsInput.getCommand(), actionsInput.getCardAttacker(), actionsInput.getCardAttacked()));
                case "cardUsesAbility" ->
                        actions.add(new CardUsesAbility(actionsInput.getCommand(), actionsInput.getCardAttacker(), actionsInput.getCardAttacked()));
                case "useAttackHero" ->
                        actions.add(new UseAttackHero(actionsInput.getCommand(), actionsInput.getCardAttacker()));
                case "useHeroAbility" ->
                        actions.add(new UseHeroAbility(actionsInput.getCommand(), actionsInput.getAffectedRow()));
                case "getFrozenCardsOnTable" -> actions.add(new GetFrozenCardsOnTable(actionsInput.getCommand()));
                case "getPlayerOneWins" -> actions.add(new GetPlayerOneWins(actionsInput.getCommand()));
                case "getPlayerTwoWins" -> actions.add(new GetPlayerTwoWins(actionsInput.getCommand()));
                case "getTotalGamesPlayed" -> actions.add(new GetTotalGamesPlayed(actionsInput.getCommand()));
            }
    }

    public int findSpot(Card[] row) {
        int spot = -1;
        for(int i = 0; i < row.length; i++)
            if(row[i] == null) {
                spot = i;
                break;
            }
        return spot;
    }

    public void setCardInTable(Minion card, int x, int y) {
        if(card instanceof Berserker)
            table[x][y] = new Berserker(card.getMana(), card.getHealth(), card.getAttackDamage(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof Goliath)
            table[x][y] = new Goliath(card.getMana(), card.getHealth(), card.getAttackDamage(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof Sentinel)
            table[x][y] = new Sentinel(card.getMana(), card.getHealth(), card.getAttackDamage(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof Warden)
            table[x][y] = new Warden(card.getMana(), card.getHealth(), card.getAttackDamage(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof Disciple)
            table[x][y] = new Disciple(card.getMana(), card.getHealth(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof Miraj)
            table[x][y] = new Miraj(card.getMana(), card.getHealth(), card.getAttackDamage(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof TheCursedOne)
            table[x][y] = new TheCursedOne(card.getMana(), card.getHealth(), card.getDescription(), card.getColors(), card.getName());
        if(card instanceof TheRipper)
            table[x][y] = new TheRipper(card.getMana(), card.getHealth(), card.getAttackDamage(), card.getDescription(), card.getColors(), card.getName());

        table[x][y] = card;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public void setCurrentPlayerIdx(int currentPlayerIdx) {
        this.currentPlayerIdx = currentPlayerIdx;
    }


    public StartGame getStartGame() {
        return startGame;
    }

    public void setStartGame(StartGame startGame) {
        this.startGame = startGame;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public Card[][] getTable() {
        return table;
    }

    public void setTable(Minion[][] table) {
        this.table = table;
    }

    public int getAddedMana() {
        return addedMana;
    }

    public void setAddedMana(int addedMana) {
        this.addedMana = addedMana;
    }
}
