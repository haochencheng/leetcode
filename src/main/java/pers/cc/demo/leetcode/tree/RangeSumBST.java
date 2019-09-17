package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-17 09:14
 **/
public class RangeSumBST {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 15, 3, 7, null, 18);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(node, 7, 15));
    }

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root,L,R);
        return sum;
    }

    public void dfs(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        rangeSumBST(root.left, L, R);
        rangeSumBST(root.right, L, R);
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
    }

    public int rangeSumBSTTimeOut(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        if (root.val >= L && root.val <= R) {
            return left + right + root.val;
        }
        return left + right;
    }

}
