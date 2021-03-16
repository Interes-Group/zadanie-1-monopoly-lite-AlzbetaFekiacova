package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.Player;

public class MoveThreeSpacesBackCard extends Card{
    private int value;
    public MoveThreeSpacesBackCard(String name){

        super(name);
        value = 3;
    }

    public void action(Player player) {
        super.action(player);
        int position = player.getPosition();
        position = (position - value ) % 24;
        if (position < 0){
            position = 0;
        }
        player.setPosition(position);
        System.out.println("Your new position is " + player.getPosition());
    }
}
