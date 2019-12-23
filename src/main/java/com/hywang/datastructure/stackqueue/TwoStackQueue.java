package com.hywang.datastructure.stackqueue;

import java.util.Queue;
import java.util.Stack;

/**
 * 两个栈 构成一个队列
 */
public class TwoStackQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new Stack<Integer>(),new Stack<Integer>());
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        Integer peek = myQueue.peek();
        System.out.println(peek);

        Integer poll = myQueue.poll();
        System.out.println(poll);


    }
}

class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue(Stack<Integer> pushStack, Stack<Integer> popStack) {
        this.pushStack = pushStack;
        this.popStack = popStack;
    }

    public void add(Integer item) {
        pushStack.push(item);
    }

    public Integer poll() {
        if(pushStack.isEmpty() && popStack.isEmpty()){
            throw new  RuntimeException("队列为null");
        }else if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
    public Integer peek(){
        if(pushStack.isEmpty() && popStack.isEmpty()){
            throw new  RuntimeException("队列为null");
        }else if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

}
