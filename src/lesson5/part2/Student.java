package lesson5.part2;

import lesson5.part1.ExceptionClass;

// 通过Student类了解Clas类
public class Student {
    public Student(String name){
        this.name = name;
    }

    private String name;

    private String gender;

    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        // 1. 类.class获取Class对象
        Class c1 = Student.class;

        // 2. 对象.getClass()
        Student student = new Student("Jack");
        Class c2 = student.getClass();

        // 3. Class.forName(String className)
        try {
            Class c3 = Class.forName("lesson5.part2.Teacher");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ExceptionClass student2 = new ExceptionClass();

        System.out.println(c1.getName());
        System.out.println(c1.getDeclaredFields().length);
        if(c1.isInstance(student)){
            System.out.println(student.getName());
        }
        System.out.println(c1.isInstance(student2));
    }
}
