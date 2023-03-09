package lesson1.part1;

import lesson1.part2.Circle;
import lesson1.part2.Shape;

/**
 * 基本数据类型
 */
public class BaseClass {
    public static void main(String[] args) {
        char ch1 = 'b';
        char ch2 = 97; // a
        System.out.println(ch1 - ch2);

        boolean isRed = true;

        byte b = 1 << 2; // 100
        System.out.println(b);

        // 整数
        short shortNum = Short.MAX_VALUE; // -32768 ~ 32767
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
        int intNum;
        long longNum = 2147483648L;

        // 小数
        float aa = Float.MAX_VALUE;
        System.out.println(aa);
        double bb = Double.MAX_VALUE;
        System.out.println(bb);

        // 浅拷贝 未重写Clone方法 复制的是同一个对象
        Circle circle1 = new Circle();
        circle1.setColor("red");
        Circle circle2 = circle1;
        System.out.println(circle2.getColor());
        circle1.setColor("white");
        System.out.println(circle2.getColor());

        // 深拷贝 重新创建一个具有相同属性的对象
        Integer aaa = new Integer(1);
        Integer bbb = new Integer(aaa.intValue());
        System.out.println(aaa);
        aaa = 2;
        System.out.println(bbb);
    }
}
