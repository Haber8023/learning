# Java基础

2023/03/15

### part1 输入输出

##### 1. 输入

```java
// 这是一个重要的工具类，顾名思义，一个扫描仪
import java.util.Scanner;

public class Addition1 {
    public static void main(String[] args) {
        
        // create a Scanner called sc
        Scanner sc = new Scanner(System.in);
        
        // get the two integers by the Scanner--"sc"
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // add them together
        int c = a + b;
        
        // show the result
        System.out.println(c);
        
        double y = sc.nextDouble();
		float z = sc.nextFloat();
		String s1 = sc.next();
		String s2 = sc.nextLine();
        
        // usually we close it after all input operations
        sc.close();
    }
}
```



##### 2. 输出

```java
System.out.println("Nice to meet you!");

int hour = 5;
int grade = 3;
System.out.printf("I slept %d hours a day on average when I was a Grade %d student in SUSTech.", hour, grade);
```

在上面的字符串直接量中的`%d`叫做**格式符**，它们可以被替换为特定的**整型**变量值。字符串中出现的`%d`会依次被替换为这个字符串之后的变量，比如第一个`%d hours`的`%d`就会被字符串后的第一个变量`hour`代替，第二个`%d student`的`%d`则会被第二个变量`grade`代替。如果是其他类型的变量，则需要其他的格式符：

- float, double: %f
- char: %c
- byte, short, int, long: %d
- String: %s



