package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 687. 最长同值路径
 * <p>
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-13 15:43
 **/
public class LongestUnivaluePath {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 5, 1, 1, null, 5);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        System.out.println(longestUnivaluePath.longestUnivaluePath(treeNode));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestUnivaluePath(root, root.val);
        return max;
    }

    private int max = 0;

    public int longestUnivaluePath(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath(root.left, root.val);
        int right = longestUnivaluePath(root.right, root.val);
        if (max < (left + right)) {
            max = left + right;
        }
        if (root.val == val) {
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

}
