package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.other.Player;

public class SkipOneRoundCard extends Card{
    public SkipOneRoundCard(String name){
        super(name);
    }
    @Override
    public void action(Player player) {
        super.action(player);
        System.out.println("You have to wait one round");
    }
}
