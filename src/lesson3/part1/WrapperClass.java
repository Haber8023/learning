package lesson3.part1;

import java.util.Scanner;

public class WrapperClass {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // io
        String ss = scanner.next();
        char ch3 = ss.charAt(0);

        Integer a = new Integer(10); // 手动装箱
        int b = a.intValue(); // 手动拆箱

        Integer x = 10; // 自动装箱 int
        int y = x; // 自动拆箱

        String tel = "180023";
        int c = Integer.parseInt(tel);

        Character ch = 'a';
        char ch2 = ch;
        // ch3 >= 'a' && ch3 <= 'z'
        if(Character.isLowerCase(ch3)){
            System.out.println("is lower case");
        } else {
            System.out.println("no");
        }

        System.out.println(a);
    }
}
