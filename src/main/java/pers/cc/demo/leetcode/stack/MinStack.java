package pers.cc.demo.leetcode.stack;

import java.util.Stack;

// 最小栈
//已解答
//中等
//相关标签
//premium lock icon
//相关企业
//提示
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//实现 MinStack 类:
//
//MinStack() 初始化堆栈对象。
//void push(int val) 将元素val推入堆栈。
//void pop() 删除堆栈顶部的元素。
//int top() 获取堆栈顶部的元素。
//int getMin() 获取堆栈中的最小元素。
//
//
//示例 1:
//
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
public class MinStack {

    Stack<Integer> stk = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        stk.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        int x = stk.pop();
        if(!min.isEmpty() && min.peek() == x){
            min.pop();
        }
    }

    public int top() {
        if(!stk.isEmpty()){
            return stk.peek();
        } else {
            return 0;
        }
    }

    public int getMin() {
        if(!min.isEmpty()){
            return min.peek();
        } else {
            return 0;
        }
    }


}
