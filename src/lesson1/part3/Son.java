package lesson1.part3;

public class Son extends Father{
    private String habbit="eat";

    private String skill="play";

    public String getHabbit(){
        return this.habbit;
    }

    public void setHabbit(String habbit){
        this.habbit = habbit;
    }

    @Override
    public void printAge(){
        System.out.println("son age: " + getAge());
    }

    public void printAge(String name){
        System.out.println("son " + name + " age: " + getAge());
    }

    public void printAge(int sex){
        System.out.println("son " + sex + " age: " + getAge());
    }

    public void printHeight(){
        System.out.println(height);
        height = height + 10;
    }
}
