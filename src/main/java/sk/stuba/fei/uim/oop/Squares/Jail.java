package sk.stuba.fei.uim.oop.Squares;


import sk.stuba.fei.uim.oop.other.Player;

import java.util.HashMap;
import java.util.Map;


public class Jail extends Square {
    private Map<Player, Integer> jail;

    public Jail(String name, int position) {
        super(name, position);
        jail = new HashMap<>();
    }

    public int roundsToStay(Player player) {
        return jail.get(player);
    }

    public void addPlayer(Player player) {
        jail.put(player, 3);
        player.setImprisoned(true);
    }

    public void setFreeOnePlayer(Player player) {
        jail.remove(player);
    }

    public void oneRoundPassed(Player player) {

        if (roundsToStay(player) > 0) {
            System.out.println("You have to stay " + roundsToStay(player) + " rounds");
            jail.replace(player, jail.get(player) - 1);
        } else {
            setFreeOnePlayer(player);
            player.setImprisoned(false);
            System.out.println("Congrats you are free");
        }

    }

    public void action(Player player) {
        super.action(player);
        System.out.println(player.getName() + ", you cannot do anything, wait one round.");
    }
}
