package lesson6.part1;

public class WhiteWoman extends Woman{
    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void cook() {
        System.out.println("pork");
    }
}
