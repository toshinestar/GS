package Classes;

import Classes.Cards.Card;
import Classes.Cards.Environment.Firestorm;
import Classes.Cards.Environment.HeartHound;
import Classes.Cards.Environment.Winterfell;
import Classes.Cards.Minion.Special.Disciple;
import Classes.Cards.Minion.Special.Miraj;
import Classes.Cards.Minion.Special.TheCursedOne;
import Classes.Cards.Minion.Special.TheRipper;
import Classes.Cards.Minion.Standard.Berserker;
import Classes.Cards.Minion.Standard.Goliath;
import Classes.Cards.Minion.Standard.Sentinel;
import Classes.Cards.Minion.Standard.Warden;
import fileio.CardInput;

import java.util.ArrayList;

public class Decks {
    public int nrCardsInDeck;
    ArrayList<Card> cards = new ArrayList<>();

    public Decks(ArrayList<CardInput> deck) {
        nrCardsInDeck = deck.size();
        for(CardInput iter : deck)
            switch (iter.getName()) {
                case "Berserker" ->
                        cards.add(new Berserker(iter.getMana(), iter.getHealth(), iter.getAttackDamage(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "Goliath" ->
                        cards.add(new Goliath(iter.getMana(), iter.getHealth(), iter.getAttackDamage(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "Sentinel" ->
                        cards.add(new Sentinel(iter.getMana(), iter.getHealth(), iter.getAttackDamage(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "Warden" ->
                        cards.add(new Warden(iter.getMana(), iter.getHealth(), iter.getAttackDamage(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "Disciple" ->
                        cards.add(new Disciple(iter.getMana(), iter.getHealth(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "Miraj" ->
                        cards.add(new Miraj(iter.getMana(), iter.getHealth(), iter.getAttackDamage(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "The Cursed One" ->
                        cards.add(new TheCursedOne(iter.getMana(), iter.getHealth(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "The Ripper" ->
                        cards.add(new TheRipper(iter.getMana(), iter.getHealth(), iter.getAttackDamage(), iter.getDescription(), iter.getColors(), iter.getName()));
                case "Firestorm" ->
                        cards.add(new Firestorm(iter.getName(), iter.getMana(), iter.getDescription(), iter.getColors()));
                case "Heart Hound" ->
                        cards.add(new HeartHound(iter.getName(), iter.getMana(), iter.getDescription(), iter.getColors()));
                case "Winterfell" ->
                        cards.add(new Winterfell(iter.getName(), iter.getMana(), iter.getDescription(), iter.getColors()));
        }
    }

    public Decks(Decks deck) {
        nrCardsInDeck = deck.getNrCardsInDeck();
        for(Card card : deck.getCards())
            switch (card.getName()) {
                case "Berserker" ->
                        cards.add(new Berserker(((Berserker) card).getMana(), ((Berserker) card).getHealth(), ((Berserker) card).getAttackDamage(), ((Berserker) card).getDescription(), ((Berserker) card).getColors(), card.getName()));
                case "Goliath" ->
                        cards.add(new Goliath(((Goliath) card).getMana(), ((Goliath) card).getHealth(), ((Goliath) card).getAttackDamage(), ((Goliath) card).getDescription(), ((Goliath) card).getColors(), card.getName()));
                case "Sentinel" ->
                        cards.add(new Sentinel(((Sentinel) card).getMana(), ((Sentinel) card).getHealth(), ((Sentinel) card).getAttackDamage(), ((Sentinel) card).getDescription(), ((Sentinel) card).getColors(), card.getName()));
                case "Warden" ->
                        cards.add(new Warden(((Warden) card).getMana(), ((Warden) card).getHealth(), ((Warden) card).getAttackDamage(), ((Warden) card).getDescription(), ((Warden) card).getColors(), card.getName()));
                case "Disciple" ->
                        cards.add(new Disciple(((Disciple) card).getMana(), ((Disciple) card).getHealth(), ((Disciple) card).getDescription(), ((Disciple) card).getColors(), card.getName()));
                case "Miraj" ->
                        cards.add(new Miraj(((Miraj) card).getMana(), ((Miraj) card).getHealth(), ((Miraj) card).getAttackDamage(), ((Miraj) card).getDescription(), ((Miraj) card).getColors(), card.getName()));
                case "The Cursed One" ->
                        cards.add(new TheCursedOne(((TheCursedOne) card).getMana(), ((TheCursedOne) card).getHealth(), ((TheCursedOne) card).getDescription(), ((TheCursedOne) card).getColors(), card.getName()));
                case "The Ripper" ->
                        cards.add(new TheRipper(((TheRipper) card).getMana(), ((TheRipper) card).getHealth(), ((TheRipper) card).getAttackDamage(), ((TheRipper) card).getDescription(), ((TheRipper) card).getColors(), card.getName()));
                case "Firestorm" ->
                        cards.add(new Firestorm(card.getName(), ((Firestorm) card).getMana(), ((Firestorm) card).getDescription(), ((Firestorm) card).getColors()));
                case "Heart Hound" ->
                        cards.add(new HeartHound(card.getName(), ((HeartHound) card).getMana(), ((HeartHound) card).getDescription(), ((HeartHound) card).getColors()));
                case "Winterfell" ->
                        cards.add(new Winterfell(card.getName(), ((Winterfell) card).getMana(), ((Winterfell) card).getDescription(), ((Winterfell) card).getColors()));
            }
    }

    public int getNrCardsInDeck() {
        return nrCardsInDeck;
    }

    public void setNrCardsInDeck(int nrCardsInDeck) {
        this.nrCardsInDeck = nrCardsInDeck;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Decks{" +
//                "nrCardsInDeck=" + nrCardsInDeck +
                ", cards=" + cards +
                '}';
    }
}
