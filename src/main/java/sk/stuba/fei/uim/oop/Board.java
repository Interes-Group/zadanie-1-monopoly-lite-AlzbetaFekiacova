package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Cards.*;
import sk.stuba.fei.uim.oop.Squares.*;

import java.util.ArrayList;

public class Board {
    private int size = 24;

    public ArrayList<Square> getSquares() {
        return squares;
    }

    private  ArrayList<Square> squares = new ArrayList<>(size);

    public Board(Jail jail) {
        String[] propertyNames = {"Hotel", "Ice cream shop", "Garage", "Inn", "Gardens", "Park", "Swimming pool", "Disneyland",
                "Lego land", "Water Plant", "Wind mill", "Bakery", "Fire station", "Pharmacy", "Flower shop", "Apartment house"};
        int[] prices = {10000, 5000, 7000, 8000, 4000, 10000, 7500, 12000, 12000, 13000, 12000, 7500, 10000, 8000, 7500, 12000};
        int[] fees = {1500, 500, 2000, 1000, 500, 1500, 500, 1500, 1500, 2000, 2000, 500, 500, 500, 500, 1500};


        ArrayList<Card> cards;
        EarnThousandCard earnThousandCard = new EarnThousandCard("Earn Thousand ");
        MoveThreeSpacesForwardCard moveThreeSpacesForwardCard = new MoveThreeSpacesForwardCard("Move three spaces forward ");
        MoveThreeSpacesBackCard moveThreeSpacesBackCard = new MoveThreeSpacesBackCard("Move three spaces back");
        LoseThousandCard loseThousandCard = new LoseThousandCard("Lose thousand ");
        SkipOneRoundCard skipOneRoundCard = new SkipOneRoundCard("Skip one round");
        cards = new ArrayList<>(5);
        cards.add(earnThousandCard);
        cards.add(moveThreeSpacesBackCard);
        cards.add(loseThousandCard);
        cards.add(skipOneRoundCard);
        cards.add(moveThreeSpacesForwardCard);

        int position = 0;
        int index = 0;
        Start start = new Start("Start", index);
        index++;
        squares.add(start);
        Property property;
        Chance chance;


        for (int i = 0; i < 2; i++) {
            property  = new Property(index, propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            index++;
            position++;
        }
        chance = new Chance("Chance", index, cards);
        index++;
        squares.add(chance);
        for (int i = 0; i < 2; i++) {
            property = new Property(index, propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            position++;
            index++;
        }
        //Jail jail = new Jail("jail", index);
        //jail.setPosition(index);
        index++;
        squares.add(jail);
        for (int i = 0; i < 2; i++) {
            property = new Property(index, propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            position++;
            index++;
        }
        //chance = new Chance("chance", index, cards);
        index++;
        squares.add(chance);
        for (int i = 0; i < 2; i++) {
            property = new Property(index, propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            position++;
            index++;
        }
        Police police = new Police("police", index,jail);
        index++;
        squares.add(police);
        for (int i = 0; i < 2; i++) {
            property = new Property(index,propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            position++;
            index++;
        }
        //chance = new Chance("chance", index, cards);
        index++;
        squares.add(chance);
        for (int i = 0; i < 2; i++) {
            property = new Property(index, propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            position++;
            index++;
        }
        Tax tax = new Tax("tax", index);
        index++;
        squares.add(tax);

        for (int i = 0; i < 3; i++) {
            property = new Property(index, propertyNames[position], prices[position], fees[position]);
            squares.add(property);
            position++;
            index++;
        }
        //chance = new Chance("chance", index,cards);
        index++;
        squares.add(chance);

        property = new Property(index, propertyNames[position], prices[position], fees[position]);
        squares.add(property);

    }



}
