package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.other.Player;

public class LoseThousandCard extends Card{
    private int value;
    public LoseThousandCard(String name){
        super(name);
        value = 1000;
    }
    @Override
    public void action(Player player) {
        super.action(player);
        player.spendMoney(value);
    }
}
