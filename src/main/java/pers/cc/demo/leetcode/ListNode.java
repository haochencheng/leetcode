package pers.cc.demo.leetcode;

import java.util.List;

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
        return "ListNode [val=" + val + ", next=" + next + "]";
    }

    public static ListNode fillNode(List<Integer> list) {
        ListNode head=null;
        ListNode tmp=null;
        for (int i = 0; i <list.size(); i++) {
            if (tmp==null){
                tmp=new ListNode(list.get(i));
                head = tmp;
            }else {
                tmp.next=new ListNode(list.get(i));
                tmp=tmp.next;
            }
        }
        return head;
    }

}
