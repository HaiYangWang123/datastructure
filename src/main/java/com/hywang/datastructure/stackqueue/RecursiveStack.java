package com.hywang.datastructure.stackqueue;

import org.omg.SendingContext.RunTime;

import java.util.Stack;

/**
 * 递归函数 和 栈 操作一个 逆序栈
 *
 * 一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1将这个栈转置后，从栈顶到栈底分别为1,2,3,4,5
 * 只能使用递归函数 和栈，不能使用其他数据结构
 */
public class RecursiveStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
     /*   while(!stack.isEmpty()){
            Integer pop = stack.peek();
            System.out.println(pop);
        }*/
        reverse(stack);
         while(!stack.isEmpty()){
            Integer pop = stack.pop();
            System.out.println(pop);
        }

    }

    public static int getAndRemoveLast(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }else {
            int last = getAndRemoveLast(stack);
            stack.push(pop);
            return last;
        }

    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
           return;
        }
        int last = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(last);
    }

}
