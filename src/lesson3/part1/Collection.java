package lesson3.part1;

import lesson1.part3.Son;

import java.util.*;

/**
 * 集合类
 */
public class Collection {
    public static void main(String[] args) {
        // 定长数组
        int[][] arr = new int[3][4];

        // 动态数组 查找比较快 修改比较慢
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i); // 加在arrayList的最后面 0~99
        }
        System.out.println(arrayList.get(3)); // 获取元素
        arrayList.remove(arrayList.size() - 1); //移除最后一个数字
        System.out.println("arr length: " + arrayList.size());
        System.out.println(arrayList.get(arrayList.size() - 1));

        // 双向链表 查找比较慢 修改比较快
        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("c");
        linkedList.add("d");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println();

        // hash算法 不保证元素的顺序
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(123);
        hashSet.add(89);
        hashSet.add(122);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(12);
        hashSet.add(0);
        for (Integer ss : hashSet) {
            System.out.println(ss);
        }
        System.out.println();

        // TreeSet算法 保证顺序
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(123);
        treeSet.add(89);
        treeSet.add(122);
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(12);
        treeSet.add(0);
        for (Integer ss : treeSet) {
            System.out.println(ss);
        }

        // HashMap
        Map<String, Son> hashMap = new HashMap<>();
        Son son1 = new Son();
        son1.setAge(10);
        Son son2 = new Son();
        son2.setAge(20);
        hashMap.put("erzi1", son1);
        hashMap.put("erzi2", son2);
        Son son = hashMap.get("erzi1");
        System.out.println(son.getAge());
        System.out.println(hashMap.get("erzi2").getAge());

        // "dataBaseUrl": "wwww.shujuku.com" , "webUrl" : "www.web.com"
        Map<String, String> urlMap = new HashMap<>();
        urlMap.put("dataBaseUrl", "wwww.shujuku.com");

        String dataBaseUrl = urlMap.get("dataBaseUrl");
        hashMap.size();
        Son son3 = hashMap.remove("erzi1");
        System.out.println(hashMap.size());
        Son son4 = hashMap.get("erzi1");
        if (son4 == null) {
            System.out.println("is null");
        }
        hashMap.containsKey("erzi1");
        hashMap.containsKey("erzi2");
        hashMap.containsValue(son2);
        hashMap.isEmpty();

        // 集合工具类
        // 对集合排序
        Collections.sort(arrayList);
        // 翻转集合
        Collections.reverse(arrayList);
        for (Integer i : arrayList) {
            System.out.printf(i.toString() + " ");
        }
    }
}
