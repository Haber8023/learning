package lesson6.part1;

public class ManFactory implements MyHumanFactory{
    @Override
    public Human createWhiteHuman() {
        return new WhiteMan();
    }

    @Override
    public Human createBlackHuman() {
        return new BlackMan();
    }


    public static void main(String[] args) {
        ManFactory manFactory = new ManFactory();
        WomanFactory womanFactory = new WomanFactory();

        // 单分派 静态
        WhiteMan whiteMan = (WhiteMan)manFactory.createWhiteHuman();
        // 双分派 动态
        whiteMan.getColor();
        whiteMan.hunt();

        BlackWoman blackWoman = (BlackWoman) womanFactory.createBlackHuman();
        blackWoman.getColor();
        blackWoman.cook();
    }
}
