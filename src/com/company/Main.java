package com.company;

public class Main {

    public static void main(String[] args){

        Array<Integer> arr = new Array(20);

        for(int i = 0; i < arr.getCapacity() - 1;i++){
            arr.addLast(i);
        }

        arr.add(1,100);
        arr.addLast(222);
        System.out.println(arr.getCapacity());
        //        int ret = arr.remove1(1);
       // System.out.println(ret);
        //arr.removeFirst();
        //arr.removeLast();

       // boolean b = arr.removeElement(18);
       // System.out.println(b);
        System.out.println(arr.get(19));
        System.out.println(arr.toString());
    }
}
