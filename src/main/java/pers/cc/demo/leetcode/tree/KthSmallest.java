package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-05 08:55
 **/
public class KthSmallest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,4,null,2);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
//        treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(1);
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(treeNode,1));
    }

    private HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> linkedList = hashMap.get(root.hashCode());
        if (linkedList == null || linkedList.size() == 0) {
            dfs(root);
            Collections.sort(list);
            linkedList = list;
            hashMap.put(root.hashCode(), linkedList);
        }
        return linkedList.get(k-1);
    }

    private LinkedList list = new LinkedList();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


}
