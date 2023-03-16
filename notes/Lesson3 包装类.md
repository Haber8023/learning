# 包装类

2023/03/16

### 8种基本数据类型对应的包装类型名

| 基本数据类型 | 包装类型  |
| :----------: | :-------: |
|     byte     |   Byte    |
|    short     |   Short   |
|     int      |  Integer  |
|     long     |   Long    |
|    float     |   Float   |
|    double    |  Double   |
|   boolean    |  Boolean  |
|     char     | Character |



### 手动装箱/手动拆箱

```java
public class IntegerTest {
    public static void main(String[] args) {
    // 123这个基本数据类型，进行构造方法的包装达到了：基本数据类型向引用数据类型的转换。
    // 基本数据类型 -(转换为)->包装类（装箱）
    Integer i = new Integer(123);

    // 将包装类--(转换为)-> 基本数据类型（拆箱）
    int y = i.intValue();
    System.out.println(y); //123
	}
}
```


### 自动装箱/自动拆箱

- 自动装箱：**基本数据类型**自动转换成**包装类**。
- 自动拆箱：**包装类**自动转换成**基本数据类型**

```java
public class IntegerTest {
    public static void main(String[] args) {
        // 123是基本数据类型
        // x是包装类型
        // 基本数据类型 --(自动转换)--> 包装类型：自动装箱
        Integer i = 123; // 等同于：Integer i = new Integer(123);
        System.out.println(i);
        
    	// i是包装类型
    	// y是基本数据类型
    	// 包装类型 --(自动转换)--> 基本数据类型：自动拆箱
    	int y = i;
    	System.out.println(y);
	}
}
```


### 包装类常量

| 常量属性  |
| --------- |
| MAX_VALUE |
| MIN_VALUE |

**注意：** **Byte、Short、Integer、Long、Float、Double都有。**



### 包装类方法

##### Integer方法

| **方法名**                          | **作用**                                                     |
| ----------------------------------- | ------------------------------------------------------------ |
| static Integer decode(String nm)    | 将String转成Integer                                          |
| static int compare(int x, int y)    | 比较两个数是否相等；相等返回0；前大后小返回1；后大前小返回-1 |
| static int signum(int i)            | 符号函数；负数返回-1；正数返回1；0返回0                      |
| static String toBinaryString(int i) | 将i转成二进制                                                |
| static String toHexString(int i)    | 将i转成十六进制                                              |
| static String toOctalString(int i ) | 将i转成八进制                                                |
| 常用方法                            |                                                              |
| static int parseInt(String s)       | 字符串转int                                                  |
| static Integer valueOf(String s)    | 字符串转Integer                                              |
| String toString()                   | Integer转String                                              |
| boolean equals(Object obj)          | 判断两个Integer是否相等                                      |

**注意：** **Byte、Short、Long、Float、Double、Boolean照葫芦画瓢，方法差不多相同。**



```java
public class IntegerTest{
    public static void main(String[] args) {
        Integer d = Integer.decode("123");
        System.out.println(d);//自动拆箱 123    
		Integer a = 100;
    	Integer b = 100;

    	int res1 = Integer.compare(a, b);
    	System.out.println(res1);//0
    	res1 = Integer.compare(-a, b);
    	System.out.println(res1);//-1
    	res1 = Integer.compare(a, -b);
    	System.out.println(res1);//1

    	System.out.println(a.equals(b));//true

    	int i = Integer.parseInt("123");
    	System.out.println(i);//123

    	System.out.println(Integer.signum(-123));//-1
    	System.out.println(Integer.signum(123));//1
    	System.out.println(Integer.signum(0));//0

    	System.out.println(Integer.toBinaryString(10));//1010
    	System.out.println(Integer.toOctalString(10));//12
    	System.out.println(Integer.toHexString(10));//a
	
    	String s = Integer.toString(123);
    	System.out.println(s);//123

    	Integer int1 = Integer.valueOf("123");
    	System.out.println(int1);//123
	}
}
```


##### Character方法

| 方法名                                    | 作用                                                         |
| ----------------------------------------- | ------------------------------------------------------------ |
| char charValue()                          | 将Character转成char                                          |
| int compareTo(Character anotherCharacter) | 判断两个Character是否相等；相等返回0；前大后小返回1；后大前小返回-1 |
| 常用方法                                  |                                                              |
| boolean equals(Object obj)                | 判断两个Character是否相等                                    |
| String toString()                         | 将Character转成String                                        |
| static boolean isDigit(char ch)           | 判断ch是不是数字                                             |
| static boolean isLetter(char ch)          | 判断ch是不是字母                                             |
| static boolean isLetterOrDigit(char ch)   | 判断ch是不是字母或数字                                       |
| static boolean isLowerCase(char ch)       | 判断ch是不是小写字母                                         |
| static boolean isUpperCase(char ch)       | 判断ch是不是大写字母                                         |
| static boolean isSpaceChar(char ch)       | 判断ch是不是空格                                             |
| static Character valueOf(char c)          | 将char转成Character                                          |



```java
public class CharacterTest{
    public static void main(String[] args) {
        Character c = 'a';
    	char res1 = c.charValue();
    	System.out.println(res1);//a

    	Character a = 'a';
    	Character b = 'b';
    	System.out.println(a.compareTo(b));//-1

    	System.out.println(a.equals(b));//false

    	System.out.println(Character.isDigit('1'));//true

    	System.out.println(Character.isLetter('a'));//true

    	System.out.println(Character.isLetterOrDigit('1'));//true
    	System.out.println(Character.isLetterOrDigit('a'));//true

    	System.out.println(Character.isLowerCase('a'));//true

    	System.out.println(Character.isUpperCase('A'));//true

    	System.out.println(Character.isSpaceChar(' '));//true

    	System.out.println(c.toString());//"a"

    	System.out.println(Character.valueOf('c'));//c
	}
}
```
