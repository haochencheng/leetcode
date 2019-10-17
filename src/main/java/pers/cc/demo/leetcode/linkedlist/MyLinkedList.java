package pers.cc.demo.leetcode.linkedlist;

/**
 * 707. 设计链表
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-10-16 09:14
 **/
public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        // ===========1111
//        obj.addAtHead(1);
//        obj.addAtTail(3);
//        obj.addAtIndex(1, 2);
//        System.out.println(obj.get(1));
//        obj.deleteAtIndex(0);
//        System.out.println(obj.get(0));
        //========2222
//        obj.addAtHead(5);
//        obj.addAtHead(2);
//        obj.deleteAtIndex(1);
//        obj.addAtIndex(1, 9);
//        obj.addAtHead(4);
//        obj.addAtHead(9);
//        obj.addAtHead(8);
//        System.out.println(obj.get(3));
//        obj.addAtTail(1);
//        obj.addAtIndex(3, 6);
//        System.out.println(obj.get(3));
        //==========3333
//        obj.addAtHead(1);
//        obj.deleteAtIndex(0);
        //======4444
//        obj.addAtHead(1);
//        obj.addAtIndex(1, 2);
//        System.out.println(obj.get(1));
//        System.out.println(obj.get(0));
//        System.out.println(obj.get(2));
//        =====5555
//        System.out.println(obj.get(0));
//        obj.addAtIndex(1, 2);
//        System.out.println(obj.get(0));;
//        System.out.println(obj.get(1));;
//        obj.addAtIndex(0, 1);
//        System.out.println(obj.get(0));;
//        System.out.println(obj.get(1));;
//        =======66666666
//        obj.addAtHead(5);
//        obj.addAtHead(2);
//        obj.deleteAtIndex(1);
//        obj.addAtIndex(1, 9);
//        obj.addAtHead(4);
//        obj.addAtHead(9);
//        obj.addAtHead(8);
//        System.out.println(obj.get(3));
//        obj.addAtTail(1);
//        obj.addAtIndex(3, 6);
//        obj.addAtHead(3);
//        =========7777777
//        obj.addAtHead(7);
//        obj.addAtTail(7);
//        obj.addAtHead(9);
//        obj.addAtTail(8);
//        obj.addAtHead(6);
//        obj.addAtHead(0);
//        System.out.println(obj.get(5));
//        obj.addAtHead(0);
//        System.out.println(obj.get(2));
//        System.out.println(obj.get(5));
//        obj.addAtTail(4);
        //====10
        obj.addAtIndex(0, 10);
        obj.addAtIndex(0, 20);
        obj.addAtIndex(1, 30);
        System.out.println(obj.get(0));
    }

    private class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node dummyHead;
    int size;

    public MyLinkedList() {
        dummyHead = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node reNode = prev.next;
        prev.next = reNode.next;
        reNode.next = null;
        size--;
    }


}
