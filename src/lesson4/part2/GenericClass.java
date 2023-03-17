package lesson4.part2;

import lesson1.part2.Circle;
import lesson1.part3.Son;
import lesson4.part1.DateUtils;
import lesson4.part1.FinalClass;

import java.util.*;

public class GenericClass <T extends List, K>{

    public GenericClass(T t, K k){
        this.variable = k;
    }

    public K variable;

    public T print(T a){
        System.out.println(a);
        return a;
    }

    public T method2(T a){
        System.out.println(a);
        return a;
    }

    public static void getElement(Collection<?> coll){
        // ?只能用于集合类中的元素，代表任意类型
        // 此时coll中只能包含Circle的子类对象
    }

    public static void getSonElement(Collection<? extends Circle> coll){
        // ?只能用于集合类中的元素，代表任意类型
        // 此时coll中只能包含Circle的子类对象
    }

    public static void getFatherElement(Collection<? super Son> coll){
        // ?只能用于集合类中的元素，代表任意类型
        // 此时coll中只能包含Circle的父类对象
    }

    /**
     * 1. T: Java自带的类型 type
     * 2. E: 集合中的元素 Element
     * 3. K: Key
     * 4. V: Value
     * 5. N: Number
     */
    // 泛型方法、泛型类、泛型接口
    public static void main(String[] args) {
        GenericClass genericClass = new GenericClass(new ArrayList(), "asd");
        System.out.println(genericClass.variable);
        genericClass.print(new ArrayList());
        genericClass.print(new LinkedList());

        GenericClass genericClass2 = new GenericClass(new ArrayList(), 123); // Integer
        System.out.println(genericClass2.variable);
    }
}
// 华为芯片设计能力 没有人愿意代工了 光刻机 soc 台积电（搬到美国去了）3nm、三星5nm  14nm量产