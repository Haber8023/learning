# 访问者模式

2023/03/23

### 公司员工报表场景

​		某公司的员工分为两类，一类是普通员工，主要考察具体工作（job），一类是管理层员工，主要考察绩效(performance)。现在有这样一个需求，需要把公司中所有员工的信息都打印在报表上。具体类图如下：

​                                                                        ![1](Lesson11%20%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F.assets/1.png)

##### 抽象员工

```java
public abstract class Employee {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract void report();
}
```



##### 普通员工

```java
public class CommonEmployee extends Employee{
    String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    void report() {
        System.out.println("name: " + name + ", job: " + job);
    }
}
```



##### 管理层员工

```java
public class Manager extends Employee{
    String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    void report() {
        System.out.println("name: " + name + ", performance: " + performance);
    }
}
```



##### 调用入口

```java

    public static void main(String[] args) {
        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.setName("jack");
        commonEmployee.setJob("coder");

        Manager mannager = new Mannager();
        manager.setName("Tom");
        manager.setPerformance("project manager");

        commonEmployee.report();
        manager.report();
    }

```

如果要去改变或者添加新的报表格式，就必须改变员工类的具体方法，灵活性较差，不利于代码拓展。



### 访问者模式

封装一些作用于某种数据结构中的各元素的操作，可以在不改变数据结构的前提下定义作用于这些元素的操作。

![img](Lesson11%20%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F.assets/v2-53208bdb8eb7268666856affb4054892_720w.webp)

- Visitor：抽象访问者
  - 抽象类或接口，声明访问者可以接受哪一类访问者访问

- ConcreteVisitor：具体访问者
  - 影响访问者访问到一个元素类后应该做什么事情
- Element：抽象元素
  - 抽象类或接口，通过定义accept()方法声明接受哪一类访问者访问
- ConcreteElement：具体元素
  - 实现accept()方法，通常是visitor.visit(this);
- ObjectStructure：元素对象
  - 具体元素的某一对象



##### 抽象访问者

```java
public interface IVisitor {
    public void visit(CommonEmployee commonEmployee);
    public void visit(Mannager mannager);
}
```



##### 具体访问者

```java
public class Visitor implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(commonEmployee.name + ": " + commonEmployee.job);
    }

    @Override
    public void visit(Mannager mannager) {
        System.out.println(mannager.name + ": " + mannager.performance);
    }
}

public class Visitor2 implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(commonEmployee.job);
    }

    @Override
    public void visit(Mannager mannager) {
        System.out.println(mannager.performance);
    }
}
```



##### 抽象元素

```java
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
```



##### 具体元素

```java
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
```

```java
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
```



##### 调用入口

```java
public static void main(String[] args) {
        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.setName("jack");
        commonEmployee.setJob("coder");

        Manager manager = new Manager();
        manager.setName("Tom");
        manager.setPerformance("project manager");

        commonEmployee.accept(new Visitor());
        manager.accept(new Visitor(2));
    
    	commonEmployee.accept(new Visitor2());
        manager.accept(new Visitor2(2));
    }
```



![2](Lesson11%20%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F.assets/2.png)



### 单分派与双分派

单分派与双分派是一种语言处理方式。

```java
public void method(T param){
    
}

object.method(param);
```



- 单分派（single dispatch）语言处理一个操作是根据请求名称和接收到的参数决定的，在编译期就决定了要调用什么方法（静态绑定）。

  - 以重载为例，在程序运行前，根据参数的类型即确定了具体要调用什么方法

  ```java
  public class Visitor{
      public void visit(CommonEmployee commonEmployee) {
          System.out.println(commonEmployee.name + ": " + commonEmployee.job);
      }
  
      public void visit(Mannager mannager) {
          System.out.println(mannager.name + ": " + mannager.performance);
      }
      
      public static void main(String[] args) {
          CommonEmployee commonEmployee = new CommonEmployee();
          commonEmployee.setName("jack");
          commonEmployee.setJob("coder");
  
          Manager manager = new Manager();
          manager.setName("Tom");
          manager.setPerformance("project manager");
  
          commonEmployee.accept(new Visitor());
          manager.accept(new Visitor());
      }
  }
  ```

- 双分派（double dispatch）语言处理的操作不仅由请求名称和接收到的参数决定，还由调用者的类型决定，在代码被执行时才能确定调用什么方法（动态绑定）。

  - 如果把CommonEmployee和Manager产生的对象都放到一个List<Employee>里面，遍历调用employee.accept(new Visitor()，则只有在知道具体的e属于什么类型时，才知道应该调用哪个方法。

  ```java
  public void report(List<Employee> employeeList) {
      for(Employee employee: employeeList) {
          employee.visit(new Visitor);
      }
  }
  ```

  