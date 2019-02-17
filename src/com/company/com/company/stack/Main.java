package com.company.com.company.stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args){
//        ArrayStack<Integer> stack = new ArrayStack<>();
//
//        for(int i = 0; i< 5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack.peek());
//        System.out.println(stack.getSize());
//        System.out.println(stack.isEmpty());

        System.out.println(isVaild("({[]})"));
    }



    public static boolean isVaild(String s){
        java.util.Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i< s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                System.out.println(topChar);
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;

            }
        }
        return stack.isEmpty();
    }
}
