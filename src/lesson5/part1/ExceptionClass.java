package lesson5.part1;

import java.util.Scanner;

// Java 异常处理
public class ExceptionClass {

    public static class MyException extends Exception {
        @Override
        public String getMessage() {
            return "this is a exception.";
        }
    }

    private static void method() {
        try {
            print();
        } catch (MyException e) {
            System.out.println("Exception is caught");
        }
    }

    private static void print() throws MyException {
        throw new MyException();
    }

    private static void inputTel() throws MyException {
        Scanner scanner = new Scanner(System.in);
        String tel = scanner.next();
                    if (tel.length() != 11) {
                throw new ExceptionClass.MyException(); // 抛出了参数非法异常
            }
    }

    public static void main(String[] args) {

        method();

        try {
            inputTel();
        } catch (IllegalArgumentException e) {
            System.out.println("tel in wrong, pls try again");
        } catch (NullPointerException e) {
            System.out.println("this is a NullPointerException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("this is a ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            LogUilt.log(e.getMessage());
        } finally {
            System.out.println("1234");
        }

        System.out.println("end");
    }
}
