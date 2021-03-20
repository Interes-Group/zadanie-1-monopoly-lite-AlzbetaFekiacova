package sk.stuba.fei.uim.oop.Squares;


import sk.stuba.fei.uim.oop.other.Player;

public class Police extends Square{
    private Jail jail;
    public Police(String name, int position, Jail jail) {
        super(name, position);
        this.jail = jail;
    }

    @Override
    public void action(Player player) {
        super.action(player);
        System.out.println("You are going into prison for three rounds");
        jail.addPlayer(player);
    }
}
