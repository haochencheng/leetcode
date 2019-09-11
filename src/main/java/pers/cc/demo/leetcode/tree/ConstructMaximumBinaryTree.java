package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.Node;
import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.NodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-09 18:54
 **/
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        int[] ints = new int[]{3, 2, 1, 6, 0, 5};
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode treeNode = constructMaximumBinaryTree.constructMaximumBinaryTree(ints);
        System.out.println(treeNode);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxNumIndex = findMaxNumIndex(nums, start, end);
        TreeNode treeNode = new TreeNode(nums[maxNumIndex]);
        treeNode.left = constructMaximumBinaryTree(nums, start, maxNumIndex - 1);
        treeNode.right = constructMaximumBinaryTree(nums, maxNumIndex + 1, end);
        return treeNode;
    }

    private int findMaxNumIndex(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }


}
