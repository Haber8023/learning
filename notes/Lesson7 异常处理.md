# 异常处理

2023/03/19

在Java语言中， 将程序运行中发生的不正常情况都继承于Throwable类。(开发过程中的语法错误和逻辑错误不算)

![img](Lesson7%20%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86.assets/exception-hierarchy.png)

- **检查性异常（如IOException）：**通常与代码无关，最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。例如要打开一个不存在文件时，一个异常就发生了。
- **运行时异常（RuntimeException）：** 通常是在程序运行的过程中由于代码引起的，运行时异常是可能被程序员避免的异常。
- **错误（Error）：** 错误不是异常，而是脱离程序员控制的问题（如系统原因导致的错误）。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。错误一般不能被捕获，因为错误一旦发生，程序通常就会崩溃。



下面的表中列出了 Java 的运行时异常。

| **异常**                        | **描述**                                                     |
| :------------------------------ | :----------------------------------------------------------- |
| ArithmeticException             | 当出现异常的运算条件时，抛出此异常。例如，一个整数"除以零"时，抛出此类的一个实例。 |
| ArrayIndexOutOfBoundsException  | 用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引。 |
| ArrayStoreException             | 试图将错误类型的对象存储到一个对象数组时抛出的异常。         |
| ClassCastException              | 当试图将对象强制转换为不是实例的子类时，抛出该异常。         |
| IllegalArgumentException        | 抛出的异常表明向方法传递了一个不合法或不正确的参数。         |
| IllegalMonitorStateException    | 抛出的异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器而本身没有指定监视器的线程。 |
| IllegalStateException           | 在非法或不适当的时间调用方法时产生的信号。换句话说，即 Java 环境或 Java 应用程序没有处于请求操作所要求的适当状态下。 |
| IllegalThreadStateException     | 线程没有处于请求操作所要求的适当状态时抛出的异常。           |
| IndexOutOfBoundsException       | 指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出。 |
| NegativeArraySizeException      | 如果应用程序试图创建大小为负的数组，则抛出该异常。           |
| NullPointerException            | 当应用程序试图在需要对象的地方使用 `null` 时，抛出该异常     |
| NumberFormatException           | 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。 |
| SecurityException               | 由安全管理器抛出的异常，指示存在安全侵犯。                   |
| StringIndexOutOfBoundsException | 此异常由 `String` 方法抛出，指示索引或者为负，或者超出字符串的大小。 |
| UnsupportedOperationException   | 当不支持请求的操作时，抛出该异常。                           |

下面的表中列出了 Java 定义在 java.lang 包中的检查性异常类。

| **异常**                   | **描述**                                                     |
| :------------------------- | :----------------------------------------------------------- |
| ClassNotFoundException     | 应用程序试图加载类时，找不到相应的类，抛出该异常。           |
| CloneNotSupportedException | 当调用 `Object` 类中的 `clone` 方法克隆对象，但该对象的类无法实现 `Cloneable` 接口时，抛出该异常。 |
| IllegalAccessException     | 拒绝访问一个类的时候，抛出该异常。                           |
| InstantiationException     | 当试图使用 `Class` 类中的 `newInstance` 方法创建一个类的实例，而指定的类对象因为是一个接口或是一个抽象类而无法实例化时，抛出该异常。 |
| InterruptedException       | 一个线程被另一个线程中断，抛出该异常。                       |
| NoSuchFieldException       | 请求的变量不存在                                             |
| NoSuchMethodException      | 请求的方法不存在                                             |



### 捕获异常 try/catch关键字

使用 try 和 catch 关键字可以捕获异常。try/catch 代码块放在异常可能发生的地方。

```java
try {
   // 程序代码
}catch(Exception e) {
   //Catch 块
}
```

Catch 语句包含要捕获异常类型的声明。当保护代码块中发生一个异常时，try 后面的 catch 块就会被检查。如果发生的异常包含在 catch 块中，异常会被传递到该 catch 块。



下面的例子中声明有两个元素的一个数组，当代码试图访问数组的第四个元素的时候就会抛出一个异常。

```java
import java.io.*;

public class ExcepTest{
   public static void main(String args[]){
      try{
         int a[] = new int[2];
         System.out.println("Access element three :" + a[3]);
      }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Exception thrown  :" + e);
      }
      System.out.println("Out of the block");
   }
}
```

**发生异常后，程序还会继续执行吗？**

