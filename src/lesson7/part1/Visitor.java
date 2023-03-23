package lesson7.part1;

public class Visitor implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(commonEmployee.name + ": " + commonEmployee.job);
    }

    @Override
    public void visit(Manager mannager) {
        System.out.println(mannager.name + ": " + mannager.performance);
    }
}
