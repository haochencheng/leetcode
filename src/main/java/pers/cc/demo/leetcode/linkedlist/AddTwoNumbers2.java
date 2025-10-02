package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 445. 两数相加 II
 * <p>
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-15 12:27
 **/
public class AddTwoNumbers2 {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(7,2,4,3));
//        ListNode listNode1 = ListNode.fillNode(Arrays.asList(5,6,4));
//        ListNode listNode = ListNode.fillNode(Arrays.asList(5));
//        ListNode listNode1 = ListNode.fillNode(Arrays.asList(5));
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1));
//        ListNode listNode1 = ListNode.fillNode(Arrays.asList(9,9));
        ListNode listNode = ListNode.fillNode(Arrays.asList(9,1,6));
        ListNode listNode1 = ListNode.fillNode(Arrays.asList(0));
        AddTwoNumbers2 addTwoNumbers = new AddTwoNumbers2();
        ListNode result = addTwoNumbers.addTwoNumbers(listNode, listNode1);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        LinkedList<Integer> queue1 = new LinkedList();
        LinkedList<Integer> queue2 = new LinkedList();
        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }
        ListNode node = null;
        int pre=0;
        int size;
        if (queue1.size() > queue2.size()) {
            size = queue2.size();
        }else {
            size = queue1.size();
        }
        while (size > 0) {
            Integer num1 = queue1.pollLast();
            Integer num2 = queue2.pollLast();
            int sum=num1+num2+pre;
            if (sum>=10){
                pre=1;
                sum-=10;
            }else {
                pre=0;
            }
            if (node==null){
                node=new ListNode(sum);
            }else {
                ListNode listNode = new ListNode(sum);
                listNode.next=node;
                node=listNode;
            }
            size--;
        }
        queue1=queue1.isEmpty()?queue2:queue1;
        while (!queue1.isEmpty()){
            Integer pop = queue1.pollLast();
            int sum=pop+pre;
            if (sum>=10){
                pre=1;
                sum-=10;
            }else {
                pre=0;
            }
            ListNode listNode = new ListNode(sum);
            listNode.next=node;
            node=listNode;
        }
        if (pre==1){
            ListNode listNode = new ListNode(pre);
            listNode.next=node;
            node=listNode;
        }
        return node;
    }

}
