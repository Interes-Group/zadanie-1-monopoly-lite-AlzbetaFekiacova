package sk.stuba.fei.uim.oop.Squares;


import sk.stuba.fei.uim.oop.Player;

public class Tax extends Square {
    int taxFee = 5000;

    public Tax(String name, int position) {
        super(name, position);
    }

    @Override
    public void action(Player player) {
        super.action(player);
        System.out.println("You have to pay " + taxFee);
        player.spendMoney(taxFee);
    }
}