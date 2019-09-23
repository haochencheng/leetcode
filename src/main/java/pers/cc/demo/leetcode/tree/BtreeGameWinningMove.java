package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1145. 二叉树着色游戏
 * <p>
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
 * <p>
 * 游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
 * <p>
 * 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
 * <p>
 * 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
 * <p>
 * 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
 * <p>
 * 之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
 * <p>
 * 如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
 * <p>
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 * <p>
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
 * <p>
 * 示例：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * 输出：True
 * 解释：第二个玩家可以选择值为 2 的节点。
 * 提示：
 * <p>
 * 二叉树的根节点为 root，树上由 n 个节点，节点上的值从 1 到 n 各不相同。
 * n 为奇数。
 * 1 <= x <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-coloring-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-22 17:10
 **/
public class BtreeGameWinningMove {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        List<Integer> list = Arrays.asList(1, 2, 3);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        BtreeGameWinningMove btreeGameWinningMove = new BtreeGameWinningMove();
//        System.out.println(btreeGameWinningMove.btreeGameWinningMove(treeNode, 11, 3));
        System.out.println(btreeGameWinningMove.btreeGameWinningMove(treeNode, 3, 2));
    }

    private LinkedList<TreeNode> blueQueue = new LinkedList();
    private LinkedList<TreeNode> redQueue = new LinkedList();

    private int red = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] color = new int[n];
        //1 红 -1 蓝
        color[x - 1] = 1;
        red += 1;
        find(root, null, x, false, color);
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            find(root, null, i, true, color);
            int l = n - 2;
            int k = 0;
            while (l > 0) {
                if (k % 2 == 0) {
                    if (mark(false, color)) {
                        l--;
                    }
                } else {
                    if (mark(true, color)) {
                        l--;
                    }
                }
                k++;
            }
            if (n - red > red) {
                return true;
            }
            red = 1;
        }
        return false;
    }

    public void find(TreeNode root, TreeNode parent, int x, boolean blue, int[] color) {
        Queue<TreeNode> queue;
        if (blue) {
            queue = blueQueue;
        } else {
            queue = redQueue;
        }
        if (root.val == x) {
            color[root.val - 1] = blue ? -1 : 1;
            if (parent != null && color[parent.val - 1] == 0) {
                queue.add(parent);
            }
            if (root.left != null && color[root.left.val - 1] == 0) {
                queue.add(root.left);
            }
            if (root.right != null && color[root.right.val - 1] == 0) {
                queue.add(root.right);
            }
        } else {
            if (root.left != null) {
                find(root.left, root, x, blue, color);
            }
            if (root.right != null) {
                find(root.right, root, x, blue, color);
            }
        }
    }

    public boolean mark(Boolean blue, int[] color) {
        Queue<TreeNode> queue;
        if (blue) {
            queue = blueQueue;
        } else {
            queue = redQueue;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (color[node.val - 1] == 0) {
                color[node.val - 1] = blue ? -1 : 1;
                if (!blue) {
                    red++;
                }
                if (node.right != null && color[node.right.val - 1] == 0) {
                    queue.add(node.right);
                }
                if (node.left != null && color[node.left.val - 1] == 0) {
                    queue.add(node.left);
                }
                return true;
            }
        }
        return false;
    }

}
