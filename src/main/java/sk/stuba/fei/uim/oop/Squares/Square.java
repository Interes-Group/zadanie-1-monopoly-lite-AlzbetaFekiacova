package sk.stuba.fei.uim.oop.Squares;


import sk.stuba.fei.uim.oop.Player;

public class Square {
    private String name;
    private int position;

    public Square(){}

    public Square(String name, int position) {
        this.name = name;
        this.position = position;
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

    @Override
    public String toString() {
        return "You stepped on " + name + " square";
    }

    public void action(Player player){
        System.out.println(toString());
    }
}
