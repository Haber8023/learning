package lesson4.part2;

public class GenericImpl implements GenericInterface<Integer, String>{

    @Override
    public Integer getAge(String param) {
        return Integer.valueOf(param);
    }

    public static void main(String[] args) {
        GenericImpl generic = new GenericImpl();
        int age = generic.getAge("10");
        System.out.println(age);
    }
}
