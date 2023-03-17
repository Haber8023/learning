package lesson4.part2;

public class GenericImpl2 implements GenericInterface<String, Integer>{

    @Override
    public String getAge(Integer param) {
        return param.toString();
    }

    public static void main(String[] args) {
        GenericImpl2 generic = new GenericImpl2();
        String age = generic.getAge(10);
        System.out.println(age);
    }
}
