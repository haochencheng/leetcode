package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;

/**
 * 701. 二叉搜索树中的插入操作
 * <p>
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * 例如, 
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * 或者这个树也是有效的:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-14 11:15
 **/
public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(Arrays.asList(4, 2, 7, 1, 3));
        InsertIntoBST insertIntoBST = new InsertIntoBST();
        System.out.println(insertIntoBST.insertIntoBST(treeNode, 5));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        TreeNode head = root;
        dfs(root, val);
        return head;
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insertIntoBST(root.left, val);
        } else if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insertIntoBST(root.right, val);
        }
    }


}
