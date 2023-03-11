package lesson1.part3;

public class Father {
    // 成员变量
    private int age;

    public int height;

    // 成员方法
    // 返回age
    public int getAge() {
        return age;
    }

    // 设置年龄
    public void setAge(int age) {
        this.age = age;
    }

    public void printAge(){
        System.out.println("father age: " + age);
    }
}
