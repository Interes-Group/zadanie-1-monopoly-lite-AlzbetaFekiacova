package sk.stuba.fei.uim.oop.other;


import sk.stuba.fei.uim.oop.Cards.*;
import sk.stuba.fei.uim.oop.Squares.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

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

    private void addProperties(AtomicInteger index, int end, AtomicInteger squareIndex, int[] prices, int[] fees, String[] propertyNames) {
        Property property;
        while (index.get() < end) {
            property = new Property(squareIndex.get(), propertyNames[index.get()], prices[index.get()], fees[index.get()]);
            squares.add(property);
            squareIndex.incrementAndGet();
            index.incrementAndGet();
        }
    }

    private void buildBoard(Jail jail) {
        String[] propertyNames = {"Hotel", "Ice cream shop", "Garage", "Inn", "Gardens", "Park", "Swimming pool", "Disneyland",
                "Lego land", "Water Plant", "Wind mill", "Bakery", "Fire station", "Pharmacy", "Flower shop", "Apartment house"};
        int[] prices = {8000, 3000, 4000, 2500, 2000, 5000, 3500, 5500, 6000, 7500, 6000, 2500, 6000, 4000, 2500, 6000};
        int[] fees = {1500, 500, 2000, 1000, 500, 1500, 500, 1500, 1500, 2000, 2000, 500, 500, 500, 500, 1500};

        ArrayList<Card> cards = makeStackOfCards();
        AtomicInteger propertyIndex = new AtomicInteger(0);
        AtomicInteger squareIndex = new AtomicInteger(0);
        Start start = new Start("Start", squareIndex.get());
        squareIndex.incrementAndGet();
        squares.add(start);

        addProperties(propertyIndex, propertyIndex.get() + 2, squareIndex, prices, fees, propertyNames);

        Chance chance;
        chance = new Chance("Chance", squareIndex.get(), cards);
        squares.add(chance);
        squareIndex.incrementAndGet();
        addProperties(propertyIndex, propertyIndex.get() + 2, squareIndex, prices, fees, propertyNames);

        squares.add(jail);
        squareIndex.incrementAndGet();

        addProperties(propertyIndex, propertyIndex.get() + 2, squareIndex, prices, fees, propertyNames);

        chance = new Chance("Chance", squareIndex.get(), cards);
        squares.add(chance);
        squareIndex.incrementAndGet();

        addProperties(propertyIndex, propertyIndex.get() + 2, squareIndex, prices, fees, propertyNames);

        Police police = new Police("police", squareIndex.get(), jail);
        squares.add(police);
        squareIndex.incrementAndGet();

        addProperties(propertyIndex, propertyIndex.get() + 2, squareIndex, prices, fees, propertyNames);

        chance = new Chance("Chance", squareIndex.get(), cards);
        squares.add(chance);
        squareIndex.incrementAndGet();

        addProperties(propertyIndex, propertyIndex.get() + 2, squareIndex, prices, fees, propertyNames);

        Tax tax = new Tax("tax", squareIndex.get());

        squares.add(tax);
        squareIndex.incrementAndGet();

        addProperties(propertyIndex, propertyIndex.get() + 3, squareIndex, prices, fees, propertyNames);

        chance = new Chance("Chance", squareIndex.get(), cards);
        squares.add(chance);
        squareIndex.incrementAndGet();

        Property property = new Property(squareIndex.get(), propertyNames[propertyIndex.get()], prices[propertyIndex.get()], fees[propertyIndex.get()]);
        squares.add(property);

    }

    public ArrayList<Card> makeStackOfCards() {
        EarnThousandCard earnThousandCard = new EarnThousandCard("Earn Thousand dollars ");
        MoveThreeSpacesForwardCard moveThreeSpacesForwardCard = new MoveThreeSpacesForwardCard("Move three spaces forward ");
        MoveThreeSpacesBackCard moveThreeSpacesBackCard = new MoveThreeSpacesBackCard("Move three spaces backward ");
        LoseThousandCard loseThousandCard = new LoseThousandCard("Lose thousand dollars ");
        SkipOneRoundCard skipOneRoundCard = new SkipOneRoundCard("Skip one round ");
        ArrayList<Card> cardsToShuffle = new ArrayList<>(5);
        cardsToShuffle.add(earnThousandCard);
        cardsToShuffle.add(skipOneRoundCard);
        cardsToShuffle.add(moveThreeSpacesBackCard);
        cardsToShuffle.add(loseThousandCard);

        cardsToShuffle.add(moveThreeSpacesForwardCard);
        Collections.shuffle(cardsToShuffle);
        return cardsToShuffle;
    }
}
