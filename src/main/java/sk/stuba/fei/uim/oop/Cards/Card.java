package sk.stuba.fei.uim.oop.Cards;


import sk.stuba.fei.uim.oop.Player;

public class Card {
    private String name;


    public Card(String name){
        this.name = name;

    }

    public void action(Player player){
        System.out.println("You received a " + toString());
    }

    @Override
    public String toString() {
        return name + "card";
    }


}
