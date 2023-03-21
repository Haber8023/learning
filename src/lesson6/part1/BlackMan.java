package lesson6.part1;

public class BlackMan extends Man{

    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void hunt() {
        System.out.println("use stone hunt");
    }
}
