// @algorithm @lc id=100273 lang=java 
// @title yong-liang-ge-zhan-shi-xian-dui-lie-lcof

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    Deque<Integer> in;
    Deque<Integer> out;

    public CQueue() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            return -1;
        } else {
            return out.pop();
        }
    }
}