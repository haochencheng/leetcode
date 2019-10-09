package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.*;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-09 15:10
 **/
public class MergeKLists {

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.fillNode(Arrays.asList(1, 4, 5));
        ListNode listNode2 = ListNode.fillNode(Arrays.asList(1, 3, 4));
        ListNode listNode3 = ListNode.fillNode(Arrays.asList(2,6));
        ListNode[] listNodes = Arrays.asList(listNode1, listNode2, listNode3).toArray(new ListNode[3]);
        MergeKLists mergeKLists=new MergeKLists();
        System.out.println(mergeKLists.mergeKLists(listNodes));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<Integer> linkedList=new LinkedList();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list!=null){
                linkedList.add(list.val);
                list=list.next;
            }
        }
        Collections.sort(linkedList);
        ListNode result=null;
        ListNode head=null;
        for (int i = 0; i < linkedList.size(); i++) {
            if (result==null){
                result=new ListNode(linkedList.get(i));
                head=result;
            }else {
                result.next=new ListNode(linkedList.get(i));
                result=result.next;
            }
        }
        return head;
    }

}
