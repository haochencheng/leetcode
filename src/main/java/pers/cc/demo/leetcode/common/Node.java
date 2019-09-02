package pers.cc.demo.leetcode.common;

/**
 * @description:
 * @author: haochencheng
 * @create: 2019-09-02 08:57
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(Integer val) {
        this.val = val;
    }


    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};