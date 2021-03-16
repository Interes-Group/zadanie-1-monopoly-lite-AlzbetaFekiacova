package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Cards.*;
import sk.stuba.fei.uim.oop.Squares.*;

import java.util.ArrayList;

public class Board {

    private final ArrayList<Square> squares;

    public Board(Jail jail) {
        int size = 24;
        squares = new ArrayList<>(size);
        buildBoard(jail);

    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    private void addProperties(int index, int end, int squareIndex, int[] prices, int[]fees, String[] propertyNames){
        Property property;
        while(index < end){
            property = new Property(squareIndex, propertyNames[index], prices[index], fees[index]);
            squares.add(property);
            squareIndex++;
            index++;
        }
    }

    private void buildBoard(Jail jail) {
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


        int propertyIndex = 0;
        int squareIndex = 0;
        Start start = new Start("Start", squareIndex);
        Chance chance;
        squareIndex++;
        squares.add(start);

        addProperties(propertyIndex, propertyIndex+2, squareIndex, prices, fees, propertyNames);
        propertyIndex += 2;
        squareIndex += 2;
        chance = new Chance("Chance", squareIndex, cards);
        squares.add(chance);
        squareIndex++;
        addProperties(propertyIndex, propertyIndex + 2, squareIndex, prices, fees, propertyNames);
        squareIndex += 2;
        propertyIndex += 2;
        squares.add(jail);
        squareIndex++;

        addProperties(propertyIndex, propertyIndex + 2, squareIndex,  prices, fees, propertyNames);
        squareIndex += 2;
        propertyIndex += 2;
        chance = new Chance("Chance", squareIndex, cards);
        squares.add(chance);
        squareIndex++;

        addProperties(propertyIndex, propertyIndex + 2, squareIndex,  prices, fees, propertyNames);
        squareIndex += 2;
        propertyIndex += 2;
        Police police = new Police("police", squareIndex, jail);
        squares.add(police);
        squareIndex++;

        addProperties(propertyIndex, propertyIndex +2,squareIndex,  prices, fees, propertyNames);
        squareIndex += 2;
        propertyIndex += 2;
        //chance.setPosition(propertyIndex);
        chance = new Chance("Chance", squareIndex, cards);
        squares.add(chance);
        squareIndex++;

        addProperties(propertyIndex, propertyIndex + 2, squareIndex, prices, fees, propertyNames);
        squareIndex += 2;
        propertyIndex += 2;

        Tax tax = new Tax("tax", squareIndex);

        squares.add(tax);
        squareIndex++;

        addProperties(propertyIndex, propertyIndex+3, squareIndex, prices, fees, propertyNames);
        squareIndex += 3;
        propertyIndex += 3;
        //chance.setPosition(propertyIndex);
        chance = new Chance("Chance", squareIndex, cards);
        squares.add(chance);
        squareIndex++;

        Property property = new Property(squareIndex, propertyNames[propertyIndex], prices[propertyIndex], fees[propertyIndex]);
        squares.add(property);

    }
}
