package faceTest;

import java.util.*;

/*
ArrayList
LinkedList

 */
public class Test1 {


    public static void main(String[] args) {
        Integer[] a = {1, 2, 4, 5, 7, 8, 9, 90, 24};
        List<Integer> ints = Arrays.asList(a);
        for (int i=0;i< ints.size();i++) {
            System.out.println(ints.get(i));
        }


        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
