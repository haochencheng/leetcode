package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

import java.util.Random;

//380. O(1) 时间插入、删除和获取随机元素
//中等
//相关标签
//premium lock icon
//相关企业
//实现RandomizedSet 类：
//
//RandomizedSet() 初始化 RandomizedSet 对象
//bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
//bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
//int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
//你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
public class l_380 {

    private final Node head;
    private Node last;
    private int size = 0;


    public l_380() {
        head = new Node();
    }

    static class Node {

        private Integer val;
        private Node next;

        Node() {

        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    public boolean insert(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.val != null && temp.val == val) {
                return false;
            }
            temp = temp.next;
        }
        if (last == null) {
            last = new Node(val, new Node());
            head.next = last;
        } else {
            last.next = new Node(val, new Node());
            last = last.next;
        }
        size++;
        return true;
    }

    public boolean remove(int val) {
        Node temp = head;
        Node prev = head;
        while (temp != null) {
            if (temp.val != null && temp.val == val) {
                prev.next = temp.next;
                size--;
                if (size == 0) {
                    last = null;
                }
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }

    public int getRandom() {
        int random = new Random().nextInt(size);
        Node temp = head;
        for (int i = 0; i < random; i++) {
            if (temp.next != null) {
                temp = temp.next;
            }
        }
        return temp.val==null?last.val:temp.val ;
    }

    public static void main(String[] args) {
//        l_380 obj = new l_380();
//        boolean param_1 = obj.insert(1);
//        boolean param_2 = obj.remove(2);
//        int param_3 = obj.getRandom();
//        Assert.assertEquals(true, param_1);
//        Assert.assertEquals(param_2, false);
//        Assert.assertNotNull("", param_3);
        l_380 obj1 = new l_380();
        obj1.insert(0);
        obj1.remove(0);
        obj1.insert(-1);
        obj1.remove(0);
        int random = obj1.getRandom();
        System.out.println(random);
    }


}
