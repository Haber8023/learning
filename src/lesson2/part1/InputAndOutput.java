package lesson2.part1;

import java.util.Scanner;

/**
 * java输入输出
 */
public class InputAndOutput {
    public int num;

    public String name;

    public InputAndOutput() {
        this.num = 100;
    }

    public InputAndOutput(int i, String name) {
        this.num = i;
        this.name = name;
    }

    public static void main(String[] args) {
        InputAndOutput inputAndOutput = new InputAndOutput(); // 通过构造函数获取类的实例
        System.out.println(inputAndOutput.num);
        System.out.println(inputAndOutput.name);

        InputAndOutput object2 = new InputAndOutput(10, "abc");
        System.out.println(object2.num);
        System.out.println(object2.name);

        // 输入
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
//        double b = scanner.nextDouble();
        System.out.println(a);
//        // 到空格停止
//        String s1 = scanner.next();
//        // 到回车停止
//        String s2 = scanner.nextLine();
//
//        // 输出
//        System.out.println("123" + s1);
        int hour = 5;
        int grade = 3;
        System.out.printf("I slept %d hours a day on average when I was a Grade %d student in SUSTech.", hour, grade);
//        System.out.println("");
        System.out.printf("\"\n");
        System.out.printf("a is %d", a);
    }
}
