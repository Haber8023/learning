package lesson7.part1;

public interface IVisitor {
    public void visit(CommonEmployee commonEmployee);
    public void visit(Manager mannager);
}
