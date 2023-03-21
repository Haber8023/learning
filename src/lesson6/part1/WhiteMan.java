package lesson6.part1;

public class WhiteMan extends Man{

    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void hunt() {
        System.out.println("use gun hunt");
    }
}
