package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.other.Player;

public class MoveThreeSpacesForwardCard extends Card{
    private int value;

    public MoveThreeSpacesForwardCard(String name){
        super(name);
        value = 3;

    }

    public void action(Player player) {
        super.action(player);
        int position = player.getPosition();
        player.setPosition((position + value)%24);
        System.out.println("Your new position is " + player.getPosition());
    }
}
