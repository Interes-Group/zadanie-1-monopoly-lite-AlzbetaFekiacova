package sk.stuba.fei.uim.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardInput
{

    public static String readString(String napis_pre_uzivatela)
    {
        String s;

        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
        try
        {	System.out.println(napis_pre_uzivatela);
            s = zklavesnice.readLine();
        }
        catch (Exception e)
        {
            System.out.println("You made a mistake");
            s = readString(napis_pre_uzivatela);
        }

        return s;
    }

    public static int readNumberOfPlayers(){
        int numberOfPlayers;
        String string;
        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
        try
        {	System.out.println( "Enter number of players (Positive number greater than 1)");
            string = zklavesnice.readLine();
            numberOfPlayers = Integer.parseInt(string);
            while(numberOfPlayers <= 1){
                System.out.println("Number of players must be at least equal to two");
                numberOfPlayers = KeyboardInput.readNumberOfPlayers();
            }
        }
        catch (Exception e)
        {
            numberOfPlayers = KeyboardInput.readNumberOfPlayers();
        }

        return numberOfPlayers;
    }

    public static int readBuyOrNotToBuy(){
        int option;
        String string;
        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
        try
        {	System.out.println( "If you want to buy press 1 else press 0");
            string = zklavesnice.readLine();
            option = Integer.parseInt(string);
            while(option <0 || option > 1){
                System.out.println("You have to decide if you want to buy or not to buy, press one for buy, zero for not to buy");
                option = KeyboardInput.readBuyOrNotToBuy();
            }
        }
        catch (Exception e)
        {
            option = KeyboardInput.readBuyOrNotToBuy();
        }

        return option;
    }


    public static int readInt(String napis_pre_uzivatela)
    {
        int n;
        String s;

        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
        try
        {	System.out.println(napis_pre_uzivatela);
            s = zklavesnice.readLine();
            n = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            System.out.println("You made a mistake");
            n = readInt(napis_pre_uzivatela);
        }

        return n;
    }

}