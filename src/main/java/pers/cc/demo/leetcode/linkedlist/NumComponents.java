package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 817. 链表组件
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 * <p>
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * <p>
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * 注意:
 * <p>
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-16 08:41
 **/
public class NumComponents {

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fillNode(Arrays.asList(0, 1, 2, 3));
//        int[] G = new int[]{0, 1, 3};
        ListNode listNode = ListNode.fillNode(Arrays.asList(4, 3, 1,2, 0));
        int[] G = new int[]{ 1, 3,0};
        NumComponents numComponents = new NumComponents();
        int result = numComponents.numComponents(listNode, G);
        System.out.println(result);
    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        int sum = 0;
        ListNode pre = null;
        int len=0;
        boolean have = false;
        while (head != null) {
            for (int i = 0; i < G.length-len; i++) {
                if (G[i] == head.val) {
                    G[i] = G[G.length -len- 1];
                    G[G.length - len-1] = head.val;
                    if (pre == null) {
                        pre = head;
                    }
                    have = true;
                    len++;
                    break;
                }else {
                    have=false;
                }
            }
            if (!have) {
                if (pre != null) {
                    sum++;
                    pre = null;
                }
            }

            head=head.next;
        }
        if (have){
            sum++;
        }
        return sum;
    }

}
