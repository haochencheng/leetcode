package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * <p>
 * 给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
 * <p>
 * 通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
 * <p>
 * 考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
 * <p>
 * （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
 * <p>
 * 我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。 
 * <p>
 * 如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。
 * <p>
 * 如果不能，则返回列表 [-1]。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 *  
 * 提示：
 * <p>
 * 1 <= N <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-19 22:16
 **/
public class FlipMatchVoyage {

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(Arrays.asList(1, 2));
//        int[] ints = new int[]{2, 1};
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(Arrays.asList(1, 2, 3));
        int[] ints = new int[]{1, 3, 2};
//        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(Arrays.asList(2, 1, 4, 5, null, 3));
//        int[] ints = new int[]{2, 4, 3, 1, 5};
//        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(Arrays.asList(1, 2, null, 3));
//        int[] ints = new int[]{1, 3, 2};
        System.out.println(treeNode);
        FlipMatchVoyage flipMatchVoyage = new FlipMatchVoyage();
        System.out.println(Arrays.toString(flipMatchVoyage.flipMatchVoyage(treeNode, ints).toArray()));
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (!dfs(root, null, voyage)) {
            result.clear();
            result.add(-1);
        }
        return result;
    }

    public boolean dfs(TreeNode root, TreeNode parent, int[] voyage) {
        if (root == null) {
            return true;
        }
        if (begin > voyage.length - 1) {
            return false;
        }
        int val = voyage[begin++];
        if (root.val == val) {
            return dfs(root.left, root, voyage) && dfs(root.right, root, voyage);
        } else {
            if (parent == null || parent.right == root) {
                return false;
            } else {
                if (parent.right == null || parent.right.val != val) {
                    return false;
                }
                TreeNode left = parent.left;
                parent.left = parent.right;
                parent.right = left;
                root=parent.left;
                result.add(parent.val);
                return dfs(root.left, root, voyage) && dfs(root.right, root, voyage);
            }
        }
    }

    private int begin = 0;
    private List result = new ArrayList();
    boolean turn = false;

    /// ============ 错误答案 =======

    private HashMap<Integer, Integer> parentValHashMap = new HashMap<>();

    public List<Integer> flipMatchVoyageNot(TreeNode root, int[] voyage) {

        result.add(-1);
        if (root == null || voyage == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    parentValHashMap.put(node.left.val, node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    parentValHashMap.put(node.right.val, node.val);
                }
                list.add(node.val);
            }
            int cellSize = list.size();

            for (int i = 0; i < cellSize; i++) {
                int nodeVal = list.get(i);
                if (nodeVal == voyage[begin]) {
                    begin++;
                    continue;
                }
                if (i % 2 != 0) {
                    //右子节点
                    if (nodeVal != voyage[begin] && begin - 1 >= 0 ? nodeVal != voyage[begin - 1] : true) {
                        return result;
                    }
                    if (begin - 1 > 0 && nodeVal == voyage[begin - 1]) {
                        //保存父节点
                        System.out.println(voyage[begin - 1]);
                        if (turn) {
                            result.add(parentValHashMap.get(nodeVal));
                            turn = false;
                        } else {
                            return result;
                        }
                    }
                } else {
                    //左子节点
                    if (nodeVal != voyage[begin] && begin + 1 < voyage.length ? nodeVal != voyage[begin + 1] : true) {
                        return result;
                    }
                    if (begin + 1 < voyage.length && nodeVal == voyage[begin + 1]) {
                        //保存父节点
                        turn = true;
                    }
                }
                begin++;
            }
        }
        result.remove(0);
        return result;
    }

}
