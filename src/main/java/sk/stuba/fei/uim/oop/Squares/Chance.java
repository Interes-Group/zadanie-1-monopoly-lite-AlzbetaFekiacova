package sk.stuba.fei.uim.oop.Squares;

import sk.stuba.fei.uim.oop.Cards.Card;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Chance extends Square {

    private ArrayList<Card> cards;
    //private ArrayList<Card> usedCards;

    public Chance(String name, int position, ArrayList<Card> cards) {
        super(name, position);
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
        //usedCards = new ArrayList<>();
    }


    @Override
    public void action(Player player) {
        super.action(player);
        playCard(player);
    }

    public void setCardsToBeUnused(){
        for(Card card: cards){
            card.setHasBeenUsed(false);
        }
    }

    public void playCard(Player player) {
        Card card = null;
        for (Card value : cards) {
            if (!value.isHasBeenUsed()) {
                card = value;
                break;
            }
        }

        if(card != null){
            card.setHasBeenUsed(true);
            card.action(player);
        }
        else {
            setCardsToBeUnused();
            card = cards.get(0);
            card.setHasBeenUsed(true);
            card.action(player);

        }


    }

    @Override
    public String toString() {
        return "You received a " + getName();
    }
}
