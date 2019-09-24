package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * <p>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-24 12:56
 **/
public class GenerateTrees {

    public static void main(String[] args) {
        int val = 3;
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> list = generateTrees.generateTrees(val);
        System.out.println(Arrays.toString(list.toArray()));
    }


    /**
     * f(n) = f(1) + f(2) + f(3) ... + f(n)
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>(1);
        }
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = build(start, i - 1);
            List<TreeNode> rightList = build(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.left = right;
                    res.add(root);
                }
            }
        }
        return res;
    }


}
