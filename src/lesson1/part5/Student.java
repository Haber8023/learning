package lesson1.part5;

public class Student extends Human implements Interface1, Interface2 {

    @Override
    public int getSalary() {
        return 0;
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
    }

    @Override
    public String getHeight() {
        return "180";
    }

    @Override
    public String getAge() {
        return "nick";
    }
}
