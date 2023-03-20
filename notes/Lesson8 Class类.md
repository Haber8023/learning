# Class类

2023/03/19

Class类提供很多方法用于获取类的各种信息，比如获取类名、判断该类是否是一个接口还是普通类等等。

一个类只有被JVM（JAVA虚拟机）加载后才能使用。当类被虚拟机加载后都会在内存中创建一个该类的Class对象，用于存储该类的各种信息。



### 如何获取一个Class的对象

```java
public static void main(String[] args){
        //第一种 通过类.class获取
        Class c1 = String.class;

        //第二种 通过对象.getClass()获取
        String s = "hello,world";
        Class c2 = s.getClass();

        //第三种,Class.forName("完整类名")获取,其实就是动态加载类，注意捕获异常，因为类有可能不存在 
        try {
            Class c3 = Class.forName("com.test.Book");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
```



### 有了 Class的对象怎么用

```java
public class Student {
    private String name;
    private int age;

    public static void main(String[] args){
        //一般我们把Class的对象叫字节码
        Class c = Student.class;

        // 外部普通类
        System.out.println("Student类名是：" + c.getName());
        System.out.println("Student类的简单类名是：" + c.getSimpleName());
        System.out.println("Student类有" + c.getDeclaredFields().length + "个字段");

        /**
         * ....
         * 我们可以通过 c （也就是Student这个类的对象，或者你也可以叫做Student类的字节码)
         * 拿到Student类中所有的方法名，方法数，字段名，字段数量，甚至你还可以通过Method来调用方法
         */
    }
}
```



## isInstance(Object obj)方法

`isInstance`用于判断obj对象是否是该类或其子类的一个实例。

```java
String hello = "hello"; boolean isStr = String.class.isInstance(hello);
```

```java
boolean is = Number.class.isInstance(Integer.valueOf(1))
```