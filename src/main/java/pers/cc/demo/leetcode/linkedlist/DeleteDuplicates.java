package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-10 12:59
 **/
public class DeleteDuplicates {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(0, 1, 2, 2));
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1));
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1,1,1,2,3));
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 3, 4, 4, 5));
        ListNode listNode = ListNode.fillNode(Arrays.asList(-1,0,0,0,3,3));
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode result = deleteDuplicates.deleteDuplicates(listNode);
        System.out.println(result);
    }

    /**
     * 有序
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode pre = null;
        Integer preVal = null;
        while (head != null) {
            if (preVal==null || preVal != head.val) {
                if (result == null) {
                    result = new ListNode(head.val);
                } else {
                    if (pre==null){
                        pre=result;
                    }else {
                        if (pre.next != null) {
                            pre = pre.next;
                        }
                    }
                    pre.next = new ListNode(head.val);
                }
                preVal = head.val;
            } else {
                if (pre == null) {
                    result = null;
                } else {
                    pre.next = null;
                }
            }
            head = head.next;
        }
        return result;
    }

    /**
     * 无序
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesSlow(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        List<Integer> dupList = new LinkedList();
        List<Integer> list = new LinkedList();
        while (head != null) {
            if (list.contains(head.val)) {
                dupList.add(head.val);
            } else {
                list.add(head.val);
            }
            head = head.next;
        }
        if (dupList.size() == 0) {
            return pre;
        }
        ListNode result = null;

        for (int i = 0; i < list.size(); i++) {
            if (dupList.contains(list.get(i))) {
                continue;
            }
            if (result == null) {
                result = new ListNode(list.get(i));
                pre = result;
            } else {
                pre.next = new ListNode(list.get(i));
                pre = pre.next;
            }
        }
        return result;
    }

}
