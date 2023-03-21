package lesson6.part1;

public class WomanFactory implements MyHumanFactory{
    @Override
    public Human createWhiteHuman() {
        return new WhiteWoman();
    }

    @Override
    public Human createBlackHuman() {
        return new BlackWoman();
    }
}
