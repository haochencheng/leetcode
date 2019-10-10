package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-10 17:11
 **/
public class Partition {

    public static void main(String[] args) {
        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 4, 3, 2, 5, 2));
        Partition partition = new Partition();
        ListNode result = partition.partition(listNode, 3);
        System.out.println(result);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode next = new ListNode(0);
        ListNode pre1 = pre;
        ListNode next1 = next;
        while (head != null) {
            if (head.val < x) {
                pre1.next = head;
                head = head.next;
                pre1 = pre1.next;
                pre1.next = null;
            } else {
                next1.next = head;
                head = head.next;
                next1 = next1.next;
                next1.next = null;
            }
        }
        pre1.next = next.next;
        return pre.next;
    }

}
