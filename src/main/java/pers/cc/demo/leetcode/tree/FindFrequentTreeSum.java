package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 508. 出现次数最多的子树元素和
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * <p>
 * 示例 1
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * <p>
 * 示例 2
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * <p>
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-06 20:41
 **/
public class FindFrequentTreeSum {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, -3);
        TreeNode root = TreeNodeUtil.fillTreeNodeWidth(list);
        FindFrequentTreeSum findFrequentTreeSum = new FindFrequentTreeSum();
        int[] frequentTreeSum = findFrequentTreeSum.findFrequentTreeSum(root);
        System.out.println(Arrays.toString(frequentTreeSum));
    }



    public int[] findFrequentTreeSum(TreeNode root) {
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap();
        if (root == null) {
            return new int[0];
        }
        dfs(root,hashMap);
        final int[] ints=new int[hashMap.size()];
        AtomicInteger i= new AtomicInteger();
        hashMap.forEachEntry(2, entry -> {
            if (entry.getValue()==max){
                ints[i.getAndIncrement()]=entry.getKey();
            }
        });
        if (i.get() <hashMap.size()){
            return Arrays.copyOf(ints, i.get());
        }
        return ints;
    }

    int max = Integer.MIN_VALUE;

    public int dfs(TreeNode root,ConcurrentHashMap<Integer,Integer> hashMap) {
        if (root == null) {
            return 0;
        }
        int dfsLeft = dfs(root.left,hashMap);
        int dfsRight = dfs(root.right,hashMap);
        int val = root.val + dfsLeft + dfsRight;
        hashMap.compute(val, (a, b) -> {
            if (b == null) {
                max = max > 1 ? max : 1;
                return 1;
            } else {
                b += 1;
                max = max > b ? max : b;
                return b;
            }
        });
        return val;
    }

}
