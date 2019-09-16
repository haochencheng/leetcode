package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 865. 具有所有最深结点的最小子树
 * <p>
 * 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * <p>
 * 我们返回值为 2 的结点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的结点。
 * 输入 "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。
 * 输出 "[2, 7, 4]" 是对根结点的值为 2 的子树的序列化表述。
 * 输入和输出都具有 TreeNode 类型。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中结点的数量介于 1 和 500 之间。
 * 每个结点的值都是独一无二的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-16 12:09
 **/
public class SubtreeWithAllDeepest {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        List<Integer> list = Arrays.asList(0, 3, 1, 4, null, 2, null, null, 6, null, 5);
//        List<Integer> list = Arrays.asList(1);
//        List<Integer> list = Arrays.asList(0, 1, 3, null, 2);
//        List<Integer> list = Arrays.asList(0,null,1,3,2,null,null,4,null,null,5);
//        List<Integer> list = Arrays.asList(0, 2, 1, null, null, 3);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        SubtreeWithAllDeepest subtreeWithAllDeepest = new SubtreeWithAllDeepest();
        System.out.println(subtreeWithAllDeepest.subtreeWithAllDeepest(node));
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int deepL = deep(root.left, 0);
        int deepR = deep(root.right, 0);
        if (deepL == deepR) {
            return root;
        } else if (deepL > deepR) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    public int deep(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        int left = deep(root.left, deep + 1);
        int right = deep(root.right, deep + 1);
        return left > right ? left : right;
    }

}
