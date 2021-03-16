package sk.stuba.fei.uim.oop.Squares;

import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.Player;

public class Property extends Square {
    private int position;
    private String name;
    private int price;
    private int fee;
    private Player owner;

    public Property(int position, String name, int price, int fee) {
        super(name, position);
        this.position = position;
        this.name = name;
        this.price = price;
        this.fee = fee;
        owner = null;
    }


    private void noOwnerAction(Player player) {
        if (player.getMoney() - price >= 0) {
            System.out.println("You have enough money you can buy this property");
            System.out.println("Price is " + price + "$");
            System.out.println("You have " + player.getMoney() + "$");
            int option = KeyboardInput.readBuyOrNotToBuy();

            if (option == 1) {
                player.setMoney(player.getMoney() - price);
                this.owner = player;
                player.addProperty(this);
                System.out.println("Congrats, you now own new property, your new money is " + player.getMoney() + "$");

            } else {
                System.out.println("Nice, safe money for later");

            }
        } else {
            System.out.println("Sorry you do not have enough money, you cannot buy this property.");
        }

    }

    @Override
    public void action(Player player) {
        super.action(player);

        if (this.owner == null) {
            noOwnerAction(player);

        } else if (this.owner.equals(player)) {
            System.out.println("You already own this property, well done!");
        } else {
            System.out.println("You have to pay fee for stepping on someone else's property");
            System.out.println("The fee is " + fee + "$");
            player.spendMoney(fee);
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
