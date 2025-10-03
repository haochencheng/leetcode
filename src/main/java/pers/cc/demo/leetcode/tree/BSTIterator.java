package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.Node;
import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.NodeUtil;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 示例：
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description:
 * @author: haochencheng
 * @create: 2019-09-04 14:22
 **/
public class BSTIterator {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3,4,5,6,7);
        TreeNode treeNode = TreeNodeUtil.fillTreeNode(list);
        BSTIterator bstIterator = new BSTIterator(treeNode);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }

    private Node node;
    private Node head;

    public BSTIterator(TreeNode root) {
        buildNode(root);
        node=head;
        System.out.println(node);
    }

    public void buildNode(TreeNode root){
        if (root==null){
            return;
        }
        buildNode(root.left);
        if (node==null){
            node=new Node(root.val);
            head=node;
        }else {
            node.next=new Node(root.val);
            node=node.next;
        }
        buildNode(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (node==null){
            return 0;
        }else {
            int val = node.val;
            this.node=node.next;
            return val;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node!=null;
    }


    static class Node {
        int val;
        Node next;

        public Node(int val){
            this.val=val;
        }

    }

}
