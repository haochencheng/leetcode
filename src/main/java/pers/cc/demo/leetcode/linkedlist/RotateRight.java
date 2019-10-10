package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.*;

/**
 * 61. 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-10 12:29
 **/
public class RotateRight {

    public static void main(String[] args) {
        System.out.println(7%3);
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode = ListNode.fillNode(Arrays.asList(0, 1, 2));
        RotateRight rotateRight = new RotateRight();
        ListNode result = rotateRight.rotateRight(listNode, 4);
        System.out.println(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList();
        int size = 0;
        while (head != null) {
            queue.add(head.val);
            head = head.next;
            size++;
        }
        ListNode result = null;
        k = k % size;
        int i = 0;
        while (i < k) {
            Integer val = queue.pollLast();
            queue.addFirst(val);
            i++;
        }
        ListNode pre = null;
        while (!queue.isEmpty()) {
            if (result == null) {
                result = new ListNode(queue.poll());
                pre = result;
            } else {
                pre.next = new ListNode(queue.poll());
                pre = pre.next;
            }
        }
        return result;
    }

}
