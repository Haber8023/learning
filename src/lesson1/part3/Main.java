package lesson1.part3;

public class Main {
    public static void main(String[] args) {
        Father father = new Father();
        father.setAge(40); // 40只对father这一个对象起作用
        System.out.println(father.getAge());

        Father father2 = new Father(); // 构造函数
        System.out.println(father2.getAge());

        Son son = new Son();
        son.setAge(10);
        son.getAge();
        son.printAge();
        son.printAge("nick");
//         son.habbit = "sleep"
        System.out.println(son.getHabbit());
        son.setHabbit("sleep");
//        son.habbit
        System.out.println(son.getHabbit());
    }

//     多态
//     严格多态 你一个方法，在被调用之前，是不能确定方法的具体实现的 -> 重写, 实现虚方法, 实现接口
//     一模一样的方法名和参数，表现出不同的具体实现
//     广义多态 一模一样的方法名，表现出不同的具体实现 -> 重载
}
