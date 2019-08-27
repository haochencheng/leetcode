package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtll;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-08-27 08:13
 **/
public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtll.fillTreeNode(Arrays.asList(1, 0, 1, 0, 0, 1, 0));
        sumRootToLeaf(treeNode);
        System.out.println();
    }

    public static int sumRootToLeaf(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        dp(root, stringBuilder);
        double sum = 0;
        for (StringBuilder builder : stringBuilderList) {
            String s = builder.toString();
            char[] chars = s.toCharArray();
            double ten = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                ten += (chars[i] == '0' ? 0 : Math.pow(2, chars.length-1-i));
            }
            sum += ten;
        }
        return BigDecimal.valueOf(sum).intValue();
    }

    private static List<StringBuilder> stringBuilderList = new LinkedList<>();

    private static void dp(TreeNode root, StringBuilder stringBuilder) {
        stringBuilder.append(root.val);
        if (Objects.nonNull(root.left)) {
            StringBuilder sb = new StringBuilder(stringBuilder);
            dp(root.left, sb);
        }
        if (Objects.nonNull(root.right)) {
            StringBuilder sb = new StringBuilder(stringBuilder);
            dp(root.right, sb);
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            System.out.println(stringBuilder.toString());
            stringBuilderList.add(stringBuilder);
        }
    }

}
