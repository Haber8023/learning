package lesson1.part2;

/**
 * 形状
 */
public abstract class Shape {
    // 成员变量
   private String color;

   public void setColor(String color){
       this.color = color;
   }

    public String getColor(){
        return this.color;
    }

    abstract void move();

    // 成员方法
    void getInfo(){
        System.out.println("color: " + this.color);
    }

    public static void main(String[] args) {
//        Shape shape1 = new Shape();
//        shape1.setColor("red");
//        shape1.getInfo();
//
//        Shape shape2 = new Shape();
//        shape2.setColor("white");
//        shape2.getInfo();
    }
    // 对象具有状态、行为及标识。
}
