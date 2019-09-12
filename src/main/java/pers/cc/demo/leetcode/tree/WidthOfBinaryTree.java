package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 662. 二叉树最大宽度
 * <p>
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-11 19:50
 **/
public class WidthOfBinaryTree {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 3, null, 5, 3);
        List<Integer> list = Arrays.asList(1, 3, 2, 5, 3, null, 9);
//        List<Integer> list = Arrays.asList(1, 1, 1, 1, null, null, 1, 1, null, null, 1);
//        List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 1, 1, null, null, null, 1, null, null, null, null, 2, 2, 2, 2, 2, 2, 2, null, 2, null, null, 2, null, 2);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(node));
    }

    Map<Integer, LinkedList<Integer>> result = new TreeMap<>(Comparator.comparingInt(o -> -o));

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, 0);
        int max = 0;
        Set<Map.Entry<Integer, LinkedList<Integer>>> entries = result.entrySet();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : entries) {
            LinkedList<Integer> value = entry.getValue();
            if (value.size() < 2) {
                continue;
            }
            max = max > value.peekLast() - value.peekFirst() ? max : value.peekLast() - value.peekFirst();
            continue;
        }
        return max + 1;
    }

    public void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, x * 2, y + 1);
        }
        if (root.right != null) {
            dfs(root.right, x * 2 + 1, y + 1);
        }
        result.compute(y, (k, v) -> {
            if (v == null) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(x);
                return list;
            } else {
                v.add(x);
                return v;
            }
        });
    }

    public int widthOfBinaryTreeTimeOut(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> nodeList = new LinkedList();
        nodeList.add(root);
        int max = 0;
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            Integer head = null;
            Integer tail = null;
            for (int i = 1; i <= size; i++) {
                TreeNode node = nodeList.pollLast();
                if (node != null) {
                    if (head == null) {
                        head = i;
                    } else {
                        tail = i;
                    }
                    nodeList.push(node.right);
                    nodeList.push(node.left);
                } else {
                    if (head != null) {
                        nodeList.push(null);
                        nodeList.push(null);
                    }
                }
            }
            if (tail != null && head != null) {
                int width = tail - head;
                if (max < width) {
                    max = width;
                }
            }

        }
        return max + 1;
    }

}
