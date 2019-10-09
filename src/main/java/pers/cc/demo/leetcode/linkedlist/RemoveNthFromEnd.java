package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-09 10:31
 **/
public class RemoveNthFromEnd {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3));
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2));
        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5));
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode result = removeNthFromEnd.removeNthFromEnd(listNode, 2);
        System.out.println(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            if (fastNode.next != null) {
                fastNode = fastNode.next;
            } else {
                return head.next;
            }
        }
        ListNode slowNode = head;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode=slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return tail;
    }

}
