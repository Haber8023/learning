package lesson2.part4;

import java.util.ArrayList;
import java.util.List;

public class Loop {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[5];

        int[][] c = {{1, 2, 3},
                     {4, 5, 6}};

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);

        // while
        int index = 3;
        while(index < a.length){
            System.out.println(a[index]);
            index++;
        }

        // do while
        int count = 1;
        index = 3;
        do{
            System.out.println("count: " + count++);
            index--;
        }while (index > 0);

        // for
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // foreach 遍历集合类
        for (Integer number : list) {
            System.out.println(number);
        }

        for(int i =0; i<c.length; i++){
            for(int j=0; j<c[0].length; j++){
                System.out.println(c[i][j]);
            }
        }

        for(int i =0; i<c[0].length; i++){
            for(int j=0; j<c.length; j++){
                System.out.println(c[j][i]);
            }
        }
    }
}
