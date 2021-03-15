package sk.stuba.fei.uim.oop.Squares;

import sk.stuba.fei.uim.oop.Cards.Card;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Chance extends Square {

    private ArrayList<Card> unusedCards = new ArrayList<>();
    private ArrayList<Card> usedCards;

    public Chance(String name, int position, ArrayList <Card> cards) {
        super(name, position);
        this.unusedCards.addAll(cards);
        usedCards = new ArrayList<>();
    }



    @Override
    public void action(Player player) {
        super.action(player);
        playCard(player);
    }

    public void playCard(Player player){
        Card card = unusedCards.get(0);
        card.action(player);
        unusedCards.remove(card);
        usedCards.add(card);
        if(unusedCards.size() == 0){
            unusedCards.addAll(usedCards);
            usedCards.clear();
        }


    }

    @Override
    public String toString() {
        return "You received a " + getName();
    }
}
