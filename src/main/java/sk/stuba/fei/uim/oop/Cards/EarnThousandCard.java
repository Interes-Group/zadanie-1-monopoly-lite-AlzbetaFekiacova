package sk.stuba.fei.uim.oop.Cards;

import sk.stuba.fei.uim.oop.Player;

public class EarnThousandCard extends Card{
    int value = 1000;

    public EarnThousandCard(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        super.action(player);
        player.earnMoney(value);
    }
}
