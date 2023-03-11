package lesson1.part3;

public class Son2 {
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
        System.out.println(age);
    }

    private String habbit="eat";

    private String skill="play";

    public String getHabbit() {
        return habbit;
    }

    public void setHabbit(String habbit) {
        this.habbit = habbit;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void printHeight(){
        System.out.println(height);
        height = height + 10;
    }
}
