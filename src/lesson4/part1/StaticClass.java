package lesson4.part1;

public class StaticClass {
    // 静态代码块
    static {
        num = 10;
        System.out.println("class loading");
    }

    public StaticClass(){
        System.out.println("object loading");
    }

    // 静态变量(整个类共有的变量)
    public static int num;

    // 实例变量
    public int i;

    // 静态方法
    public static int getNum(){
        return num;
    }

    public void soutI(){
        System.out.println(i);
    }

    public static void main(String[] args) {
        int c = StaticClass.num;

        StaticClass staticClass1 = new StaticClass();
        StaticClass staticClass2 = new StaticClass();

        StaticClass.getNum();
        System.out.println(c);
        DateUtils.getDate();
    }
}
