package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.Player;

public class MoveThreeSpacesForwardCard extends Card{
    public MoveThreeSpacesForwardCard(String name){
        super(name);

    }

    public void action(Player player) {
        super.action(player);
        int position = player.getPosition();
        player.setPosition((position + 3)%24);
        System.out.println("Your new position is " + player.getPosition());
    }
}
