package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * 328. 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-14 13:12
 **/
public class OddEvenList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5));
        OddEvenList oddEvenList = new OddEvenList();
        ListNode result = oddEvenList.oddEvenList(listNode);
        System.out.println(result);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode h = pre;
        ListNode next = new ListNode(0);
        ListNode t = next;
        int index = 0;
        while (head != null) {
            index++;
            if (index % 2 == 0) {
                next.next=new ListNode(head.val);
                next=next.next;
            } else {
                pre.next=new ListNode(head.val);
                pre=pre.next;
            }
            head=head.next;
        }
        pre.next=t.next;
        return h.next;
    }


}
