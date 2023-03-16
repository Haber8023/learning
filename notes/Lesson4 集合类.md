# 集合类

2023/03/16

![在这里插入图片描述](Lesson4%20%E9%9B%86%E5%90%88%E7%B1%BB.assets/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwMDAxNjY5,size_16,color_FFFFFF,t_70.png)

java.util 包中提供了一些集合类。提到集合类不难想到数组，集合类与数组的不同之处是，数组的长度是固定的，集合的长度是可变的；数组用来存放基本类型的数据，集合用来存放对象的引用。常用的集合有 List 集合、Set 集合和 Map 集合，其中 List 与 Set 继承了 Collection 接口，各接口还提供了不同的实现类。



- **Map 接口**存储一组键值对，提供key（键）到value（值）的映射。

- **List 接口**存储一组不唯一，有序（插入顺序）的对象。

  能够通过索引(元素在List中位置，类似于数组的下标)来访问 List 中的元素，第一个元素的索引为 0，而且允许有相同的元素。

- **Set 接口**存储一组唯一，无序的对象。



### List集合

##### ArrayList 动态数组

```java
import java.util.ArrayList;

public class Muster {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
    	list.remove(1); // 将指定索引位置的元素删除，集合的索引从0开始

    // 遍历集合
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    	}
	}
}
```
ArrayList 可以存放 null。
ArrayList 本质上就是一个数组。
ArrayList 区别于数组的地方在于能够自动扩展大小。



##### LinkedList 双向链表

```java
import java.util.LinkedList;

public class Muster {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
    	list.addFirst("d"); // 在头部添加元素
    	list.addLast("e"); // 在尾部添加元素

    // 遍历集合
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    	}
	}
}
```
LinkedList 本质上是一个双向链表，通过一个 Node 内部类实现的这种链表结构。
LinkedList 可以存放 null。
LinkedList 跟 ArrayList 相比较，在删除和增加等操作上性能好，而 ArrayList 在查询的性能上好。



### Set集合

##### HashSet 不保证元素的顺序

```java
import java.util.HashSet;

public class Muster {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");    
		set.add("a"); // 重复的元素不会被添加
    	set.remove("b"); // 删除元素

    	// 可以使用 for-each 来迭代 HashSet 中的元素
    	for (String i : set) {
        	System.out.println(i);
    	}
	}
}
```


##### TreeSet 保证元素的顺序

```java
import java.util.TreeSet;

public class Muster {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>();
        set.add("a");
        set.add("c");
        set.add("b");
        
    	// TreeSet 实现了自动排序功能
    	for (String i : set) {
        	System.out.println(i);
    	}
    }
}
```


### Map集合

Map 集合没有继承 Collection 接口，其提供的是 key 到 value 的映射。Map 中不能包含相同的 key，每个 key 只能映射一个 value。

##### HashMap 性能好，能存储null值

```java
    
import java.util.HashMap;

public class Muster {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "c");
        map.put(3, "b");map.remove(2); // 删除指定 key 对应的键值对

    	// 输出 key 和 value
    	for (Integer i : map.keySet()) {
        	System.out.println(i + " : " + map.get(i));
        }

    	// 返回所有 value 值
    	for (String value : map.values()) {
        	// 输出每一个 value
        	System.out.println(value);
    	}
    }
}
```


##### TreeMap 性能较HashMap较差，不能存储null值，一般不使用



### Collections集合类自带工具

```java
import java.util.ArrayList;
import java.util.Collections;

public class Muster {
    public static void main(String[] args) {ArrayList list = new ArrayList();

    list.add(3);
    list.add(-2);
    list.add(9);
    list.add(5);
    list.add(-1);
    list.add(6);

    System.out.println(list); // [3, -2, 9, 5, -1, 6]

    Collections.reverse(list);  // 集合元素的次序反转
    System.out.println(list);   // [6, -1, 5, 9, -2, 3]

    Collections.sort(list);     // 排序：按照升序排序
    System.out.println(list);   // [-2, -1, 3, 5, 6, 9]
                                            
    Collections.swap(list, 2, 5);   // 根据下标进行交换
    System.out.println(list);   // [-2, -1, 9, 5, 6, 3]
                                            
    Collections.rotate(list, 2);    // 后两个整体移动到前边
    System.out.println(list);   // [6, 3, -2, -1, 9, 5]                
                                            
    Collections.shuffle(list);  // 随机排序
    System.out.println(list);   // 每次输出的次序不固定
	}
}                                     
```





