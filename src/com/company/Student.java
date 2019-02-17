package com.company;

public class Student {
    private String name;
    private int studentScore;

    public Student(String studentName, int studentScore){
        this.name = studentName;
        this.studentScore = studentScore;
    }

    public static void main(String[] agrs){
        Array<Student> arr = new Array<>();

        arr.addLast(new Student("zhangsan",88));
        arr.addLast(new Student("lisi",99));
        System.out.println(arr.toString());
    }
}
