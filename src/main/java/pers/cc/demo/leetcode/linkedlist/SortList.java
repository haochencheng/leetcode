package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * 148. 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-13 19:49
 **/
public class SortList {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(-10, -3, 0, 5, 9));
        ListNode listNode = ListNode.fillNode(Arrays.asList(0, 5, 9, -10, -3));
        SortList sortList = new SortList();
        ListNode result = sortList.sortList(listNode);
        System.out.println(result);
    }


    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (fast == slow) {
            return head;
        }
        pre.next = null;
        ListNode left = sortList(slow);
        ListNode right = sortList(head);
        return mergeSort(left, right);
    }

    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return result.next;
    }


}
