package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 655. 输出二叉树
 * <p>
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * /
 * 2
 * 输出:
 * [["", "1", ""],
 * ["2", "", ""]]
 * 示例 2:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * 示例 3:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-11 12:48
 **/
public class PrintTree {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
//        List<Integer> list = Arrays.asList(1);
//        List<Integer> list = Arrays.asList(2, null, 3, null, 4, null, 5, null, 6);
        List<Integer> list = Arrays.asList(1, 2, 3, null, 4);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        PrintTree printTree = new PrintTree();
        System.out.println(Arrays.toString(printTree.printTree(node).toArray()));
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        int depth = getDepth(root);
        int width = (int)(Math.pow(2, depth) - 1);
        width = width > 0 ? width : 1;
        String[][] result = new String[depth][width];
        List<List<String>> res = new LinkedList<>();
        fill(result, 0, 0, width - 1, root);
        for (int i = 0; i < result.length; i++) {
            LinkedList<String> linkedList = new LinkedList<>();
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == null) {
                    linkedList.add("");
                } else {
                    linkedList.add(result[i][j]);
                }
            }
            res.add(linkedList);
        }
        return res;
    }

    public void fill(String[][] ints, int depth, int start, int end, TreeNode node) {
        if (node == null) {
            return;
        }
        int mid = (start + end) / 2;
        ints[depth][mid] = String.valueOf(node.val);
        fill(ints, depth + 1, start, mid - 1, node.left);
        fill(ints, depth + 1, mid + 1, end, node.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        return right > left ? right : left;
    }

}
