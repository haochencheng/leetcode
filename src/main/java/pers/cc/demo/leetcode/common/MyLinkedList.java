package pers.cc.demo.leetcode.common;

/**
 * @description:
 * @author: haochencheng
 * @create: 2019-01-24 17:57
 **/
public class MyLinkedList {

    private Node frist;
    private Node last;

    class Node<E> {
        E item;
        Node pre;
        Node next;

        public Node(E e){
            this.item=e;
        }

    }


    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i=0;
        Node node=frist;
        while (node!=null){
            if (i==index){
                return (int) node.item;
            }
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.frist=new Node(val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.last=new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int i=0;
        Node node=frist;
        while (node!=null){
            if (i==index){
                Node node1 = new Node(val);
                Node pre = node.pre;
                pre.next=node1;
                node.pre=node1;
                break;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i=0;
        Node node=frist;
        while (node!=null){
            if (i==index){
                Node pre = node.pre;
                Node next = node.next;
                pre.next=next;
                next.pre=pre;
                break;
            }
        }
    }


}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */