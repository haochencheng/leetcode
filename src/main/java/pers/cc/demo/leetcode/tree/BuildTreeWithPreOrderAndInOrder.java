package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-01 10:27
 **/
public class BuildTreeWithPreOrderAndInOrder {

    public static void main(String[] args) {
        //前序遍历
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        //中序遍历
        int[] inorder = new int[]{9, 3, 15, 20, 7};

//                 3
//                / \
//               9  20
//                /  \
//               15   7
        BuildTreeWithPreOrderAndInOrder build = new BuildTreeWithPreOrderAndInOrder();
        TreeNode node = build.buildTree(preorder, inorder);
        System.out.println(node);
    }

    private int preIndex;
    HashMap<Integer, Integer> inOrderHashMap = new HashMap();
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderHashMap.put(inorder[i], i);
        }
        preIndex = 0;
        this.preorder = preorder;
        TreeNode node = dfs(preIndex, inorder.length-1);
        return node;
    }


    public TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }
        Integer rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        Integer rootIndexInOrder = inOrderHashMap.get(rootVal);
        root.left = dfs(left, rootIndexInOrder - 1);
        root.right = dfs(rootIndexInOrder + 1, right);
        return root;
    }
}
