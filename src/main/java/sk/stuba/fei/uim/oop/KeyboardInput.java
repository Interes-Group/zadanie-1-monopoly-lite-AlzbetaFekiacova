package sk.stuba.fei.uim.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KeyboardInput {

    public static String readString(String displayToUser) {
        String s;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(displayToUser);
            s = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println("You made a mistake");
            s = readString(displayToUser);
        }

        return s;
    }

    public static int readNumberOfPlayers() {
        int numberOfPlayers;
        String string;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number of players (Positive number greater than 1)");
            string = bufferedReader.readLine();
            numberOfPlayers = Integer.parseInt(string);
            while (numberOfPlayers <= 1) {
                System.out.println("Number of players must be at least equal to two");
                numberOfPlayers = KeyboardInput.readNumberOfPlayers();
            }
        } catch (Exception e) {
            numberOfPlayers = KeyboardInput.readNumberOfPlayers();
        }

        return numberOfPlayers;
    }

    public static int readBuyOrNotToBuy() {
        int option;
        String string;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("If you want to buy press 1 else press 0");
            string = bufferedReader.readLine();
            option = Integer.parseInt(string);
            while (option < 0 || option > 1) {
                System.out.println("You have to decide if you want to buy or not to buy, press one for buy, zero for not to buy");
                option = KeyboardInput.readBuyOrNotToBuy();
            }
        } catch (Exception e) {
            option = KeyboardInput.readBuyOrNotToBuy();
        }

        return option;
    }

    public static Player readPlayersName(int number, ArrayList<Player> players){
        String name = KeyboardInput.readString(String.format("Enter name of player %d", number + 1));
        Player player = new Player(name);
        while (true) {
            if (players.contains(player)) {
                System.out.println("Player " + name + " already exists, please choose another name");
                name = KeyboardInput.readString(String.format("Enter name of player %d", number + 1));
                player.setName(name);
            } else {
                break;
            }
        }
        return player;
    }

}