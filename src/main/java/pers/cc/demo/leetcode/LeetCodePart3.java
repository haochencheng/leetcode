package pers.cc.demo.leetcode;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import pers.cc.demo.leetcode.util.TreeNodeUtll;

import java.math.BigDecimal;
import java.util.*;

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

    int tiltSum = 0;

    public int findTilt(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        tiltSum += Math.abs(left - right);
        return root.val + tiltSum;
    }

    @Test
    public void matrixReshape() {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        Arrays.deepToString(matrixReshape(nums, 4, 1));

    }

    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * <p>
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     * <p>
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * <p>
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * 示例 2:
     * <p>
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     * [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * 注意：
     * <p>
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int sourceR = nums.length;
        int sourceC = nums[0].length;
        if (sourceR * sourceC != r * c) {
            return nums;
        }
        int tr = 0;
        int tc = 0;
        int[][] newNums = new int[r][c];
        for (int i = 0; i < sourceR; i++) {
            for (int j = 0; j < sourceC; j++) {
                newNums[tr][tc] = nums[i][j];
                tc++;
                if (tc == c) {
                    tc = 0;
                    tr++;
                    if (tr == r) {
                        tr = 0;
                    }
                }
            }

        }
        return newNums;
    }


    @Test
    public void isSubtree() {
        TreeNode t1 = TreeNodeUtll.fillTreeNode(Arrays.asList(3, 4, 5, 1, 2, null, null, 0));
        TreeNode t2 = TreeNodeUtll.fillTreeNode(Arrays.asList(4, 1, 2));
        System.out.println(isSubtree(t1, t2));

    }

    /**
     * 572. 另一个树的子树
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * <p>
     * 示例 1:
     * 给定的树 s:
     * <p>
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * 给定的树 t：
     * <p>
     * 4
     * / \
     * 1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     * <p>
     * 示例 2:
     * 给定的树 s：
     * <p>
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * /
     * 0
     * 给定的树 t：
     * <p>
     * 4
     * / \
     * 1   2
     * 返回 false
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        boolean flag = false;
        if (s.val == t.val) {
            flag = isSubtree2(s, t);
        }
        return flag || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return (s.val == t.val) && isSubtree2(s.left, t.left) && isSubtree2(s.right, t.right);
        } else {
            return false;
        }
    }

    /**
     * 102. 二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
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
     * <p>
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回锯齿形层次遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (depth % 2 == 1) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
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
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * <p>
     * 给定有序数组: [-10,-3,0,5,9],
     * <p>
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (Objects.isNull(nums)) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, begin, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }

    List<TreeNode> treeNodeList = new LinkedList<>();

    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * <p>
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     * <p>
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        TreeNode treeNode;
        while (head != null) {
            treeNodeList.add(new TreeNode(head.val));
            head = head.next;
        }
        int size = treeNodeList.size();
        treeNode = new TreeNode(treeNodeList.get(size / 2).val);
        treeNode.left = fillTreeNode(null, size / 2 - 1);
        treeNode.right = fillTreeNode(null, size - 1);
        return treeNode;
    }

    public TreeNode fillTreeNode(TreeNode treeNode, int i) {
        if (i < 0 || i == treeNodeList.size() / 2) {
            return treeNode;
        }
        if (Objects.isNull(treeNode)) {
            treeNode = new TreeNode(treeNodeList.get(i).val);
        } else if (Objects.isNull(treeNode.left)) {
            treeNode.left = new TreeNode(treeNodeList.get(i).val);
        } else if (Objects.isNull(treeNode.right)) {
            treeNode.right = new TreeNode(treeNodeList.get(i).val);
        } else {
            fillTreeNode(treeNode.left.left, i);
        }
        i--;
        fillTreeNode(treeNode, i);
        return treeNode;
    }

    @Test
    public void sortedListToBST() {
        int[] ints = {-10, -3, 0, 5, 9};
        ListNode listNode = LeetCodePart1.fillNodeWithArrays(ints);
        System.out.println(sortedListToBST(listNode));
    }

    /**
     * 581. 最短无序连续子数组
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 你找到的子数组应是最短的，请输出它的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 说明 :
     * <p>
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(nums);
        int begin = 0, end = 0;
        boolean b = false, e = false;
        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0; i++, j--) {
            if (b && e) {
                break;
            }
            if (!b) {
                if (nums[i] != tmp[i]) {
                    if (begin == 0) {
                        begin = i;
                        b = true;
                    }
                }
            }
            if (!e) {
                if (nums[j] != tmp[j]) {
                    if (end == 0) {
                        end = j;
                    }
                    e = true;
                }
            }

        }
        return end - begin == 0 ? end - begin : end - begin + 1;
    }

    @Test
    public void findUnsortedSubarray() {
        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(ints));
    }

    /**
     * 575. 分糖果
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: candies = [1,1,2,2,3,3]
     * 输出: 3
     * 解析: 一共有三种种类的糖果，每一种都有两个。
     * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
     * 示例 2 :
     * <p>
     * 输入: candies = [1,1,2,3]
     * 输出: 2
     * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
     * 注意:
     * <p>
     * 数组的长度为[2, 10,000]，并且确定为偶数。
     * 数组中数字的大小在范围[-100,000, 100,000]内。
     */
    public int distributeCandies(int[] candies) {
        Set<Integer> candiesType = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            candiesType.add(candies[i]);
        }
        return Math.min(candiesType.size(), candies.length / 2);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * <p>
     * 例如，给定一个 3叉树 :
     * <p>
     * 返回其前序遍历: [1,3,5,6,2,4]。
     * <p>
     * <p>
     * <p>
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     *
     * @param root
     * @return
     */
    public List<Integer> preorderRes = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return preorderRes;
        }
        preorderRes.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return preorderRes;
    }

    public List<Integer> postorderRes = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return postorderRes;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        postorderRes.add(root.val);
        return postorderRes;
    }

    /**
     * 594. 最长和谐子序列
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
     * <p>
     * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,2,2,5,2,3,7]
     * 输出: 5
     * 原因: 最长的和谐数组是：[3,2,2,2,3].
     * 说明: 输入的数组长度最大不超过20,000.
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        return 0;
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * <p>
     * 示例 3：
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     * <p>
     * 进阶：
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return false;
        }
        ListNode solow = head;
        ListNode fast = head.next;
        while (solow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            solow = solow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。树的根结点代表整个网络。对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
     * <p>
     * 每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
     * <p>
     * 你的任务是使用一个四叉树表示给定的网络。下面的例子将有助于你理解这个问题：
     * <p>
     * 给定下面这个8 x 8 网络，我们将这样建立一个对应的四叉树：
     * <p>
     * <p>
     * <p>
     * 由上文的定义，它能被这样分割：
     * <p>
     * <p>
     * 对应的四叉树应该像下面这样，每个结点由一对 (isLeaf, val) 所代表.
     * <p>
     * 对于非叶子结点，val 可以是任意的，所以使用 * 代替。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * N 将小于 1000 且确保是 2 的整次幂。
     * 如果你想了解更多关于四叉树的知识，你可以参考这个 wiki 页面。
     *
     * @param grid
     * @return
     */
    public Node construct(int[][] grid) {
        return null;
    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }
        if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 输入: 二叉树: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * <p>
     * 输出: "1(2(4))(3)"
     * <p>
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     *
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {

        return null;
    }


    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null != t2 && null != t1) {
            TreeNode node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
            return node;
        } else {
            return t1 == null ? t2 : t1;
        }
    }

    @Test
    public void averageOfLevels() {
//        TreeNode treeNode = TreeNodeUtll.fillTreeNode(Arrays.asList(3, 9, 20, 15, 7));
        TreeNode treeNode = TreeNodeUtll.fillTreeNode(Arrays.asList(3, 1, 5, 0, 2, 4, 6));
        System.out.println(Arrays.deepToString(averageOfLevels(treeNode).toArray()));
    }

    /**
     * 637. 二叉树的层平均值
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出: [3, 14.5, 11]
     * 解释:
     * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
     * 注意：
     * <p>
     * 节点值的范围在32位有符号整数范围内。
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> list = new LinkedList<>();
        list.add(Double.valueOf(root.val));
        SortedMap<Integer, Pair<Integer, Integer>> integerIntegerMap = averageOfLevels(root, 1);
        if (integerIntegerMap == null) {
            return list;
        }
        Set<Map.Entry<Integer, Pair<Integer, Integer>>> entries = integerIntegerMap.entrySet();
        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : entries) {
            Pair<Integer, Integer> value = entry.getValue();
            list.add(BigDecimal.valueOf(value.getKey()).divide(BigDecimal.valueOf(value.getValue()), BigDecimal.ROUND_HALF_EVEN).doubleValue());
        }
        return list;
    }

    SortedMap<Integer, Pair<Integer, Integer>> integerIntegerMap = new TreeMap<>();

    public SortedMap<Integer, Pair<Integer, Integer>> averageOfLevels(TreeNode root, int level) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        int t = 0;
        int j = 0;
        if (root.left != null) {
            t += root.left.val;
            System.out.println(root.left.val);
            j++;
        }
        if (root.right != null) {
            t += root.right.val;
            System.out.println(root.right.val);
            j++;
        }
        Pair<Integer, Integer> pair = integerIntegerMap.get(level);
        if (pair == null) {
            pair = new Pair<>(t, j);
        } else {
            pair.setKey(pair.getKey() + t);
            pair.setValue(pair.getValue() + j);
        }
        integerIntegerMap.put(level, pair);
        int nextLevel = level + 1;
        averageOfLevels(root.left, nextLevel);
        averageOfLevels(root.right, nextLevel);
        return integerIntegerMap;
    }


    /**
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }


    /**
     * 669. 修剪二叉搜索树
     * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
     * 示例 1:
     * <p>
     * 输入:
     * 1
     * / \
     * 0   2
     * <p>
     * L = 1
     * R = 2
     * <p>
     * 输出:
     * 1
     * \
     * 2
     * 示例 2:
     * <p>
     * 输入:
     * 3
     * / \
     * 0   4
     * \
     * 2
     * /
     * 1
     * <p>
     * L = 1
     * R = 3
     * <p>
     * 输出:
     * 3
     * /
     * 2
     * /
     * 1
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        } else if (root.val < L) {
            return trimBST(root.right, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

    /**
     * 872. 叶子相似的树
     * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * <p>
     * <p>
     * <p>
     * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
     * <p>
     * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * <p>
     * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 给定的两颗树可能会有 1 到 100 个结点。
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> list1 = leafSimilar(root1);
        List<Integer> list2 = leafSimilar(root2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    private List<Integer> leafSimilar(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

    /**
     * 897. 递增顺序查找树
     * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
     * <p>
     * <p>
     * <p>
     * 示例 ：
     * <p>
     * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
     * <p>
     * 5
     * / \
     * 3    6
     * / \    \
     * 2   4    8
     * /        / \
     * 1        7   9
     * <p>
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * \
     * 7
     * \
     * 8
     * \
     * 9
     * <p>
     * <p>
     * 提示：
     * <p>
     * 给定树中的结点数介于 1 和 100 之间。
     * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        newRoot = new TreeNode(0);
        dfsIncreasingBST(root);
        return newRoot.right;
    }

    TreeNode newRoot;

    private void dfsIncreasingBST(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsIncreasingBST(root.left);
        newRoot.right = new TreeNode(root.val);
        newRoot = newRoot.right;
        dfsIncreasingBST(root.right);
    }

    /**
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }


    @Test
    public void findSecondMinimumValue() {
        TreeNode treeNode = TreeNodeUtll.fillTreeNode(Arrays.asList(2, 2, 2));
        System.out.println(findSecondMinimumValue(treeNode));
    }

    /**
     * 671. 二叉树中第二小的节点
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return dfsfindSecondMinimumValue(root, root.val);
    }

    public Integer dfsfindSecondMinimumValue(TreeNode root, Integer min) {
        if (root == null) {
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }
        Integer l = dfsfindSecondMinimumValue(root.left, min);
        if (l != -1) {
            return l;
        }
        Integer k = dfsfindSecondMinimumValue(root.right, min);
        if (k != -1) {
            return k;
        }
        return -1;
    }

    @Test
    public void middleNode() {
        ListNode treeNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5, 6));
//        ListNode treeNode = ListNode.fillNode(Arrays.asList(1, 2, 3, 4, 5));
//        ListNode treeNode = ListNode.fillNode(Arrays.asList(65,66,26,77,96,86,11,21,13,80));
        System.out.println(middleNode(treeNode));
    }

    /**
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> linkedHashMap = new LinkedHashMap();
        int count = 0;
        while (head != null) {
            linkedHashMap.put(count, head);
            head = head.next;
            count++;
        }
        int size = linkedHashMap.size();
        int i = linkedHashMap.size() % 2;
        int index = i == 0 ? size / 2 : (size + 1) / 2 - 1;
        return linkedHashMap.get(index);
    }

    /**
     * 598. 范围求和 II
     * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
     * <p>
     * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
     * <p>
     * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * m = 3, n = 3
     * operations = [[2,2],[3,3]]
     * 输出: 4
     * 解释:
     * 初始状态, M =
     * [[0, 0, 0],
     * [0, 0, 0],
     * [0, 0, 0]]
     * <p>
     * 执行完操作 [2,2] 后, M =
     * [[1, 1, 0],
     * [1, 1, 0],
     * [0, 0, 0]]
     * <p>
     * 执行完操作 [3,3] 后, M =
     * [[2, 2, 1],
     * [2, 2, 1],
     * [1, 1, 1]]
     * <p>
     * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
     * 注意:
     * <p>
     * m 和 n 的范围是 [1,40000]。
     * a 的范围是 [1,m]，b 的范围是 [1,n]。
     * 操作数目不超过 10000
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] ints : ops) {
            if (ints[0] < m) {
                m = ints[0];
            }
            if (ints[1] < n) {
                n = ints[1];
            }
        }
        return m * n;
    }


    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * <p>
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        HashMap hashMap = new HashMap();
        ListNode r = head;
        ListNode pre = null;
        while (head != null) {
            int val = head.val;
            if (hashMap.get(val) != null) {
                pre.next = head.next;
            } else {
                pre = head;
                hashMap.put(val, 1);
            }
            head = head.next;
        }
        return r;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    ;

    /**
     * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
     * <p>
     * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
     * <p>
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * 输出: 11
     * 解释:
     * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
     * 注意:
     * <p>
     * 一个员工最多有一个直系领导，但是可以有多个直系下属
     * 员工数量不超过2000。
     *
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < employees.size(); ++i) {
            employeeMap.put(employees.get(i).id, employees.get(i));
        }
        return dfsGetImportance(employeeMap, id);
    }

    public int dfsGetImportance(Map<Integer, Employee> hm, int id) {
        List<Integer> subordinates = hm.get(id).subordinates;
        int res = hm.get(id).importance;
        if (subordinates.size() == 0) {//递归跳出
            return res;
        }
        for (int i = 0; i < subordinates.size(); ++i) {
            res += dfsGetImportance(hm, subordinates.get(i));
        }
        return res;
    }

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int result = -1;
        int start = 0, end = nums.length;
        while (start <= end) {
            //防止溢位
            int mid = start + ((end - start) / 2);
            int hv = nums[mid];
            if (hv > target) {
                end = mid - 1;
            } else if (hv < target) {
                start = mid + 1;
            } else {
                result = mid + 1;
                break;
            }
        }
        return result;
    }

    @Test
    public void search() {
        int[] ints = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(ints, 2));
    }

    /**
     * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
     * <p>
     * 示例：
     * <p>
     * 输入: root = [4,2,6,1,3,null,null]
     * 输出: 1
     * 解释:
     * 注意，root是树结点对象(TreeNode object)，而不是数组。
     * <p>
     * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
     * <p>
     * 4
     * /   \
     * 2      6
     * / \
     * 1   3
     * <p>
     * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
     * 注意：
     * <p>
     * 二叉树的大小范围在 2 到 100。
     * 二叉树总是有效的，每个节点的值都是整数，且不重复。
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        dfsMinDiffInBST(root);
        return min;
    }

    private int min = Integer.MAX_VALUE;
    private TreeNode preNode;

    public void dfsMinDiffInBST(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsMinDiffInBST(root.left);
        int val = root.val;
        if (preNode != null) {
            min = Math.min(Math.abs(val - preNode.val), min);
        }
        preNode = root;
        dfsMinDiffInBST(root.right);
    }

    /**
     * 766. 托普利茨矩阵
     * <p>
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     * <p>
     * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * matrix = [
     * [1,2,3,4],
     * [5,1,2,3],
     * [9,5,1,2]
     * ]
     * 输出: True
     * 解释:
     * 在上述矩阵中, 其对角线为:
     * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
     * 各条对角线上的所有元素均相同, 因此答案是True。
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * matrix = [
     * [1,2],
     * [2,2]
     * ]
     * 输出: False
     * 解释:
     * 对角线"[1, 2]"上的元素不同。
     * 说明:
     * <p>
     * matrix 是一个包含整数的二维数组。
     * matrix 的行数和列数均在 [1, 20]范围内。
     * matrix[i][j] 包含的整数在 [0, 99]范围内。
     * 进阶:
     * <p>
     * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
     * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

            }
        }
        return false;
    }


    /**
     * 682. 棒球比赛
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     * <p>
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["5","2","C","D","+"]
     * 输出: 30
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到2分。总和是：7。
     * 操作1：第2轮的数据无效。总和是：5。
     * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
     * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
     * 示例 2:
     * <p>
     * 输入: ["5","-2","4","C","D","9","+","+"]
     * 输出: 27
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到-2分。总数是：3。
     * 第3轮：你可以得到4分。总和是：7。
     * 操作1：第3轮的数据无效。总数是：3。
     * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
     * 第5轮：你可以得到9分。总数是：8。
     * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
     * 第7轮：你可以得到9 + 5 = 14分。总数是27。
     * 注意：
     * <p>
     * 输入列表的大小将介于1和1000之间。
     * 列表中的每个整数都将介于-30000和30000之间。
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int i;
        for (String o : ops) {
            if ("+".equals(o)) {
                int size = stack.size();
                i = stack.get(size - 1) + stack.get(size - 2);
                stack.add(i);
            } else if ("C".equals(o)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("D".equals(o)) {
                i = stack.peek() * 2;
                stack.add(i);
            } else {
                stack.add(Integer.valueOf(o));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    @Test
    public void calPoints() {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
//        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }


    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<Character>();
        Stack<Character> t = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                s.push(S.charAt(i));
            } else {
                if (s.isEmpty()) {
                    continue;
                } else {
                    s.pop();
                }
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                t.push(T.charAt(i));
            } else {
                if (!t.isEmpty()) {
                    t.pop();
                } else {
                    continue;
                }
            }
        }
        return s.equals(t);
    }


    /**
     * 811. 子域名访问计数
     * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
     * <p>
     * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
     * <p>
     * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
     * <p>
     * 示例 1:
     * 输入:
     * ["9001 discuss.leetcode.com"]
     * 输出:
     * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
     * 说明:
     * 例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
     * 示例 2
     * 输入:
     * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
     * 输出:
     * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
     * 说明:
     * 按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
     * 而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
     * 注意事项：
     * <p>
     * cpdomains 的长度小于 100。
     * 每个域名的长度小于100。
     * 每个域名地址包含一个或两个"."符号。
     * 输入中任意一个域名的访问次数都小于10000
     *
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] s = domain.split(" ");
            String s1 = s[1];
            boolean hasNext = s1.contains(".");
            String substring = s1;
            while (hasNext) {
                hasNext = substring.contains(".");
                Integer integer = map.get(s1);
                if (integer == null) {
                    map.put(s1, Integer.valueOf(s[0]));
                } else {
                    map.put(s1, integer + Integer.valueOf(s[0]));
                }
                substring = s1.substring(s1.indexOf("."));
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            StringBuilder sb = new StringBuilder(entry.getValue() + " ");
            sb.append(entry.getKey());
            list.add(sb.toString());
        }
        return list;
    }

    /**
     * 965. 单值二叉树
     * <p>
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * <p>
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：[1,1,1,1,1,null,1]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：[2,2,2,5,2]
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 给定树的节点数范围是 [1, 100]。
     * 每个节点的值都是整数，范围为 [0, 99] 。
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode root, Integer val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }


    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //二分查找法
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 0;
        long r = x;
        while (l <= r) {
            long mid = (l + r) / 2;
            long i = mid * mid;
            if (i > x) {
                r = mid - 1;
            } else if (i < x) {
                l = mid + 1;
            } else {
                return (int) mid;
            }
        }
        if (l * l < x) {
            return (int) l;
        } else {
            return (int) l - 1;
        }
    }

    @Test
    public void mySqrt() {
        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
    }

    /**
     * 11. 盛最多水的容器
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * @param height
     * @return
     */

    public int maxArea(int[] height) {
        //  暴力O(n^2)
//        int s=0;
//        int x;
//        int length = height.length;
//        for (int i=0; i<length;i++){
//            for (int j=i+1;j<length;j++){
//                x=j-i;
//                int tmp=x*(height[i]>height[j]?height[j]:height[i]);
//                s=tmp>s?tmp:s;
//            }
//        }
//        return s;
        // 指针 O(n)
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

    @Test
    public void maxArea() {
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(ints);
        System.out.println(maxArea(ints));
        Assert.assertTrue(i == 49);
    }

    /**
     * 1043. 分隔数组以得到最大和
     * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
     * <p>
     * 返回给定数组完成分隔后的最大和。
     * <p>
     * 示例：
     * <p>
     * 输入：A = [1,15,7,9,2,5,10], K = 3
     * 输出：84
     * 解释：A 变为 [15,15,15,9,10,10,10]
     * <p>
     * 提示：
     * <p>
     * 1 <= K <= A.length <= 500
     * 0 <= A[i] <= 10^6
     *
     * @param A
     * @param K
     * @return
     */
    public int maxSumAfterPartitioning(int[] A, int K) {
        int l = A.length;
        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            int max = A[i];
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                max = Math.max(max, A[i - j + 1]);
                res[i] = Math.max(res[i], (i - j < 0 ? 0 : res[i - j]) + j * max);
            }
        }
        return res[l - 1];
    }

    @Test
    public void maxSumAfterPartitioning() {
        int[] ints = new int[]{1, 15, 7, 9, 2, 5, 10};
        int i = maxSumAfterPartitioning(ints, 3);
        System.out.println(i);
        Assert.assertTrue(i == 84);
    }

    /**
     * 1024. 视频拼接
     * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
     * <p>
     * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
     * <p>
     * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
     * 输出：3
     * 解释：
     * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
     * 然后，按下面的方案重制比赛片段：
     * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
     * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
     * 示例 2：
     * <p>
     * 输入：clips = [[0,1],[1,2]], T = 5
     * 输出：-1
     * 解释：
     * 我们无法只用 [0,1] 和 [0,2] 覆盖 [0,5] 的整个过程。
     *
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {
        //DT
//        int length = clips.length;
//        int[] dp=new int[T+1];
//        Arrays.fill(dp, T+1);
//        dp[0]=0;
//        for (int i = 0; i < T+1; i++) {
//            for (int j = 0; j < length; j++) {
//                int[] clip = clips[j];
//                if (clip[0] <= i && clip[1] >= i) {
//                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
//                }
//            }
//        }
//        return dp[T]==T+1?-1:dp[T];

        //优先集队列
        Comparator<int[]> comparator = (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        };

        PriorityQueue<int[]> p = new PriorityQueue<>(comparator);
        for (int i = 0; i < clips.length; i++) {
            p.add(clips[i]);
        }
        int ans = 0;
        int cur;
        int next = 0;
        while (next < T && !p.isEmpty() && next >= p.peek()[0]) {
            cur = next;
            ans++;
            while (!p.isEmpty() && p.peek()[0] <= cur) {
                next = Math.max(next, p.poll()[1]);
            }
        }
        if (next < T) {
            return -1;
        } else {
            return ans;
        }
    }

    @Test
    public void videoStitching() {
//        int[][] clips=new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int i = videoStitching(clips, 10);
//        Assert.assertTrue(i==10);
        int[][] clips = new int[][]{{0, 2}, {1, 2}};
        int i = videoStitching(clips, 3);
//        Assert.assertTrue(i==-1);
        System.out.println(i);
    }

    /**
     * 980. 不同路径 III
     * 在二维网格 grid 上，有 4 种类型的方格：
     * <p>
     * 1 表示起始方格。且只有一个起始方格。
     * 2 表示结束方格，且只有一个结束方格。
     * 0 表示我们可以走过的空方格。
     * -1 表示我们无法跨越的障碍。
     * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
     * 输出：2
     * 解释：我们有以下两条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
     * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
     * 示例 2：
     * <p>
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
     * 输出：4
     * 解释：我们有以下四条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
     * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
     * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
     * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
     * 示例 3：
     * <p>
     * 输入：[[0,1],[2,0]]
     * 输出：0
     * 解释：
     * 没有一条路能完全穿过每一个空的方格一次。
     * 请注意，起始和结束方格可以位于网格中的任意位置。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= grid.length * grid[0].length <= 20
     *
     * @param grid
     * @return
     */
    public int uniquePathsIII(int[][] grid) {
        int n = 1;
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    n++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfsUniquePathsIII(grid, sx, sy, n);
    }

    private int dfsUniquePathsIII(int[][] grid, int x, int y, int n) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return n == 0 ? 1 : 0;
        }
        grid[x][y] = -1;
        int paths = dfsUniquePathsIII(grid, x + 1, y, n - 1) +
                dfsUniquePathsIII(grid, x - 1, y, n - 1) +
                dfsUniquePathsIII(grid, x, y + 1, n - 1) +
                dfsUniquePathsIII(grid, x, y - 1, n - 1);
        grid[x][y] = 0;
        return paths;
    }

    @Test
    public void uniquePathsIII() {
        int[][] grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(uniquePathsIII(grid));
    }

    /**
     * 799. 香槟塔
     * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。
     * <p>
     * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
     * <p>
     * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
     * <p>
     * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。
     * 示例 1:
     * 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
     * 输出: 0.0
     * 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。
     * <p>
     * 示例 2:
     * 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
     * 输出: 0.5
     * 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。
     * 注意:
     * <p>
     * poured 的范围[0, 10 ^ 9]。
     * query_glass 和query_row 的范围 [0, 99]。
     *
     * @param poured
     * @param query_row
     * @param query_glass
     * @return
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        //push 从上到下
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j < query_row; j++) {
                double count = dp[i][j] - 1;
                if (count > 0) {
                    dp[i + 1][j] += count / 2;
                    dp[i + 1][j + 1] += count / 2;
                }
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }
//    public double champagneTower(int poured, int query_row, int query_glass) {
//        // 抖机灵 用数学的方法 不能判断 子节点。
//        if (poured==0){
//            return 0;
//        }
//        if (query_row==0&&poured>0){
//            return 1;
//        }
//        int[] preChampagneTower = getPreChampagneTower(poured);
//        if (query_row  < preChampagneTower[0]){
//            return 1;
//        }else if(query_row  >preChampagneTower[0]){
//            return 0;
//        }else{
//            BigDecimal per=BigDecimal.valueOf(poured-preChampagneTower[1]).divide(BigDecimal.valueOf(query_row*2), MathContext.DECIMAL128);
//            if (poured<=3){
//                return per.doubleValue();
//            }
//            //首尾
//            if (query_glass==1||query_glass==query_row+1){
//                double v = per.multiply(BigDecimal.valueOf(2)).doubleValue();
//                return v>1?1:v;
//            }else {
//                return per.doubleValue();
//            }
//        }
//    }
//
//    private int[] getPreChampagneTower(int poured){
//        int sum=0;
//        int[] ints=new int[2];
//        for (int i = 1; i < 50; i++) {
//            sum+=i;
//            if (sum>=poured){
//                ints[0]=i-1;
//                ints[1]=sum-i;
//                return ints;
//            }
//        }
//        return ints;
//    }

    @Test
    public void champagneTower() {
//        System.out.println(champagneTower(1,1,1));
        //0.5
        System.out.println(champagneTower(2, 1, 1));
//        System.out.println(champagneTower(4,2,0)); 0.25
//        System.out.println(champagneTower(4,2,1)); 0.5
//        System.out.println(champagneTower(6,2,1));
    }

    /**
     * 304. 二维区域和检索 - 矩阵不可变
     * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
     * <p>
     * Range Sum Query 2D
     * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
     * <p>
     * 示例:
     * <p>
     * 给定 matrix = [
     * [3, 0, 1, 4, 2],
     * [5, 6, 3, 2, 1],
     * [1, 2, 0, 1, 5],
     * [4, 1, 0, 1, 7],
     * [1, 0, 3, 0, 5]
     * ]
     * <p>
     * sumRegion(2, 1, 4, 3) -> 8
     * sumRegion(1, 1, 2, 2) -> 11
     * sumRegion(1, 2, 2, 4) -> 12
     * 说明:
     * <p>
     * 你可以假设矩阵不可变。
     * 会多次调用 sumRegion 方法。
     * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
     */
    static class NumMatrix {
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix != null && matrix.length != 0) {
                int x = matrix.length;
                int y = matrix[0].length;
                dp = new int[x + 1][y + 1];
                for (int i = 0; i < x; i++) {
                    int sum = 0;
                    for (int j = 0; j < y; j++) {
                        sum += matrix[i][j];
                        dp[i+1][j+1] = i > 0?dp[i][j+1] + sum:sum;
                    }
                }
            }
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1 ] + dp[row1 ][col1];
        }

        public static void main(String[] args) {
            int[][] matrix = new int[][]{
                    {3, 0, 1, 4, 2},
                    {5, 6, 3, 2, 1},
                    {1, 2, 0, 1, 5},
                    {4, 1, 0, 1, 7},
                    {1, 0, 3, 0, 5}
            };
            NumMatrix numMatrix = new NumMatrix(matrix);
            System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        }
    }

    static class MaximalSquare {

        public int maximalSquare(char[][] matrix) {
            int ans=0;
            if (matrix==null || matrix.length==0){
                return ans;
            }
            char[][] dp=new char[matrix.length][matrix[0].length];
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {

                }
            }
            return ans;
        }

        public static void main(String[] args) {
            char[][] matrix = new char[][]{
                    {1, 0, 1, 0, 0},
                    {1, 0, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 0, 0, 1, 0}
            };
            MaximalSquare maximalSquare=new MaximalSquare();
            System.out.println(maximalSquare.maximalSquare(matrix));

        }

    }
}
