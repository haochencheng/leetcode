package pers.cc.demo.leetcode.tree;

import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 988. 从叶结点开始的最小字符串
 * <p>
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 * <p>
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * <p>
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,1,null,1,0,null,0]
 * 输出："abc"
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树的结点数介于 1 和 8500 之间。
 * 树中的每个结点都有一个介于 0 和 25 之间的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-starting-from-leaf
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: haochencheng
 * @create: 2019-09-19 16:38
 **/
public class SmallestFromLeaf {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(25, 1, 3, 1, 3, 0, 2);
//        List<Integer> list = Arrays.asList(0,1,2,3,4,3,4);
//        List<Integer> list = Arrays.asList(0, null, 1);
//        List<Integer> list = Arrays.asList(2, 2, 1, null, 1, 0, null, 0);
//        List<Integer> list = Arrays.asList(4,0,1,1);
//        List<Integer> list = Arrays.asList(0,1,2,3,4,3,4);
        TreeNode node = TreeNodeUtil.fillTreeNodeWidth(list);
        SmallestFromLeaf smallestFromLeaf = new SmallestFromLeaf();
        System.out.println(smallestFromLeaf.smallestFromLeaf(node));
    }


    private String ans =null;

    public void dfs(TreeNode root, StringBuffer sb) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                sb.insert(0, (char) (root.val + 'a'));
                if (ans == null || sb.toString().compareTo(ans) < 0) {
                    ans = sb.toString();
                }
                sb.deleteCharAt(0);
                return;
            }
            sb.insert(0, (char) (root.val + 'a'));
            dfs(root.left, sb);
            dfs(root.right, sb);
            sb.deleteCharAt(0);
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuffer());
        return ans;
    }


    //  ---------------

    private static char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String smallestFromLeafNO(TreeNode root) {
        return new StringBuilder(dfs(root)).reverse().toString();
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        char rootVal = chars[root.val];
        String leftChar = dfs(root.left);
        String rightChar = dfs(root.right);
        //字典序
        return rootVal+getMinString(leftChar , rightChar);
    }

    private String getMinString(String left, String right) {
        if (left.equals("") && right.equals("")) {
            return "";
        } else if (left.equals("") || right.equals("")) {
            return left.equals("") ? right : left;
        }
        char[] lChars = left.toCharArray();
        char[] rChars = right.toCharArray();
        int length = rChars.length;
        for (int i = 0; i < lChars.length; i++) {
            if (i > length - 1) {
                return right;
            }
            if (lChars[i] < rChars[i]) {
                return left;
            } else if (lChars[i] == rChars[i]) {
                continue;
            } else {
                return right;
            }
        }
        return left;
    }

}
