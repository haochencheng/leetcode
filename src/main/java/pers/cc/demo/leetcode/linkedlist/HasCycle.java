package pers.cc.demo.leetcode.linkedlist;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import pers.cc.demo.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        head.next = listNode;
        listNode.next = new ListNode(3);
        ListNode listNode1 = new ListNode(4,listNode);
        listNode.next.next = listNode1;
        Assert.assertTrue(hasCycle(head));
        Assert.assertTrue(hasCycle1(head));
    }


}