```java
System.out.print("Hello\t\\(\"QwQ\")/\n");
System.out.println("\u6211\u7231\u004a\u0061\u0076\u0061");
```

 字符串的直接量要用双引号"括起来，可是如果这个字符串本身里有双引号出现怎么办呢，为了防止歧义，我们使用`\"`表示这个`"`并不是表示字符串直接量的开头或结束，而**是字符串的内容**。

其他常用的还有：

- `\n`：换行
- `\t`：制表符，与tab键功能相同
- `\\`：转义了转义字符本身，表示这里我就是想打印出一个反斜杠，告诉编译器他是字符串的内容而不是作为转义字符使用的
- `\uxxxx`：Unicode码，实质上是一个数字到字符的映射，`xxxx`是一个16进制数，`\uxxxx`就表示这个数对应的字符（有兴趣的也可以搜搜ASCII）



### part2 操作符及其优先级

##### 1 基本操作符

- `+-*/`：加减乘除
- `=`：**赋值**，将等号右边的值赋值给左边的变量，注意这个等号左边必须是一个变量哦！

除此之外，我们还有比较常用的：

1. **取余**：`%`

   用前一个操作数去除以后一个操作数，将余数作为结果返回，如5 % 2 = 1，27 % 7 = 6

2. **自增和自减操作符**：`++`和`--`

   这是一个一元操作符，意思是它**只能有一个操作数**。自增操作符可以让这个操作数的值加上一个一，自减操作符则相反，会让其减一。如执行了`x++;`和`y--;`之后x的值会+1而y的值会-1。

   可惜这东西没看起来这么简单，它甚至有两种用法，前缀用法和后缀用法：

   ```java
   int x1 = 1, x2 = 1;
   int y = x1++; // 后缀用法
   int z = ++x2; // 前缀用法
   System.out.printf("x1 = %d, x2 = %d\n", x1, x2);
   System.out.printf("y = %d, z = %d", y, z);
   ```

   输出：

   ```
   x1 = 2, x2 = 2
   y = 1, z = 2
   ```

    从输出的第一行我们可以发现，无论是前缀还是后缀用法，操作数`x1`和`x2`最终都加了1，变成了2。

   但是，从输出的第二行我们可以发现，这东西的结果是不同的。后缀用法中，结果`y`为操作数`x1`的原值；前缀用法中，结果`z`为操作数`x2`在自增后的新值。

   等价于分开的写法：

   ```java
   int y = x1;
   x1++;
   x2++;
   int z = x2;
   ```

   

3. **组合赋值操作符**：`+=`、`-=`、`*=`、`/=`、`%=`

   这个东东有点像自增操作符的升级版，不过现在咱们不仅限于可以+1或者-1，我可以加任意的数了。如`x += 233;`就表示`x = x + 233;`，后四种操作符和`+=`同理。当我们希望对一个变量本身进行值的累加或累乘等的时候，可以考虑使用这些个操作符哦！

   

- **比较操作符**：比较两边的数或者变量，结果是一个布尔值（true或false）。条件成立时，结果为**true**，不成立时结果为**false**。如假设x为666，`x == 666`结果为true，而`x <= 0`结果为false。（在课上这里可以讲讲char类型的比较）比较操作符主要有以下六种：
  - `>`：**大于**符号！左边的操作数比右边的大时为true，否则为false
  - `<`：**小于**符号！左边的操作数比右边的小时为true，否则为false
  - `>=`：**大于等于**咯，不多解释啦
  - `<=`：**小于等于**咯，不多解释啦
  - `==`：**等于**符号！左右两操作数相等时为true，否则为false。注意这个是两个等号连在一起的哟，千万不要和单走一个等于号的赋值操作符搞混了！
  - `!=`：**不等于**符号！左右两操作数不相等时为true，否则为false
- **逻辑操作符**：用于计算两个布尔值
  - `&&`：“**逻辑且**”操作符，当前后两个布尔值（可以理解为事件）的真值都为true时结果为true，否则为false
  - `||`：“**逻辑或**”操作符，当前后两个布尔值的真值都为false时结果为false，否则为true



### part3 条件判断

### 1 if

我们直接来看`if`判断语句块的代码：

```java
if (condition) { // condition为条件
    statements; // statements为相应条件成立时需要执行的语句（组）
    ...
}
```

- `condition`：本质上是一个布尔表达式，其实就是一个条件，诸如`radius < 0`、`GPA >= 3.7 && GPA < 3.8`等
- `statements`：相对应括号条件成立时，所需要的执行的语句

执行效果最终表现为：当condition这个地方的条件成立（值为true）时，才执行后面的语句块（大括号括起来的地方）里的statements。



### 2 if-else

有的时候我们希望condition不成立的时候，也去做一些特定的事情。那么我们就可以用到`if-else`语句块了：

```java
if (condition) {
    // do something
    ...
}
else {
    // do something else
    ...
}
```



### 3 else if

当某个条件进入else分支时，你想要再次进行判断，就可以使用方便的`else if`，而不是再在else块内写一个if块：

```java
if (condition1) {
    ...
}
else if (condition2) {
    ...
}
else {
    ...
}
```



### 4 switch

switch语句可以**根据变量的值来选择下一步执行哪一句代码**。

下面的代码想要根据month的值，来输出相应月份对应的季节：

```java
switch(month){
    case 3:
    case 4:
    case 5: System.out.println("Spring"); break;
    case 6:
    case 7:
    case 8: System.out.println("Summer"); break;
    case 9:
    case 10:
    case 11: System.out.println("Autumn"); break;
    case 12:
    case 1:
    case 2: System.out.println("Winter"); break;
    default: System.out.println("Invalid month!"); // run default branch if there's no same value of month
}
```

当程序执行到这里时，`switch`会根据其后小括号中变量`month`的值，选择应该从哪里执行，而`break;`语句，会结束`switch`块，直接去执行这之后的代码。我写到这里的时候正好是十一假期，那我们就假设`month`的值为10。那么程序在经过第一行的判断后，就会找`case 10`的那一行，也就是第9行。但是第九行没有语句，也没有`break;`，所以程序会继续向下执行第十行的语句，打印出`Autumn`字样，然后出现了`break;`，于是直接结束了`switch`块。更细节地，`month`为3、4、5时会输出`Spring`；`month`为6、7、8时会输出`Summer`；`month`为9、10、11时会输出`Autumn`；`month`为12、1、2时会输出`Winter`；若都不是，则输出`Invalid month!`。

#### 注意事项：

1. 括号内的变量值只可以是**char、byte、short、int或者String**型值
2. case后的值必须与括号中的变量的类型相同
3. default语句块和break语句都是可加可不加的，重点在于你的逻辑