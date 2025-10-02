package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

// 两数相加
//已解答
//中等
//相关标签
//premium lock icon
//相关企业
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
//示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//示例 2：
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//示例 3：
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//提示：
//
//每个链表中的节点数在范围 [1, 100] 内
//0 <= Node.val <= 9
//题目数据保证列表表示的数字不含前导零
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            int sum=v1 + v2 + carry;
            if (sum>= 10) {
                carry = 1;
            }else {
                carry = 0;
            }
            if(head==null){
                head=tail=new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.fillNode(Arrays.asList(2, 4, 3));
        ListNode listNode1 = ListNode.fillNode(Arrays.asList(5, 6, 4));
        ListNode result = new AddTwoNumbers().addTwoNumbers(listNode, listNode1);
        System.out.println(result);
    }

}
