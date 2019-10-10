package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 92. 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-10 18:51
 **/
public class ReverseBetween {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode = ListNode.fillNode(Arrays.asList(5));
        ReverseBetween reverseBetween = new ReverseBetween();
//        ListNode result = reverseBetween.reverseBetween(listNode, 2, 4);
        ListNode result = reverseBetween.reverseBetween(listNode, 1, 1);
        System.out.println(result);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        int index = 1;
        LinkedList<Integer> linkedList = new LinkedList();
        ListNode result = null;
        ListNode cur = null;
        while (head != null) {
            if (index < m || index > n) {
                if (result == null) {
                    result = new ListNode(head.val);
                    cur = result;
                } else {
                    cur.next = new ListNode(head.val);
                    cur = cur.next;
                }
            } else if (index >= m && index < n) {
                linkedList.add(head.val);
            } else {
                linkedList.add(head.val);
                for (int i = linkedList.size() - 1; i >= 0; i--) {
                    if (result == null) {
                        result = new ListNode(linkedList.get(i));
                        cur = result;
                    } else {
                        cur.next = new ListNode(linkedList.get(i));
                        cur = cur.next;
                    }
                }
            }
            index++;
            head = head.next;
        }
        return result;
    }


}
