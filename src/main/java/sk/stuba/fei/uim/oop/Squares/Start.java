package sk.stuba.fei.uim.oop.Squares;


import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.Player;

import java.util.ArrayList;

public class Start extends Square{
    public Start(String name, int position) {
        super(name, position);
    }

    public ArrayList<Player> start () {
        ArrayList<Player> players = new ArrayList<>();
        int numberOfPlayers = KeyboardInput.readNumberOfPlayers();

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = KeyboardInput.readString(String.format("Enter name of player %d", i + 1));
            Player player = new Player(name);
            while (true) {
                if (players.contains(player)) {
                    System.out.println("Player " + name + " already exists, please choose another name");
                    name = KeyboardInput.readString(String.format("Enter name of player %d", i + 1));
                    player.setName(name);
                }
                else{
                    break;
                }
            }
            players.add(player);

        }
        return players;

    }

    public void action(Player player){
        super.action(player);
        System.out.println("Now you earn 1000$");
        player.earnMoney(+1000);

    }
}
