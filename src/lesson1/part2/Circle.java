package lesson1.part2;

public class Circle extends Shape implements ShapeUtils{
    // 继承父类的非私有成员变量和方法

    int radius = 2;

    @Override
    public void calArea() {
        System.out.println("area: " + 3.14 * radius * radius);
    }

    @Override
    void move() {
        System.out.println("gun");   // 栈 堆
    }

    @Override
    public void getInfo(){
        System.out.println("circle's color is: " + this.getColor()); // 通过重写实现多态
    }
}
