package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;
import pers.cc.demo.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-10 19:14
 **/
public class SortedListToBST {

    public static void main(String[] args) {
        ListNode listNode = ListNode.fillNode(Arrays.asList(-10, -3, 0, 5, 9));
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode result = sortedListToBST.sortedListToBST(listNode);
        System.out.println(result);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode treeNode ;
        if (head.next==null){
            treeNode = new TreeNode(head.val);
            return treeNode;
        }
        ListNode first = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        while (first.next != slow) {
            first = first.next;
        }
        first.next=null;
        treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBST(head);
        ListNode next = slow.next;
        treeNode.right = sortedListToBST(next);
        return treeNode;
    }


}
