package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 652. 寻找重复的子树
 * <p>
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * <p>
 * 示例 1：
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * 下面是两个重复的子树：
 * <p>
 * 2
 * /
 * 4
 * 和
 * <p>
 * 4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-08 14:31
 **/
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, null, 2, 4, null, null, 4);
        List<Integer> list = Arrays.asList(0, 0, 0, 0, null, null, 0, null, null, null, 0);
        TreeNode treeNode = TreeNodeUtil.fillTreeNodeWidth(list);
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees.findDuplicateSubtrees(treeNode);
        System.out.println(Arrays.toString(duplicateSubtrees.toArray()));
    }

    private List<TreeNode> result = new LinkedList<>();
    private ConcurrentMap<String, Integer> nodeMap = new ConcurrentHashMap<>();
    private ConcurrentMap<String, TreeNode> valueMap = new ConcurrentHashMap<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        dfs(root);
        nodeMap.entrySet().forEach(
            entry -> {
                if (entry.getValue() > 1) {
                    result.add(valueMap.get(entry.getKey()));
                }
            }
        );
        return result;
    }


    public String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        String s = root.val + "" + (left + right);
        nodeMap.compute(s, (a, b) -> {
            if (b == null) {
                return 1;
            } else {
                valueMap.putIfAbsent(a, root);
                return b + 1;
            }
        });
        return s;
    }

    //======================超时================//


    private List<TreeNode> nodeList = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtreesTimeOut(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        dfs(root);
        return result;
    }


    public void dfsA(TreeNode root) {
        if (root == null) {
            return;
        }
        // 如何判断 node 相等
        if (contains(root, nodeList) && !contains(root, result)) {
            result.add(root);
        }
        nodeList.add(root);
        dfsA(root.left);
        dfsA(root.right);
    }

    private boolean contains(TreeNode p, List<TreeNode> nodeList) {
        for (TreeNode node : nodeList) {
            if (eq(node, p)) {
                return true;
            }
        }
        return false;
    }

    private boolean eq(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else {
            if (p != null && q != null) {
                return p.val == q.val && eq(p.left, q.left) && eq(p.right, q.right);
            } else {
                return false;
            }
        }
    }

}
