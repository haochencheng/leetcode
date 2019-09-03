package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.Node;
import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-03 12:45
 **/
public class PostorderTraversal {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, null, 2, 3, null);
        List<Integer> list = Arrays.asList(3, 1, 2);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        PostorderTraversal postorderTraversal = new PostorderTraversal();
//        System.out.println(Arrays.toString(postorderTraversal.postorderTraversal(node).toArray()));
        System.out.println(Arrays.toString(postorderTraversal.postorderTraversalQueue(node).toArray()));
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    private LinkedList<TreeNode> queue = new LinkedList();

    public List<Integer> postorderTraversalQueue(TreeNode root) {
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peekFirst();
            if (node.left != null) {
                queue.push(node.left);
                node.left = null;
            } else if (node.right != null) {
                queue.push(node.right);
                node.right = null;
            } else if (node.left == null && node.right == null) {
                queue.pop();
                list.add(node.val);
            }
        }
        return list;
    }

}
