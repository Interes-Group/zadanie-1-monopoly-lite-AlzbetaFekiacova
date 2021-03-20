package sk.stuba.fei.uim.oop.other;

public class Dice {
    private int value;

    public int roll() {
        value = (int) ((Math.random() * (5)) + 1);
        return value;
    }

    @Override
    public String toString() {
        return "Player rolled " + value;
    }
}