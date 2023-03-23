package lesson7.part1;

public abstract class Employee {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void accept(IVisitor visitor);
}
