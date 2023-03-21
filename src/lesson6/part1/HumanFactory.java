package lesson6.part1;

public class HumanFactory {
    public static <T extends Human> Human createHuman(Class<T> humanClass){
        Human human = null;
        try {
            human = humanClass.newInstance();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return human;
    }

    public static void main(String[] args) {
        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();

        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();

        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
    }
}
