package pers.cc.demo.leetcode;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
     * <p>
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     * <p>
     * 你需要根据这个学生的出勤纪录判断他是否会被奖赏。
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        int length = s.length();
        int l = 0;
        int a = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            }
            if (s.charAt(i) == 'L') {
                l++;
                if (l > 2) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            sb.append(new String(chars) + " ");
        }
        return sb.toString().trim();
    }

    @Test
    public void testInt() {
        double i = 0.6;
        double j = 0.4;
        double k = i + j;
        int l = (int) (i + j);
        System.out.println(k);
        System.out.println(l);
    }

    class FourTreeNode {

        public boolean val;
        public boolean isLeaf;
        public FourTreeNode topLeft;
        public FourTreeNode topRight;
        public FourTreeNode bottomLeft;
        public FourTreeNode bottomRight;

        public FourTreeNode() {
        }

        public FourTreeNode(boolean val, boolean isLeaf, FourTreeNode topLeft, FourTreeNode topRight, FourTreeNode bottomLeft, FourTreeNode bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    @Test
    public void intersect() {
        System.out.println(false || true);
    }

    private FourTreeNode intersect(FourTreeNode quadTree1, FourTreeNode quadTree2) {
        if (quadTree1.isLeaf && quadTree1.val) {
            return quadTree1;
        } else if (quadTree2.isLeaf && quadTree2.val) {
            return quadTree2;
        } else if (quadTree1.isLeaf && !quadTree1.val) {
            return quadTree2;
        } else if (quadTree2.isLeaf && !quadTree2.val) {
            return quadTree1;
        } else {
            quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (quadTree1.topLeft.isLeaf && quadTree1.bottomRight.isLeaf && quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf && quadTree1.bottomRight.val == quadTree1.bottomLeft.val && quadTree1.topLeft.val == quadTree1.bottomLeft.val && quadTree1.topRight.val == quadTree1.bottomLeft.val) {
                quadTree1.val = quadTree1.topLeft.val;
                quadTree1.isLeaf = true;
            }
            return quadTree1;
        }
    }

    @Test
    public void findLUSlength() {
        System.out.println(findLUSlength("aaa", "aaa"));
    }

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return a.length() > b.length() ? a.length() : b.length();
    }

    @Builder
    @Data
    static class ThreeNode {
        public int val;
        public List<ThreeNode> children = new ArrayList<>();

        public ThreeNode() {
        }

        public ThreeNode(int val, List<ThreeNode> children) {
            this.val = val;
            this.children = children;
        }
    }

    public int maxDepth(ThreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int max = 0;
        if (!Objects.isNull(root.children)) {
            for (int i = 0; i < root.children.size(); i++) {
                max = Math.max(max, maxDepth(root.children.get(i)));
            }
        }
        return max + 1;
    }

    @Test
    public void maxDepth() {
        ThreeNode node1 = ThreeNode.builder().val(1).build();
        ThreeNode node2 = ThreeNode.builder().children(Arrays.asList(node1)).val(2).build();
        ThreeNode node3 = ThreeNode.builder().children(Arrays.asList(node2)).val(3).build();
        System.out.println(maxDepth(node3));
    }


//    public int arrayPairSum(int[] nums) {
//        nums= Arrays.stream(nums).parallel().sorted().toArray();
//        int sum=0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i%2==0){
//                sum+=nums[i];
//            }
//        }
//        return sum;
//    }

    public int arrayPairSum(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i + 1; j < length / 2; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }


    @Test
    public void arrayPairSum() {
        int[] ints = new int[]{1, 4, 3, 2};
//        int[] ints = new int[]{1,1};
//        int[] ints = new int[]{7,3,1,0,0,6};
        System.out.println(arrayPairSum(ints));
    }

    @Test
    public void findTilt() {

    }

    int tiltSum=0;

    public int findTilt(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left =findTilt(root.left);
        int right =findTilt(root.right);
        tiltSum+= Math.abs(left - right);
        return root.val+tiltSum;
    }

    @Test
    public void matrixReshape() {
        int[][] nums=new int[][]{{1,2},{3,4}};
        Arrays.deepToString(matrixReshape(nums,4,1));

    }

    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     *
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     *
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * 示例 1:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * 示例 2:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     *  [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * 注意：
     *
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int sourceR=nums.length;
        int sourceC=nums[0].length;
        if (sourceR*sourceC!=r*c){
            return nums;
        }
        int tr=0;
        int tc=0;
        int[][] newNums=new int[r][c];
        for (int i = 0; i < sourceR; i++) {
            for (int j = 0; j < sourceC; j++) {
                newNums[tr][tc]=nums[i][j];
                tc++;
                if (tc==c){
                    tc=0;
                    tr++;
                    if (tr==r){
                        tr=0;
                    }
                }
            }

        }
        return newNums;
    }


    @Test
    public void isSubtree() {
        TreeNode t1 = TreeNodeUtll.fillTreeNode(Arrays.asList(3,4,5,1,2,null,null,0));
        TreeNode t2 = TreeNodeUtll.fillTreeNode(Arrays.asList(4,1,2));
        System.out.println(isSubtree(t1,t2));

    }

    /**
     * 572. 另一个树的子树
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     *
     * 示例 1:
     * 给定的树 s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 t：
     *
     *    4
     *   / \
     *  1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     *
     * 示例 2:
     * 给定的树 s：
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     * 给定的树 t：
     *
     *    4
     *   / \
     *  1   2
     * 返回 false
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        boolean flag = false;
        if(s.val == t.val){
            flag = isSubtree2(s,t);
        }
        return flag || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSubtree2(TreeNode s,TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val == t.val) {
            return (s.val == t.val) && isSubtree2(s.left,t.left) && isSubtree2(s.right,t.right);
        } else {
            return false;
        }
    }

    /**
     * 102. 二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }


    @Test
    public void zigzagLevelOrder() {
        TreeNode treeNode = TreeNodeUtll.fillTreeNode(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(zigzagLevelOrder(treeNode));
    }

    /**
     * 103. 二叉树的锯齿形层次遍历
     *
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth =0 ;
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0){
                TreeNode node = queue.poll();
                if(depth%2 == 1){
                    list.add(0,node.val);
                }else{
                    list.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            depth++;
            res.add(list);
        }
        return res;
    }


    /**
     * 108. 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (Objects.isNull(nums)){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int begin,int end) {
        if (begin > end) {
            return null;
        }
        int mid=(begin+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=sortedArrayToBST(nums,begin,mid-1);
        node.right=sortedArrayToBST(nums,mid+1,end);
        return node;
    }





}
