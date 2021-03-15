package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.Player;

public class LoseThousandCard extends Card{
    private int value = 1000;
    public LoseThousandCard(String name){
        super(name);
    }
    @Override
    public void action(Player player) {
        super.action(player);
        player.spendMoney(value);
    }
}
