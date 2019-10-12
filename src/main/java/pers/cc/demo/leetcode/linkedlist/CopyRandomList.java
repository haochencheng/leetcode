package pers.cc.demo.leetcode.linkedlist;

import pers.cc.demo.leetcode.common.ListNode;

import java.util.HashMap;


/**
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。 
 * <p>
 * 示例：
 * <p>
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *  
 * <p>
 * 提示：
 * <p>
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-11 13:18
 **/
public class CopyRandomList {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 2;
        node1.random = node1;
        Node node = new Node();
        node.val = 1;
        node.next = node1;
        node.random = node1;
        CopyRandomList copyRandomList = new CopyRandomList();
        Node result = copyRandomList.copyRandomList(node);
        System.out.println(result);
    }

    private HashMap<Integer, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node origin = head;
        while (head != null) {
            createNode(head.val);
            head = head.next;
        }
        Node result = null;
        Node cur;
        while (origin != null) {
            cur=hashMap.get(origin.val);
            Node next = origin.next;
            if (next != null) {
                cur.next = hashMap.get(next.val);
            }
            Node random = origin.random;
            if (random != null) {
                cur.random = hashMap.get(random.val);
            }
            if (result == null) {
                result = cur;
            }
            origin = origin.next;
        }
        return result;
    }

    private Node createNode(int val) {
        Node node = new Node();
        node.val = val;
        hashMap.put(val, node);
        return node;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next.val +
                    ", random=" + random.val +
                    '}';
        }
    }

}
