package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.Player;

public class MoveThreeSpacesBackCard extends Card{
    public MoveThreeSpacesBackCard(String name){

        super(name);
    }

    public void action(Player player) {
        super.action(player);
        int position = player.getPosition();
        position = (position - 3 ) % 24;
        if (position < 0){
            position = 0;
        }
        player.setPosition(position);
        System.out.println("Your new position is " + player.getPosition());
    }
}
