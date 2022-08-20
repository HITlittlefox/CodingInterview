// @algorithm @lc id=100306 lang=java 
// @title zhan-de-ya-ru-dan-chu-xu-lie-lcof

package ____Offer_31___________LCOF;

import java.util.Stack;

// 入栈操作： 按照压栈序列的顺序执行。
// 出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int temp : pushed) {
            stack.push(temp);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}