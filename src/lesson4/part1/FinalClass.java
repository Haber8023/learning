package lesson4.part1;

// final修饰的类不能被继承
public class FinalClass {
    // final 不可变的 修饰方法、变量和类
    final String str = "abc";
    final int num = 123;

    // final修饰的方法不能被重写
    public final void getNum(){
        System.out.println(num);
    }

    public final void getStr(){
        System.out.println(str);
    }

    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        finalClass.getNum();
        finalClass.getStr();
        finalClass.getStr();

        final int c = 10;
        final DateUtils dateUtils = new DateUtils();
        System.out.println(dateUtils.n);
        dateUtils.n++;
        System.out.println(dateUtils.n);

        System.out.println(Constants.APP_VERSION);
        System.out.println(Constants.CACHE_TIME);
    }
}
