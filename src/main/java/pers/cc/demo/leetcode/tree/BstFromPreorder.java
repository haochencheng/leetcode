package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.LinkedList;


/**
 * 1008. 先序遍历构造二叉树
 * <p>
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * <p>
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 100
 * 先序 preorder 中的值是不同的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-20 19:31
 **/
public class BstFromPreorder {

    public static void main(String[] args) {
        int[] ints = new int[]{8, 5, 1, 7, 10, 12};
        BstFromPreorder bstFromPreorder = new BstFromPreorder();
        System.out.println(bstFromPreorder.bstFromPreorder(ints));
    }

    private TreeNode root = null;
    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (root == null) {
            root = new TreeNode(preorder[i++]);
        }
        for (; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insert(root.right, val);
            }
        }
    }


}
