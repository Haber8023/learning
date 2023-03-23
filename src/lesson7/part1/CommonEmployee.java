package lesson7.part1;

public class CommonEmployee extends Employee{
    String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
