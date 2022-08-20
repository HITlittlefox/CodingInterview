package ____Offer_30___min_____LCOF;

import java.util.Stack;

// @algorithm @lc id=100302 lang=java 
// @title bao-han-minhan-shu-de-zhan-lcof
class MinStack {
    Stack<Integer> A, B;
    // 数据栈 A ： 栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
    // 辅助栈 B ： 栈 B 中存储栈 A 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min()
    // 函数只需返回栈 B 的栈顶元素即可。

    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        // 默认执行A.pop()
        // 如果B要弹出的数和A刚刚弹出的数相同,则B也弹出
        // 否则的话,B要弹出的东西,是在小于A弹出数的,没必要弹出
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
