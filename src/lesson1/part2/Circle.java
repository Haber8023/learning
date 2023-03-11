package lesson1.part2;

public class Circle extends Shape implements ShapeUtils{
    // 继承父类的非私有成员变量和方法

    private int radius = 2;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void calArea() {
        System.out.println("area: " + 3.14 * radius * radius);
    }

    @Override
    public void move() {
        System.out.println("gun");   // 栈 堆
        radius = 1;
    }

    @Override
    public void getInfo(){
        System.out.println("circle's color is: " + this.getColor()); // 通过重写实现多态
    }
}
