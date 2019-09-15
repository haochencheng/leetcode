package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 814. 二叉树剪枝
 * <p>
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * <p>
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * <p>
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * <p>
 * <p>
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * <p>
 * <p>
 * <p>
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 给定的二叉树最多有 100 个节点。
 * 每个节点的值只会为 0 或 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-15 10:49
 **/
public class PruneTree {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,null,0,0,1);
        List<Integer> list = Arrays.asList(1, 0, 1, 0, 0, 0, 1);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        PruneTree pruneTree = new PruneTree();
        System.out.println(pruneTree.pruneTree(node));
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root, root);
        return root;
    }

    public void dfs(TreeNode parent, TreeNode current) {
        if (current == null || parent == null) {
            return;
        }
        dfs(current, current.left);
        dfs(current, current.right);
        if (current.val == 0) {
            if (current.left == null && current.right == null) {
                if (parent.left == current) {
                    parent.left = null;
                } else if (parent.right == current) {
                    parent.right = null;
                }
            }
        }
    }


}
