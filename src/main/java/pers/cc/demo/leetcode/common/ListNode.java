package pers.cc.demo.leetcode.common;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-13 23:55
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null ) {
            return "ListNode [val=" + val + ", next=" + next + "]";
        }
        return "ListNode [val=" + val + ", next=" + next + "]";
    }

    public static ListNode fillNode(List<Integer> list) {
        ListNode head = null;
        ListNode tmp = null;
        for (int i = 0; i < list.size(); i++) {
            if (Objects.isNull(tmp)) {
                tmp = new ListNode(list.get(i));
                head = tmp;
            } else {
                tmp.next = new ListNode(list.get(i));
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static ListNode createNode(int val) {
        return new ListNode(val);
    }

}
