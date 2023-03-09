package lesson1.part2;

public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle(); // 实例化对象
        circle.setColor("white");
        circle.getInfo();
        circle.calArea();
        circle.move();
    }
}
