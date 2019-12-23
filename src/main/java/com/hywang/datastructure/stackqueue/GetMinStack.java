package com.hywang.datastructure.stackqueue;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的功能上，再实现返回栈中最小元素
 */
public class GetMinStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(new Stack(),new Stack());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(-1);

        Integer min = myStack.getMin();
        System.out.println(min);
        Integer pop = myStack.pop();
        System.out.println(pop);

    }
}

class MyStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MyStack(Stack stack, Stack minStack) {
        this.stack = stack;
        this.minStack = minStack;
    }
    public Integer getMin(){
        if (minStack.isEmpty()){
            throw new RuntimeException("最小栈不为空");
        }
        return minStack.peek();
    }
    public Integer pop(){
        if(stack.isEmpty()){
            throw  new RuntimeException("栈不能为null");
        }
        Integer pop = stack.pop();
        if(getMin() == pop){
            minStack.pop();
        }
        return pop;
    }
    public MyStack push(Integer i){
        stack.push(i);
        if(minStack.isEmpty()){
            minStack.push(i);
        }else {
            Integer pop = minStack.peek();
            if(i<pop){
                minStack.push(i);
            }
        }
        return new MyStack(stack,minStack);
    }
}


class MyStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MyStack2(Stack stack, Stack minStack) {
        this.stack = stack;
        this.minStack = minStack;
    }
    public Integer getMin(){
        if (minStack.isEmpty()){
            throw new RuntimeException("最小栈不为空");
        }
        return minStack.peek();
    }
    public MyStack2 push(Integer i){
        if(minStack.empty()){
            minStack.push(i);
        }else if(i< getMin()){
            minStack.push(i);
        }else {
            Integer peek = minStack.peek();
            minStack.push(peek);
        }
        stack.push(i);
        return new MyStack2(stack,minStack);
    }
 }