package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.*;

/**
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 * 示例 1：
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 * <p>
 * 提示：
 * <p>
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-21 15:22
 **/
public class RecoverFromPreorder {


    public static void main(String[] args) {
//        String s = "1-2--3--4-5--6--7";
//        String s = "1-2--3---4-5--6---7";
        String s = "1-401--349--90---88";
//        String s = "1-5--9---1----4--5---3-6";
//        String s = "4-6-4--3--9---3";
//        String s = "1-401--349---90--88";
        RecoverFromPreorder recoverFromPreorder = new RecoverFromPreorder();
        TreeNode node = recoverFromPreorder.recoverFromPreorder(s);

        System.out.println(node);
    }

    public TreeNode recoverFromPreorder(String S) {
        if (S == null) {
            return null;
        }
        char[] chars = S.toCharArray();
        int deep = 0;
        int preDeep = 0;
        TreeNode root = null;
        LinkedList<TreeNode> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            //计算层级
            if (val == '-') {
                deep++;
                continue;
            }
            int v;
            //获取节点值
            if (i < chars.length - 1 && chars[i + 1] != '-') {
                sb.append(chars[i]);
                continue;
            } else {
                sb.append(chars[i]);
                v = Integer.valueOf(sb.toString());
                sb = new StringBuilder();
            }
            if (root == null) {
                root = new TreeNode(v);
                queue.add(root);
            } else {
                TreeNode node;
                if (deep == preDeep) {
                    node = queue.get(deep - 1);
                    // 同一层
                    if (node.right == null) {
                        node.right = new TreeNode(v);
                        queue.pollLast();
                        queue.add(node.right);
                    }
                } else if (deep > preDeep) {
                    node = queue.get(deep - 1);
                    if (node.left == null) {
                        node.left = new TreeNode(v);
                        queue.add(node.left);
                    }
                } else {
                    while (queue.size() != deep) {
                        queue.pollLast();
                    }
                    node = queue.peekLast();
                    //右子树
                    if (node.right == null) {
                        node.right = new TreeNode(v);
                        queue.add(node.right);
                    }
                }
                preDeep = deep;
                deep = 0;
            }
        }
        return root;
    }

}
