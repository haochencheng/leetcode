package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * <p>
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * 输出：[7,4,1]
 * <p>
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-15 21:01
 **/
public class DistanceK {

    public static void main(String[] args) {

//        1
//        List<Integer> list = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
//        TreeNode node = new TreeNode(5);
//        2   #21
//        List<Integer> list = Arrays.asList(0, 1, null, 3, 2);
//        List<Integer> list = Arrays.asList(0,1,2,null,null,null,3);
//        TreeNode node = new TreeNode(1);
        //# 3
//        List<Integer> list = Arrays.asList(0, null, 1, 2, 5, null, 3, null, null, null, 4);
//        TreeNode node = new TreeNode(2);
//
        List<Integer> list = Arrays.asList(0, 2, 1, null, null, 3);
        TreeNode node = new TreeNode(3);


        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        DistanceK distanceK = new DistanceK();
        List<Integer> result = distanceK.distanceK(treeNode, node, 3);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private int rootDeep=0;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result=new LinkedList<>();
        int deep=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == target.val) {
                    continue;
                }
                Integer parentVal = null;
                int d=0;
                do {
                    d++;
                    if (parentVal==target.val){
                        if (d==K){
                            result.add(node.val);
                        }
                    }
                } while (parentVal != null);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            deep++;
        }
        return null;
    }

    public void dfs(TreeNode parent, TreeNode root) {
        if (root == null) {
            return;
        }
        hashMap.put(root.val, parent == null ? null : parent.val);
        dfs(root, root.left);
        dfs(root, root.right);
    }


}
