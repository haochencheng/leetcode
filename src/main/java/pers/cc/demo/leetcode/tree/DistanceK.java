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
//        TreeNode node = new TreeNode(2);
        //# 3
        List<Integer> list = Arrays.asList(0, null, 1, 2, 5, null, 3, null, null, null, 4);
        TreeNode node = new TreeNode(2);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        DistanceK distanceK = new DistanceK();
        List<Integer> result = distanceK.distanceK(treeNode, node, 2);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private int[] location=new int[2];
    private int targetVal;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        if (root == null) {
            return new ArrayList<>(1);
        }
        List<Integer> result = new LinkedList<>();
        targetVal=target.val;
        int deep = deep(root);
        int pow = (int) Math.pow(2, deep - 1);
        Integer[][] ints = new Integer[deep][pow];
        dfs(root, 0, 0, ints);
        System.out.println(Arrays.deepToString(ints));
        int y = location[0];
        int x = location[1];

        return result;
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(deep(root.left) + 1, deep(root.right) + 1);
    }

    public void dfs(TreeNode root, int x, int y, Integer[][] ints) {
        if (root == null) {
            return;
        }
        if (root.val==targetVal){
            location[0]=y;
            location[1]=x;
        }
        ints[y][x] = root.val;
        dfs(root.left, x - 1, y + 1, ints);
        dfs(root.right, x + 1, y + 1, ints);

    }


}
