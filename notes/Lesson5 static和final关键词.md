# static和final关键词

2023/03/17

### 1. static（静态的）

- ##### 静态变量

​	类的成员变量可以分为以下两种：

1. 静态变量（或称为类变量），指被 static 修饰的成员变量。
2. 实例变量，指没有被 static 修饰的成员变量。



**静态变量与实例变量的区别：**

1）静态变量

1. 运行时，Java 虚拟机只为静态变量分配一次内存，在加载类的过程中完成静态变量的内存分配。
2. 在类的内部，可以在任何方法内直接访问静态变量。
3. 在其他类中，可以通过类名访问该类中的静态变量。


2）实例变量

1. 每创建一个实例，Java 虚拟机就会为实例变量分配一次内存。
2. 在类的内部，可以在非静态方法中直接访问实例变量。
3. 在本类的静态方法或其他类中则需要通过类的实例对象进行访问。

```java
public class StaticVar {
    public static String str1 = "Hello";
    public static void main(String[] args) {
        String str2 = "World!";
        // 直接访问str1
        String accessVar1 = str1+str2;
        System.out.println("第 1 次访问静态变量，结果为："+accessVar1);
        // 通过类名访问str1
        String accessVar2 = StaticVar.str1+str2;
        System.out.println("第 2 次访问静态变量，结果为："+accessVar2);
        // 通过对象svt1访问str1
        StaticVar svt1 = new StaticVar();
        svt1.str1 = svt1.str1+str2;
        String accessVar3 = svt1.str1;
        System.out.println("第3次访向静态变量，结果为："+accessVar3);
        // 通过对象svt2访问str1
        StaticVar svt2 = new StaticVar();
        String accessVar4 = svt2.str1+str2;
        System.out.println("第 4 次访问静态变量，结果为："+accessVar4);
    }
}
```

 

- ##### 静态方法

与成员变量类似，成员方法也可以分为以下两种：

1. 静态方法（或称为类方法），指被 static 修饰的成员方法。

2. 实例方法，指没有被 static 修饰的成员方法。

   

**静态方法与实例方法的区别：**

1. 静态方法不需要通过它所属的类的任何实例就可以被调用，因此在静态方法中不能使用 this 关键字，也不能直接访问所属类的实例变量和实例方法，但是可以直接访问所属类的静态变量和静态方法。另外，和 this 关键字一样，super 关键字也与类的特定实例相关，所以在静态方法中也不能使用 super 关键字。
2. 在实例方法中可以直接访问所属类的静态变量、静态方法、实例变量和实例方法。

```java
public class StaticMethod {
    public static int count = 1;    // 定义静态变量count
    public int method1() {    
        // 实例方法method1
        count++;    // 访问静态变量count并赋值
        System.out.println("在静态方法 method1()中的 count="+count);    // 打印count
        return count;
    }
    public static int method2() {    
        // 静态方法method2
        count += count;    // 访问静态变量count并赋值
        System.out.println("在静态方法 method2()中的 count="+count);    // 打印count
        return count;
    }
    public static void PrintCount() {    
        // 静态方法PrintCount
        count += 2;
        System.out.println("在静态方法 PrintCount()中的 count="+count);    // 打印count
    }
    public static void main(String[] args) {
        StaticMethod sft = new StaticMethod();
        // 通过实例对象调用实例方法
        System.out.println("method1() 方法返回值 intro1="+sft.method1());
        // 直接调用静态方法
        System.out.println("method2() 方法返回值 intro1="+method2());
        // 通过类名调用静态方法，打印 count
        StaticMethod.PrintCount();
    }
}
```



- ##### 静态代码块

静态代码块指 Java 类中的 static{ } 代码块，主要用于初始化类，为类的静态变量赋初始值，提升程序性能。



**静态代码块的特点：**

1. 静态代码块类似于一个方法，但它不可以存在于任何方法体中。

2. 静态代码块可以置于类中的任何地方，类中可以有多个静态初始化块。 

3. Java 虚拟机在加载类时执行静态代码块，所以很多时候会将一些只需要进行一次的初始化操作都放在 static 代码块中进行。

4. 如果类中包含多个静态代码块，则 Java 虚拟机将按它们在类中出现的顺序依次执行它们，每个静态代码块只会被执行一次。

   ```java
   public class StaticCode {
       public static int count = 0;
       {
           count++;
           System.out.println("非静态代码块 count=" + count);
       }
       static {
           count++;
           System.out.println("静态代码块1 count=" + count);
       }
       static {
           count++;
           System.out.println("静态代码块2 count=" + count);
       }
   
       public static void main(String[] args) {
           System.out.println("*************** StaticCode1 执行 ***************");
           StaticCode sct1 = new StaticCode();
           System.out.println("*************** StaticCode2 执行 ***************");
           StaticCode sct2 = new StaticCode();
       }
   }
   ```



### 2. final （不可变的)

final用于修饰类、成员变量和成员方法。

- final修饰的类，不能被继承（String，称为不可变类），其中所有的方法都不能被重写，所以不能同时用abstract和final修饰类（abstract修饰的类是抽象类，抽象类是用于被子类继承的，和final起相反的作用）；

​		PS：除非这个类真的在以后不会用来继承或者出于安全的考虑，尽量不要将类设计为final类。

- final修饰的方法不能被重写，但是子类可以用父类中final修饰的方法；
- final修饰的成员变量是不可变的，如果成员变量是基本数据类型，初始化之后成员变量的值不能被改变，如果成员变量是引用类型，那么它只能指向初始化时指向的那个对象，不能再指向别的对象，但是对象当中的内容是允许改变的。



### 3. 常量

final经常和static关键字一起作为修饰词，被final和static同时修饰的变量作为常量，常量需使用大写字母命名，用下划线进行连接。

```JAVA
public class Constant{
	public static final String APP_VERSION = "7.0.2";
    public static final int CACHE_TIME = 10*60*1000; // 10分钟对应的毫秒数
}

```

