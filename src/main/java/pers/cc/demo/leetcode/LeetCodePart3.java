package pers.cc.demo.leetcode;

import org.junit.Test;

public class LeetCodePart3 {

    //538. 把二叉搜索树转换为累加树

    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * <p>
     * 例如：
     * <p>
     * 输入: 二叉搜索树:
     * 5
     * /   \
     * 2     13
     * <p>
     * 输出: 转换为累加树:
     * 18
     * /   \
     * 20     13
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        int pre = 0;
        dfs(root, pre);
        return root;
    }


    public int dfs(TreeNode root, int pre) {
        if (root != null) {
            pre = dfs(root.right, pre);
            root.val = pre + root.val;
            pre = root.val;
            pre = dfs(root.left, pre);
            return pre;
        }
        return pre;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 541. 反转字符串 II
     * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
     * <p>
     * 示例:
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     * 要求:
     * <p>
     * 该字符串只包含小写的英文字母。
     * 给定字符串的长度和 k 在[1, 10000]范围内。
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        class Utils {
            void reverse(char[] str, int start, int end) {
                while (start < end) {
                    char temp = str[start];
                    str[start] = str[end];
                    str[end] = temp;
                    start++;
                    end--;
                }
            }
        }
        Utils utils = new Utils();
        int length = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < length; i += 2 * k) {
            if (i + k >= length) {
                utils.reverse(str, i, length - 1);
            } else {
                utils.reverse(str, i, i + k - 1);
            }
        }
        return new String(str);
    }

    @Test
    public void reverseStr() {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    int lHigh = 1;
    int rHigh = 1;

    /**
     * @param root
     * @return
     */
    int maxNum = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int n = 0;
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        helper(root);
        return maxNum;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left + right > maxNum) {
            maxNum = left + right;
        }
        return left > right ? left + 1 : right + 1;
    }


    /**
     * 551. 学生出勤纪录 I
     * 给定一个字符串来代表一个学生的出勤纪录，这个纪录仅包含以下三个字符：
     *
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     *
     * 你需要根据这个学生的出勤纪录判断他是否会被奖赏。
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        if (s==null||s.equals("")){
            return false;
        }
        int length = s.length();
        int l=0;
        int a=0;
        for (int i = 0; i <length; i++) {
            if (s.charAt(i)=='A'){
               a++;
               if (a>1){
                   return false;
               }
            }
            if (s.charAt(i)=='L'){
                l++;
                if (l>2){
                    return false;
                }
            }else {
                l=0;
            }
        }
        return true;
    }

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例 1:
     *
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s==null||s.equals("")){
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            char[] chars = str.toCharArray();
            for(int i=0,j=chars.length-1;i<j;i++,j--){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            sb.append(new String(chars) + " ");
        }
        return sb.toString().trim();
    }

    @Test
    public void testInt(){
        double i=0.6;
        double j= 0.4;
        double k=i+j;
        int l= (int) (i+j);
        System.out.println(k);
        System.out.println(l);
    }


}
