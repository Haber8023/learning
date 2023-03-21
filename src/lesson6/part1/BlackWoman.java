package lesson6.part1;

public class BlackWoman extends Woman{
    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void cook() {
        System.out.println("fish");
    }
}
