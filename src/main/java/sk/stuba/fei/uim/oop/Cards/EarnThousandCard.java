package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.Player;

public class EarnThousandCard extends Card{
    private int value;

    public EarnThousandCard(String name) {
        super(name);
        value = 1000;
    }

    @Override
    public void action(Player player) {
        super.action(player);
        player.earnMoney(value);
    }
}
