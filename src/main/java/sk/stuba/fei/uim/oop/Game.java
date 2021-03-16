package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Squares.Jail;
import sk.stuba.fei.uim.oop.Squares.Start;

import java.util.ArrayList;


public class Game {
    public void game() {
        ArrayList<Player> players;
        Jail jail = new Jail("Jail", 6);
        Board board = new Board(jail);
        int round = 0;
        players = ((Start) board.getSquares().get(0)).start();
        do {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.printf("It is round %d%n", round + 1);
            System.out.println();
            round++;
            for (int i = 0; i < players.size(); i++) {
                System.out.println();
                Player player = players.get(i);
                player.turn(board, jail);

                if (player.getMoney() <= 0) {
                    player.die(board.getSquares());
                    players.remove(player);
                }
                System.out.println("------------------------------------------------------------------------------------");

            }
        } while (players.size() != 1);
        System.out.println("End of the game");
        System.out.println(players.get(0).getName() + " is winner!\nCongratulations!");

    }


}
