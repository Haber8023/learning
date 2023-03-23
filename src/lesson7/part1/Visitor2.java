package lesson7.part1;

public class Visitor2 implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println("job: " + commonEmployee.job);
    }

    @Override
    public void visit(Manager mannager) {
        System.out.println("performance: " + mannager.performance);
    }
}
