package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * <p>
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-24 22:00
 **/
public class RecoverTree {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 3, null, null, 2);
        List<Integer> list = Arrays.asList(3, 1, 4, null, null, 2);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(node);
        System.out.println(node);
    }

    private TreeNode pre,before,after;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int val = before.val;
        before.val = after.val;
        after.val = val;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (before == null){
                before = pre;
            }
            after = root;
        }
        pre = root;
        inorder(root.right);
    }

}
