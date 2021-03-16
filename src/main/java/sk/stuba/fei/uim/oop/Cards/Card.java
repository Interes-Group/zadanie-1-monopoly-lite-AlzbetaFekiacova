package sk.stuba.fei.uim.oop.Cards;


import sk.stuba.fei.uim.oop.Player;

public class Card {
    private String name;
    private boolean hasBeenUsed;

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public boolean isHasBeenUsed() {
        return hasBeenUsed;
    }

    public Card(String name){
        this.name = name;
        hasBeenUsed = false;

    }

    public void action(Player player){
        System.out.println("You received a " + toString());
    }

    @Override
    public String toString() {
        return name + "card";
    }


}
