package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 894. 所有可能的满二叉树
 * <p>
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * <p>
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * <p>
 * 答案中每个树的每个结点都必须有 node.val=0。
 * <p>
 * 你可以按任何顺序返回树的最终列表。
 * <p>
 * 示例：
 * <p>
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-16 13:31
 **/
public class AllPossibleFBT {

    public static void main(String[] args) {

    }

    public List<TreeNode> allPossibleFBT(int N) {
        //偶数直接返回
        if (N % 2 == 0) {
            return new ArrayList<>(1);
        }
        if (N==1){
            TreeNode root=new TreeNode(0);
            ArrayList<TreeNode> res = new ArrayList<>(1);
            res.add(root);
            return res;
        }
        LinkedList res=new LinkedList();
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    res.add(head);
                }
            }
        }
        return res;
    }




}
