package lesson1.part2;

public class Square extends Shape implements ShapeUtils{
    // 继承父类的非私有成员变量和方法

    int a = 2;

    @Override
    public void calArea() {
        System.out.println("area: " + a*a);
    }

    @Override
    void move() {
        System.out.println("pingyi");
    }

    public static void main(String[] args) {
        Square square = new Square();
        square.setColor("white");
        square.getInfo();
        square.calArea();
        square.move();
    }
}
