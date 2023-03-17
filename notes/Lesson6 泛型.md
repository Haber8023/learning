# 泛型

2023/03/17

### 泛型的概念

**泛型的本质是参数化类型**，即给类型指定一个参数，然后在使用时再指定此参数具体的值，那样这个类型就可以在使用时决定了。

这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。

 

### 泛型方法

```JAVA
public <泛型类型> 返回类型 方法名（泛型类型 变量名） {
  
}
```



```java
public class GenericMethod{
	/**
     *
     * @param t 传入泛型的参数
     * @param <T> 泛型的类型
     * @return T 返回值为T类型
     * 说明：
     *   1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *   2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *   3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *   4）此处T可以随便写为任意标识，但最好满足行业的命名规范。
     */

    public <T> T genercMethod(T t){
        System.out.println(t.getClass());
        System.out.println(t);
        return t;
    }
 
 
public static void main(String[] args) {
    GenericsClassDemo<String> genericString  = new GenericsClassDemo("helloGeneric"); //这里的泛型跟下面调用的泛型方法可以不一样。
    String str = genericString.genercMethod("hello");//传入的是String类型,返回的也是String类型
    Integer i = genericString.genercMethod(123);//传入的是Integer类型,返回的也是Integer类型
	}
}
```

**泛型类型的命名规范**

1. T：Java 自带的类
2. E：集合中元素的类型 element
3. K：Key（键）
4. V：Value（值）
5. N：Number（数值类型）



### 泛型类

定义泛型类，在类名后添加一对尖括号，并在尖括号中填写类型参数，参数可以有多个，多个参数使用逗号分隔

```java
public class 类名 <泛型类型1,...> {  
 
}
```



```java
public class GenericClass<T> {
	private T value;
 
	public GenericClass(T value) {
    	this.value = value;
	}
 
	public T getValue() {
    	return value;
	}
 
	public void setValue(T value) {
    	this.value = value;
	}
    
	public static void main(String[] args){
	GenericClass<String> name = new GenericClass<>("abc");
	System.out.println(name.getValue());
 
	GenericClass<Integer> number = new GenericClass<>(123);
	System.out.println(number.getValue());
    }
}
```



### 泛型接口

```java
public interface GenericInterface<T> {
	void show(T value);}
}
 
public class StringShowImpl implements GenericInterface<String> {
 
	@Override
	public void show(String value) {
	System.out.println(value);
	}
}
 
public class NumberShowImpl implements GenericInterface<Integer> {
	@Override
	public void show(Integer value) {
	System.out.println(value);
	}
}
```



### 泛型通配符<?>

```java
// 1：表示类型参数可以是任何类型
public static void getElement(Collection<?> coll){
        // ?只能用于集合类中的元素，代表任意类型
        // 此时coll可以是任何类型
    }
 
// 2：表示类型参数必须是A或者是A的子类
public static void getSonElement(Collection<? extends Circle> coll){
        // ?只能用于集合类中的元素，代表任意类型
        // 此时coll中只能包含Circle的子类对象
    }
 
// 3: 表示类型参数必须是A或者是A的超类型
public static void getFatherElement(Collection<? super Son> coll){
        // ?只能用于集合类中的元素，代表任意类型
        // 此时coll中只能包含Son的父类对象
    }
```

