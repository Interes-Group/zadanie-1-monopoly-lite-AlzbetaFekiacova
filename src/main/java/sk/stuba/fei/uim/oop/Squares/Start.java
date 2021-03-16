package sk.stuba.fei.uim.oop.Squares;


import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Start extends Square {
    public Start(String name, int position) {
        super(name, position);
    }

    public ArrayList<Player> start() {
        ArrayList<Player> players = new ArrayList<>();
        int numberOfPlayers = KeyboardInput.readNumberOfPlayers();

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = KeyboardInput.readPlayersName(i, players);
            players.add(player);
        }
        return players;

    }

    public void action(Player player) {
        super.action(player);
        System.out.println("You have crossed the whole board, now you earn 1000$");
        player.earnMoney(1000);
    }
}
