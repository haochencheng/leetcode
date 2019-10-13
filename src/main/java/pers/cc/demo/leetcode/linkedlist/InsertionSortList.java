package pers.cc.demo.leetcode.linkedlist;

import lombok.val;
import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * 147. 对链表进行插入排序
 * <p>
 * 对链表进行插入排序。
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-13 13:31
 **/
public class InsertionSortList {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4));
        ListNode listNode = ListNode.fillNode(Arrays.asList(4,2,1,3));
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode result = insertionSortList.insertionSortList(listNode);
        System.out.println(result);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode tail = result;
        while (head.next != null) {
            head = head.next;
            ListNode cur = result;
            if (head.val <= cur.val) {
                ListNode listNode = new ListNode(head.val);
                listNode.next = cur;
                result = listNode;
            } else {
                if (head.val > tail.val) {
                    tail.next = new ListNode(head.val);
                    tail = tail.next;
                } else {
                    while (cur.next!=null){
                        if (head.val<cur.next.val){
                            ListNode listNode = new ListNode(head.val);
                            ListNode next = cur.next;
                            listNode.next=next;
                            cur.next=listNode;
                            break;
                        }
                        cur=cur.next;
                    }
                }
            }
        }
        return result;
    }

}
