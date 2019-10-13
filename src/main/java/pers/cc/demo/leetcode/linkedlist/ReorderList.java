package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-13 12:50
 **/
public class ReorderList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2,3,4));
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(listNode);
        System.out.println(listNode);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode result=head;
        LinkedList<Integer> linkedList = new LinkedList();
        while (result != null) {
            linkedList.add(result.val);
            result = result.next;
        }
        int index = 0;
        head.val=linkedList.pollFirst();
        result=head;
        while (!linkedList.isEmpty()) {
            if (index % 2 != 0) {
                result.next=new ListNode(linkedList.pollFirst());
            } else {
                result.next=new ListNode(linkedList.pollLast());
            }
            result=result.next;
            index++;
        }
    }
}