1. 若一段代码前有异常抛出，并且这个异常没有被捕获，这段代码将产生编译时错误「无法访问的语句」。
2. 若一段代码前有异常抛出，并且这个异常被try…catch所捕获，若此时catch语句中没有抛出新的异常，则这段代码能够被执行，否则，同第1条。



### 多重捕获块

一个 try 代码块后面跟随多个 catch 代码块的情况就叫多重捕获。

```java
try{
  // 程序代码
}catch(ExceptionType1 异常的变量名1){
  // 程序代码
}catch(ExceptionType2 异常的变量名2){
  // 程序代码
}catch(ExceptionType3 异常的变量名3){
  // 程序代码
}
```

可以在 try 语句后面添加任意数量的 catch 块，如上面的代码段包含了 3 个 catch块。

如果保护代码中发生异常，异常被抛给第一个 catch 块。

如果抛出异常的数据类型与 ExceptionType1 匹配，它在这里就会被捕获。

如果不匹配，它会被传递给第二个 catch 块。如此，直到异常被捕获或者通过所有的 catch 块。



### 抛出异常 throws/throw 关键字

**throw** 关键字用于在当前方法中抛出一个异常，当代码执行到某个条件下无法继续正常执行时，可以使用 **throw** 关键字抛出异常，以告知调用者当前代码的执行状态。

下面的代码中，在方法中判断 num 是否小于 0，如果是，则抛出一个 IllegalArgumentException 异常：

```java
public void checkNumber(int num) {
    try{
      	if (num < 0) {
    		throw new IllegalArgumentException("Number must be positive");
  		}  
    } catch(IllegalArgumentException e){
    	System.out.prinfln(e.getMessage()); 
    }
}
```



 **throws** 关键字用于在方法声明中指定可能会抛出的异常类型。当方法内部抛出指定类型的异常时，如果异常没被捕获，则需要将异常传递给调用该方法的代码，并在该代码中处理异常。

```java
public void checkNumber(int num) throws IllegalArgumentException {
	if (num < 0) {
   		throw new IllegalArgumentException("Number must be positive");
  	}  
}
```

一个方法可以声明抛出多个异常，多个异常之间用逗号隔开

```java
import java.io.*;

public class className
{
   public void withdraw(double amount) throws RemoteException, InsufficientFundsException {
       // Method implementation
   }
}
```



### finally关键字

无论是否发生异常，finally 代码块中的代码总会被执行。在 finally 代码块中，可以运行清理类型等收尾善后性质的语句。

```java
try {
  // 程序代码
} catch (ExceptionType1 异常的变量名1){
  // 程序代码
} catch (ExceptionType2 异常的变量名2){
  // 程序代码
} finally {
  // 程序代码
}
```



```java
public class ExcepTest{
  public static void main(String args[]){
    int a[] = new int[2];
    try{
       System.out.println("Access element three :" + a[3]);
    }catch(ArrayIndexOutOfBoundsException e){
       System.out.println("Exception thrown  :" + e);
    }
    finally{
       a[0] = 6;
       System.out.println("First element value: " +a[0]);
       System.out.println("The finally statement is executed");
    }
  }
}
```

注意事项：

- catch 不能独立于 try 存在。
- finally 不能独立于 try 存在。
- try 代码后不能既没 catch 块也没 finally 块。



### 声明自定义异常

在 Java 中你可以自定义异常。编写自己的异常类时需要所有异常都必须是 Exception的子类。

```java
import java.io.*;
 
//自定义银行账户异常类，继承Exception类
public class InsufficientFundsException extends Exception {
  //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
  private double amount;
    
  public InsufficientFundsException(double amount) {
    this.amount = amount;
  } 
    
  public double getAmount() {
  	return amount;
  }
}
```

下面的 CheckingAccount 类中包含一个 withdraw() 方法抛出一个 InsufficientFundsException 异常

```java
import java.io.*;
 
//此类模拟银行账户
public class CheckingAccount
{
  // 余额
   private double balance;
    
  //方法：存钱
   public void deposit(double amount) {
      balance += amount;
      System.out.println("balance: " + balance);
   }
    
  //方法：取钱
   public void withdraw(double amount) throws InsufficientFundsException {
      if(amount <= balance) {
         balance -= amount;
         System.out.println("balance: " + balance);
      } else {
         double needs = amount - balance;
         throw new InsufficientFundsException(needs);
      }
   }
}
```

