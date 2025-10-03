package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-25 08:55
 **/
public class BuildTreeWithInorderAndPostOrder {

    public static void main(String[] args) {
        //后序遍历
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        //中序遍历
        int[] inorder = new int[]{9, 3, 15, 20, 7};

//                 3
//                / \
//               9  20
//                /  \
//               15   7
        BuildTreeWithInorderAndPostOrder build = new BuildTreeWithInorderAndPostOrder();
        TreeNode node = build.buildTree(inorder, postorder);
        System.out.println(node);
    }

    private int postIndex;
    private int[] postorder;
    private HashMap<Integer, Integer> inorderHashMap = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postIndex = inorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderHashMap.put(inorder[i], i);
        }
        TreeNode dfs = dfs(0, postorder.length - 1);
        return dfs;
    }

    public TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }
        if (postIndex < 0) {
            return null;
        }
        int val = postorder[postIndex--];
        TreeNode root = new TreeNode(val);
        //计算范围
        root.right = dfs(inorderHashMap.get(val) + 1, right);
        root.left = dfs(left, inorderHashMap.get(val) - 1);
        return root;
    }

}
