# 工厂模式

2023/03/21

### Java设计模式

​		设计模式是在软件工程实践过程中，程序员们总结出的良好的编程方法。设计模式，即**软件架构**、**实现思路**，一方面便于后期扩展，二方面便于研发。使用设计模式能够增加系统的健壮性，易修改性和可扩展性，当你进行开发的软件规模比较大的时候，良好的设计模式会给编程带来便利，让系统更加稳定，这些在自己编写小程序的时候是体现不出来的。



### 工厂模式

​		现实生活中，工厂是负责生产产品的；在设计模式中，工厂模式负责生产某类对象。



### 简单工厂模式

![img](Lesson9%20%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.assets/7000.png)

| 组成（角色）                 | 关系                               | 作用                                         |
| :--------------------------- | :--------------------------------- | :------------------------------------------- |
| 抽象产品（Product）          | 具体产品的父类                     | 描述产品的公共接口                           |
| 具体产品（Concrete Product） | 抽象产品的子类；工厂类创建的目标类 | 描述生产的具体产品                           |
| 工厂（Creator）              | 被外界调用                         | 根据传入不同参数从而创建不同具体产品类的实例 |

####  使用步骤

- 创建**抽象产品类**  或 定义产品的公共接口；
- 创建**具体产品类**（继承抽象产品类） 或 定义生产的具体产品（实现产品的公共接口）；
- 创建**工厂类**，通过创建静态方法根据传入不同参数从而创建不同具体产品类的实例；
- 外界通过调用工厂类的静态方法，**传入不同参数**从而创建不同**具体产品类的实例**



#### example 女娲造人：

1. ##### 定义产品的公共接口（人类）

```java
public interface Human {
	// 获取肤色
    public void getColor();
}
```



2. ##### 实现产品的公共接口（不同人种）

```java
public class BlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("black");
    }
}
```

```JAVA
public class WhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("white");
    }
}
```

```JAVA
public class YellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("yellow");
    }
}
```



3. ##### 创建工厂类(八卦炉)

```java
public static <T extends Human> Human createHuman(Class<T> humanClass) {
        Human human = null;
        try {

            human = humanClass.newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return human;
    }
}
```



3. ##### 传入不同参数从而创建不同具体产品类的实例（通过工厂获取对象）

```java
public static void main(String[] args) {
        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();

        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
    
    	Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
    }
```

#### 

#### 工厂模式的优点

1. 具有良好的封装性，调用者只需要知道产品的类型就可以获得产品对象，不需要了解具体的构造方法。
2. 具有良好的拓展性，比如我们要增加一个其他颜色的人种，只需要使其继承Human接口就可以了，不需要对工厂进行二次改造。



#### 升级为抽象工厂类

​		当我们在做一个比较复杂的项目时，不同的产品可能需要不同的实现方法，如果像上面一样把所有的产品类都放到一个工厂方法中进行初始化，会使代码结构不清晰。这时，我们就需要为每类产品去定义一个工厂，并将产品与对应的工厂方法进行关联。

![img](Lesson9%20%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.assets/987275-20160728211309528-484513665.png)

​		对于多个有区分的产品（比如将男人和女人看作两类不同的产品），可以通过实现抽象工厂类，创建多个不同的工厂，由调用者决定从哪个工厂获取产品。



#### example 女娲造男人和女人：

1. ##### 定义产品的公共接口（人类）

```java
public interface Human {
	// 获取肤色
    public void getColor();
}
```



##### 2. 定义不同产品的抽象类（男人和女人）

```java
public abstract class Man implements Human{
    public abstract void hunt();
}
```

```java
public abstract class Woman implements Human{
    public abstract void cook();
}
```



3. ##### 实现产品的公共接口（不同人种的男人和女人）

```java
public class BlackMan extends Man{
    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void hunt() {
        System.out.println("use stone");
    }
}
```

```java
public class WhiteMan extends Man{
    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void hunt() {
        System.out.println("use gun");
    }
}
```

```java
public class BlackWoman extends Woman{
    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void cook() {
        System.out.println("cook fish");
    }
}
```

```java
public class WhiteWoman extends Woman{
    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void cook() {
        System.out.println("cook pig");
    }
}
```



4. ##### 创建抽象工厂类(八卦炉)

```java
public interface MyHumanFactory {
    public Human createWhiteHuman();
    public Human createBlackHuman();
}
```



5. ##### 实现不同的工厂类(男人八卦炉和女人八卦炉)

```java
public class WomanFactory implements MyHumanFactory{
    @Override
    public Human createWhiteHuman() {
        return new WhiteWoman();
    }

    @Override
    public Human createBlackHuman() {
        return new BlackWoman();
    }
}
```

```java
public class ManFactory implements MyHumanFactory{
    @Override
    public Human createWhiteHuman() {
        return new WhiteMan();
    }

    @Override
    public Human createBlackHuman() {
        return new BlackMan();
    }
}
```



6. ##### 传入不同参数从而创建不同具体产品类的实例（通过工厂获取对象）

```java
public static void main(String[] args) {
        WomanFactory womanFactory = new WomanFactory();
        ManFactory manFactory = new ManFactory();
        Woman whiteWoman = (Woman)womanFactory.createWhiteHuman();
        whiteWoman.getColor();
        whiteWoman.cook();

        Man blackMan = (Man)manFactory.createBlackHuman();
        blackMan.getColor();
        blackMan.hunt();
    }
```