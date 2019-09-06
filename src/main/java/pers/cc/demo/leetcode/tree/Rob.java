package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 337. 打家劫舍 III
 * <p>
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-05 19:27
 **/
public class Rob {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, null, 5, null, 4);
//        List<Integer> list = Arrays.asList(3,2,3,null,3,null,1);
        List<Integer> list = Arrays.asList(4,1,null,2,null,3);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        Rob rob = new Rob();
        System.out.println(rob.rob(node));
    }

//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int[] res = helpRob(root);
//        return Math.max(res[0],res[1]);
//    }
//
//    public int[] helpRob(TreeNode root){
//        if (root==null){
//            return new int[2];
//        }
//        int[] left = helpRob(root.left);
//        int[] right = helpRob(root.right);
//        int[] res = new int[2];
//        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
//        res[1] = root.val + left[0] + right[0];
//        return res;
//    }


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(root);
        List<Integer> result = new LinkedList();
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            LinkedList<Integer> cellList = new LinkedList();
            for (int j = 0; j < size; j++) {
                TreeNode treeNode = linkedList.pollLast();
                if (treeNode.left != null) {
                    linkedList.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.push(treeNode.right);
                }
                cellList.add(treeNode.val);
                if (j == size - 1) {
                    result.add(cellList.stream().mapToInt(Integer::intValue).sum());
                }
            }
        }
        System.out.println(Arrays.asList(result));
        int[][] ints=new int[result.size()][result.size()];
        //   0  1  2  3  4  5
        // 0    x     x     x
        // 1 x     x     x
        // 2 x        x     x
        // 3 x     x        x
        // 4
        int a = 0, b = 0;
        for (int i = 0; i < result.size(); i++) {

        }
        return a>b?a:b;
    }

}
