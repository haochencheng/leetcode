package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 993. 二叉树的堂兄弟节点
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-19 16:21
 **/
public class IsCousins {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
//        List<Integer> list = Arrays.asList(1,2,3,null,4,null,5);
        List<Integer> list = Arrays.asList(1, 2, 3, null, 4);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        IsCousins isCousins = new IsCousins();
//        System.out.println(isCousins.isCousins(treeNode, 3, 4));
//        System.out.println(isCousins.isCousins(treeNode, 5, 4));
        System.out.println(isCousins.isCousins(treeNode, 2, 3));
    }



    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        HashMap<Integer, Integer> parentHashMap = new HashMap<>();
        queue.add(root);
        int deep = 0;
        int one = -1;
        int nodeVal = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.val == x || node.val == y) {
                    if (one == -1) {
                        one = deep;
                        nodeVal = node.val;
                    } else {
                        return one == deep && !parentHashMap.get(nodeVal).equals(parentHashMap.get(node.val));
                    }
                }
                if (node.left != null) {
                    parentHashMap.put(node.left.val, node.val);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    parentHashMap.put(node.right.val, node.val);
                    queue.add(node.right);
                }
            }
            deep++;
        }
        return false;
    }

}
