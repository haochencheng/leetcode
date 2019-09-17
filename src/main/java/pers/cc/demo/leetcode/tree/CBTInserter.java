package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 919. 完全二叉树插入器
 * <p>
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 TreeNode 的父结点的值；
 * CBTInserter.get_root() 将返回树的头结点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * 提示：
 * <p>
 * 最初给定的树是完全二叉树，且包含 1 到 1000 个结点。
 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
 * 给定结点或插入结点的每个值都在 0 到 5000 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-16 17:06
 **/
public class CBTInserter {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list = Arrays.asList(1);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        CBTInserter cbtInserter = new CBTInserter(treeNode);
//        System.out.println(cbtInserter.insert(7));
//        System.out.println(cbtInserter.insert(8));
        System.out.println(cbtInserter.insert(2));
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
        System.out.println(cbtInserter.get_root());
    }

    private TreeNode root;
    private LinkedList<TreeNode> queue = new LinkedList();

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.right != null) {
                queue.add(node.left);
                queue.add(node.right);
            }else {
                queue.addFirst(node);
                break;
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode treeNode = queue.pollFirst();
        if (treeNode.left == null) {
            treeNode.left = node;
            queue.addFirst(treeNode);
        } else if (treeNode.right == null) {
            treeNode.right = node;
            queue.add(treeNode.left);
            queue.add(node);
        }
        return treeNode.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

}
