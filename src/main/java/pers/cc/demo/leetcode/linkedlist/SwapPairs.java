package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-09 17:47
 **/
public class SwapPairs {

    public static void main(String[] args) {
//        ListNode listNode1 = ListNode.fillNode(Arrays.asList(1, 2, 3, 4));
        ListNode listNode1 = ListNode.fillNode(Arrays.asList(1, 2, 3));
        SwapPairs swapPairs = new SwapPairs();
        System.out.println(swapPairs.swapPairs(listNode1));
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode pre = null;
        ListNode next;
        while (head != null ) {
            next = head.next;
            if (head.next == null){
               break;
            }
            head.next = next.next;
            next.next = head;
            if (pre != null) {
                pre.next = next;
            }
            pre = head;
            if (result == null) {
                result = next;
            }
            head = head.next;
        }
        return result==null?head:result;
    }


}
