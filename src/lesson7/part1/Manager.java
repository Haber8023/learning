package lesson7.part1;

public class Manager extends Employee{
    String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
