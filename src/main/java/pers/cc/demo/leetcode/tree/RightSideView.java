package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.FileUtil;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.io.IOException;
import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-04 17:01
 **/
public class RightSideView {

    public static void main(String[] args) throws IOException {
        // 134
//        List<Integer> list = Arrays.asList(1,2,3,null,5,null,4);
        // 12
//        List<Integer> list = Arrays.asList(1,2);
        // 134
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> list = Arrays.asList(1,2,3,null,5,null,4);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        RightSideView rightSideView = new RightSideView();
        System.out.println(Arrays.toString(rightSideView.rightSideView(node).toArray()));
        FileUtil.countFile();
    }

    private List linkedList = new LinkedList();
    private LinkedList<TreeNode> row = new LinkedList();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = size;
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (size == temp) {
                    ans.add(poll.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                size--;
            }
        }
        return ans;
    }

}
