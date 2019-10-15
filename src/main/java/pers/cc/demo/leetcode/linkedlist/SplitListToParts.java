package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * 725. 分隔链表
 * <p>
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *  
 * <p>
 * 提示:
 * <p>
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-15 22:48
 **/
public class SplitListToParts {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3));
//        int k=2;
//        ListNode listNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        int k = 3;
        ListNode listNode = ListNode.fillNode(Arrays.asList(0,1, 2, 3, 4));
        int k = 3;
//        ListNode listNode = ListNode.fillNode(Arrays.asList(0));
//        int k = 1;
        SplitListToParts splitListToParts = new SplitListToParts();
        ListNode[] result = splitListToParts.splitListToParts(listNode, k);
        System.out.println(Arrays.toString(result));
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }
        ListNode head = root;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        int sum = count;
        while ((count / k) * k < count) {
            count++;
        }
        int size = count / k;
        ListNode[] result = new ListNode[k];
        int index = 0;
        int left = 1;
        ListNode cur = null;
        while (root != null) {
            if (cur == null) {
                cur = root;
            }
            if (left++ >= size) {
                ListNode next = root.next;
                root.next = null;
                result[index] = cur;
                index++;
                if (k > 1) {
                    sum-=size;
                    count=sum;
                    k-=1;
                    while ((count / k) * k < count) {
                        count++;
                    }
                    size = count /k;
                }
                left = 1;
                cur = null;
                root = next;
                continue;
            }
            root = root.next;
        }
        if (cur != null) {
            result[index] = cur;
        }
        return result;
    }


}
