package sk.stuba.fei.uim.oop;


import sk.stuba.fei.uim.oop.Squares.Jail;
import sk.stuba.fei.uim.oop.Squares.Property;
import sk.stuba.fei.uim.oop.Squares.Square;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String name;
    private int position;
    int money;
    boolean isImprisoned;

    ArrayList<Property> properties;


    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.money = 15000;
        this.isImprisoned = false;
        properties = new ArrayList<>();


    }

    private void notImprisonedTurn(Board board) {
        Dice dice = new Dice();
        int rolled = dice.roll();
        System.out.println(dice.toString());

        int position = this.position;
        position += rolled;
        position = position % 24;
        this.position = position;
        Square square = board.getSquares().get(position);
        square.action(this);


        while (true) {
            if (position != this.position) {

                square = board.getSquares().get(this.position);
                square.action(this);
                position = this.position;
            } else {
                break;
            }
        }
    }

    public void displayProperties() {
        if (properties.size() > 0) {
            System.out.println("You own these properties:");

            for (Property property : properties) {
                System.out.println(property.getName());
            }
        } else {
            System.out.println("You do not have any property yet.");
        }

    }

    public void turn(Board board, Jail jail) {
        System.out.printf("It is player %s's turn%n", name);
        System.out.println("You have " + money + "$");
        System.out.println("Your position is " + board.getSquares().get(position).getName() + " square");
        displayProperties();
        System.out.println();
        if (!isImprisoned) {
            notImprisonedTurn(board);
        } else {
            System.out.println("Sorry you are in prison, you have to wait");
            jail.oneRoundPassed(this);
        }
    }


    public void earnMoney(int earn) {
        money += earn;
        System.out.println(getName() + " has now " + getMoney() + "$");
    }

    public void spendMoney(int toSpend) {
        money -= toSpend;
        if (money < 0) {
            money = 0;
        }
        System.out.println(getName() + " has now " + getMoney() + "$");
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setImprisoned(boolean imprisoned) {
        isImprisoned = imprisoned;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position && money == player.money && isImprisoned == player.isImprisoned && Objects.equals(name, player.name) && Objects.equals(properties, player.properties);
    }

    public void die(ArrayList<Square> properties) {
        System.out.println(name + " is dead");
        for (Square prop : properties) {
            if (prop instanceof Property) {
                if (((Property) prop).getOwner() != null) {
                    if (((Property) prop).getOwner().equals(this)) {
                        ((Property) prop).setOwner(null);
                    }
                }
            }
        }
    }
}
