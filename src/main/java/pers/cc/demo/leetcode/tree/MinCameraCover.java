package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 968. 监控二叉树
 * <p>
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-20 18:13
 **/
public class MinCameraCover {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 0, null, 0, 0);
//        List<Integer> list = Arrays.asList(0, 0, 0);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        MinCameraCover minCameraCover = new MinCameraCover();
        System.out.println(minCameraCover.minCameraCover(treeNode));
    }

    private int result = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfs(root) == 2) {
            result++;
        }
        return result;
    }

    // 1：该节点安装了监视器 2：该节点可观，但没有安装监视器 3：该节点不可观
    public int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 2 || right == 2) {
            result++;
            return 0;
        } else if (left == 0 || right == 0) {
            return 1;
        } else {
            return 2;
        }
    }


}
