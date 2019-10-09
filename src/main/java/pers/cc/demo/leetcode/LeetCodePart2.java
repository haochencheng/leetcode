package pers.cc.demo.leetcode;

import org.junit.Test;
import pers.cc.demo.leetcode.common.ListNode;
import pers.cc.demo.leetcode.common.Pair;
import pers.cc.demo.leetcode.common.TreeNode;
import pers.cc.demo.leetcode.util.TreeNodeUtil;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class LeetCodePart2 {


    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedBlockingDeque<>();
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }
        if (deque.size() == 1) {
            return true;
        }
        while (!deque.isEmpty() && deque.size() > 1) {
            final Integer integer = deque.pollFirst();
            final Integer integer1 = deque.pollLast();
            if (integer.intValue() != integer1.intValue()) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void isPalindrome() {
        ListNode head = new ListNode(-129);
        ListNode head1 = new ListNode(-129);
        head.next = head1;
        System.out.println(isPalindrome(head));
    }




    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        if (left != null && right != null) {
            if (left.val == p.val && right.val == q.val) {
                return root;
            }
            lowestCommonAncestor(left, p, q);
            lowestCommonAncestor(right, p, q);
        }
        return null;
    }


    public void printTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();

                if (head.left != null) {
                    queue.offer(head.left);
                    result.add(head.left.val);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                    result.add(head.right.val);
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    @Test
    public void lowestCommonAncestor() {
//        int[] nums = new int[]{6,2,8,0,4,7,9,0,0,3,5};
        final TreeNode root = TreeNodeUtil.fillTreeNode(Arrays.asList(6, 2, 8, 0, 4, 7, 9, 0, 0, 3, 5));
        printTreeNode(root);
//        System.out.println(lowestCommonAncestor(root,new TreeNode(2),new TreeNode(8)).val);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
    }

    /**
     * 237. 删除链表中的节点
     * <p>
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * <p>
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * <p>
     * 4 -> 5 -> 1 -> 9
     * 示例 1:
     * <p>
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * <p>
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    @Test
    public void isAnagram() {
        int[] sArray = new int[5];
        sArray[3]++;
        sArray[1]++;
        System.out.println(Arrays.toString(sArray));
    }

    /**
     * 257. 二叉树的所有路径
     * <p>
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * <p>
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        iterator(root, list, "");
        return list;
    }

    public void iterator(TreeNode root, List<String> list, String string) {
        string += root.val + " ";
        if (root.left == null && root.right == null) {
            list.add(string.trim().replace(" ", "->"));
        }
        if (root.left != null)
            iterator(root.left, list, string);

        if (root.right != null)
            iterator(root.right, list, string);

    }

    /**
     * 258. 各位相加
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     * <p>
     * 示例:
     * <p>
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        String s = String.valueOf(num);
        final String[] split = s.split("");
        int i = 0;
        for (String a : split) {
            i += Integer.valueOf(a);
        }
        if (i < 10) {
            return i;
        }
        return addDigits(i);
    }

    @Test
    public void addDigits() {
        System.out.println(addDigits(38));
    }

    /**
     * 263. 丑数
     * <p>
     * 编写一个程序判断给定的数是否为丑数。
     * <p>
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 6
     * 输出: true
     * 解释: 6 = 2 × 3
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: true
     * 解释: 8 = 2 × 2 × 2
     * 示例 3:
     * <p>
     * 输入: 14
     * 输出: false
     * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num == -1) {
            return false;
        }
        final int i = num / 2;

        if (i + i == num) {
            c++;
            return isUgly(i);
        }
        final int j = num / 3;
        if (j + j + j == num) {
            c++;
            return isUgly(j);
        }
        final int k = num / 5;
        if (k + k + k + k + k == num) {
            c++;
            return isUgly(k);
        }
        if (num % 7 == 0) {
            return false;
        }
        if (c == 0) {
            return false;
        }
        return true;
    }

    int c = 0;

    @Test
    public void isUgly() {
//        System.out.println(isUgly(-2147483648));
        System.out.println(isUgly(-51799));
    }


    /**
     * 264. 丑数 II
     * <p>
     * 编写一个程序，找出第 n 个丑数。
     * <p>
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     * <p>
     * 示例:
     * <p>
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 说明:
     * <p>
     * 1 是丑数。
     * n 不超过1690。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int c = 0;
        int i = 0;
        while (c < n + 1) {
            i++;
            if (isUgly(i)) {
                c++;
            }
        }
        return i;
    }

    @Test
    public void nthUglyNumber() {
        System.out.println(nthUglyNumber(10));
    }

    /**
     * 268. 缺失数字
     * <p>
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        final int length = nums.length;
        int[] a = new int[length + 1];
        for (int i = 0; i < length; i++) {
            final int num = nums[i];
            a[num] = 1;
        }
        for (int i = 1; i < length + 1; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void missingNumber() {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }


    public int firstMissingPositive(int[] nums) {
        return 1;
    }

    /**
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        final int i = n / 2;
        if (isBadVersion(i)) {
            return firstBadVersion(1, i);
        } else {
            return firstBadVersion(i, n);
        }
    }

    public int firstBadVersion(int a, int b) {
        int c = a + (b - a) / 2;
        if (!isBadVersion(c)) {
            if (b == (c + 1)) {
                return b;
            } else {
                return firstBadVersion(c, b);
            }
        } else {
            if (c == (a + 1)) {
                return c;
            } else {
                return firstBadVersion(a, c);
            }
        }
    }


    public boolean isBadVersion(int n) {
        return false;
    }

    /**
     * 283. 移动零
     * <p>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < length - 1; j++) {
                    if (nums[j + 1] != 0) {
                        nums[i] = nums[j + 1];
                        nums[j + 1] = 0;
                        break;
                    }
                }
            }
        }

    }

    @Test
    public void moveZeroes() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{0, 0,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 290. 单词模式
     * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
     * <p>
     * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
     * <p>
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        final String[] split = str.split(" ");
        final int length = split.length;
        if (length != pattern.length()) {
            return false;
        }
        Set<String> strings = new HashSet<>();
        Map<String, String> map = new HashMap<>(Double.valueOf(1.5 * length).intValue());
        for (int i = 0; i < length; i++) {
            final char c = pattern.charAt(i);
            final String s = map.get(String.valueOf(c));
            if (s == null) {
                if (strings.contains(split[i])) {
                    return false;
                }
                strings.add(split[i]);
                map.put(String.valueOf(c), split[i]);
            } else {
                if (!s.equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void wordPattern() {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba","dog dog dog dog"));
    }

    /**
     * 292. Nim游戏
     * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
     * <p>
     * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
     * <p>
     * 示例:
     * <p>
     * 输入: 4
     * 输出: false
     * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
     * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    @Test
    public void canWinNim() {
        System.out.println(canWinNim(1348820));
    }

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        Map<String, Integer> map = new HashMap<>();

        public int sumRange(int i, int j) {
            String s = i + "" + j;
            int l = 0;
            if (map.get(s) == null) {
                for (int k = i; k < j + 1; k++) {
                    l += nums[k];
                }
            } else {
                l = map.get(s);
            }
            return l;
        }
    }

    /**
     * 344. 反转字符串
     * <p>
     * 请编写一个函数，其功能是将输入的字符串反转过来。
     * <p>
     * 示例：
     * <p>
     * 输入：s = "hello"
     * 返回："olleh"
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    @Test
    public void reverseString() {

    }

    /**
     * 345. 反转字符串中的元音字母
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * <p>
     * 示例 1：
     * 给定 s = "hello", 返回 "holle".
     * <p>
     * 示例 2：
     * 给定 s = "leetcode", 返回 "leotcede".
     * <p>
     * 注意:
     * 元音字母不包括 "y".
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        final int length = s.length();
        String[] ss = new String[length];
        int count = length - 1;
        for (int i = 0; i < length; i++) {
            final String c = String.valueOf(s.charAt(i));
            if (isVowels(c)) {
                for (int j = count; j >= 0; j--) {
                    final String d = String.valueOf(s.charAt(j));
                    if (isVowels(d)) {
                        ss[i] = d;
                        ss[j] = c;
                        count = j - 1;
                        break;
                    }
                }
            } else {
                ss[i] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ss[i]);
        }
        return sb.toString();
    }

    private boolean isVowels(String s) {
        return s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u");
    }

    @Test
    public void reverseVowels() {
        System.out.println(reverseVowels("leetcode"));
    }

    /**
     * 349. 两个数组的交集
     * 给定两个数组，写一个函数来计算它们的交集。
     * <p>
     * 例子:
     * <p>
     * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
     * <p>
     * 提示:
     * <p>
     * 每个在结果中的元素必定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break;
                }
            }
        }
        int[] ints = new int[set.size()];
        final Iterator<Integer> iterator = set.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            ints[count] = iterator.next().intValue();
            count++;
        }
        return ints;
    }

    @Test
    public void intersection() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    /**
     * 350. 两个数组的交集 II
     * <p>
     * 给定两个数组，写一个方法来计算它们的交集。
     * <p>
     * 例如:
     * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
     * <p>
     * 注意：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 跟进:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                final int i1 = nums1[i];
                if (i1 == nums2[j]) {
                    final Integer integer = map.get(i1);
                    if (integer != null) {
                        map.put(i1, integer + 1);
                    } else {
                        map.put(i1, 1);
                    }
                    break;
                }
            }
        }
        int[] ints = new int[map.size()];
        final Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int count = 0;
        for (Map.Entry<Integer, Integer> iterator : entries) {
            ints[count] = iterator.getValue();
            count++;
        }
        return ints;
    }

    @Test
    public void intersect() {
//        int[] nums1=new int[]{1, 2, 2, 1};
//        int[] nums2=new int[]{2, 2};
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    /**
     * 367. 有效的完全平方数
     * <p>
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * <p>
     * 注意：不要使用任何内置的库函数，如  sqrt。
     * 示例 1：
     * 输入： 16
     * 输出： True
     * 示例 2：
     * 输入： 14
     * 输出： False
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        for (int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }

    /**
     * 不使用运算符 + 和-，计算两整数a 、b之和。
     * <p>
     * 示例：
     * 若 a = 1 ，b = 2，返回 3。
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        return getSum(sum, carry);
    }

    @Test
    public void getSum() {
        System.out.println(getSum(11, 223));
    }

    /**
     * 374. 猜数字大小
     * <p>
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     * 每次你猜错了，我会告诉你这个数字是大了还是小了。
     * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     * -1 : 我的数字比较小
     * 1 : 我的数字比较大
     * 0 : 恭喜！你猜对了！
     * 示例:
     * n = 10, 我选择 6.
     * 返回 6.
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return guessNumber(1, n);
    }

    public int guessNumber(int a, int b) {
        final int guess = guess(a);
        final int guess1 = guess(b);
        if (guess == 0) {
            return a;
        }
        if (guess1 == 0) {
            return b;
        }
        if ((b - a) == 2) {
            return a + 1;
        }
        final int i = (a + b) / 2;
        final int guess2 = guess(i);
        if (guess2 == 0) {
            return i;
        } else if (guess2 == -1) {
            return guessNumber(i, b);
        } else {
            return guessNumber(a, i);
        }
    }

    public int guess(int num) {
        if (num > 3) {
            return 1;
        }
        if (num == 3) {
            return 0;
        } else {
            return -1;
        }
    }

    @Test
    public void guessNumber() {
        System.out.println(guessNumber(4));
    }

    /**
     * 383. 赎金信
     * <p>
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     * <p>
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
     * <p>
     * 注意：
     * <p>
     * 你可以假设两个字符串均只含有小写字母。
     * <p>
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        final int length = ransomNote.length();
        final int len1 = magazine.length();
        if (len1 < length) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>(Double.valueOf(1.5 * length).intValue());
        for (int i = 0; i < len1; i++) {
            final String s = String.valueOf(magazine.charAt(i));
            final Integer integer = map.get(s);
            if (integer == null) {
                map.put(s, 1);
            } else {
                map.put(s, integer + 1);
            }
        }
        for (int i = 0; i < length; i++) {
            final String s = String.valueOf(ransomNote.charAt(i));
            Integer integer = map.get(s);
            if (integer == null) {
                return false;
            }
            integer--;
            if (integer < 0) {
                return false;
            }
            map.put(s, integer);
        }
        return true;
    }

    @Test
    public void canConstruct() {
        System.out.println(canConstruct("a", "b"));
//        System.out.println( canConstruct("aa", "ab"));
//        System.out.println( canConstruct("bg", "efjbdfbdgfjhha"));
    }


    /**
     * 387. 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * 案例:
     * <p>
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        final int len = s.length();
        if (len == 1) {
            return 0;
        }
        Map<String, Integer> map = new LinkedHashMap<>(45);
        for (int i = 0; i < len; i++) {
            final char c = s.charAt(i);
            final Integer integer = map.get(String.valueOf(c));
            if (integer == null) {
                map.put(String.valueOf(c), i);
            } else {
                map.put(String.valueOf(c), -1);
            }
        }
        final Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }

    @Test
    public void firstUniqChar() {
//        System.out.println(firstUniqChar("leetcode"));
//        System.out.println(firstUniqChar("loveleetcode"));
//        System.out.println(firstUniqChar("cc"));
        System.out.println(firstUniqChar("aadadaadc"));
    }

    /**
     * 389. 找不同
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     * 示例:
     * 输入：
     * s = "abcd"
     * t = "abcde"
     * <p>
     * 输出：
     * e
     * <p>
     * 解释：
     * 'e' 是那个被添加的字母。
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char tmp = 0x00;
        for (int i = 0; i < s.length(); i++) {
            tmp = (char) (tmp ^ s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            tmp = (char) (tmp ^ t.charAt(i));
        }

        return tmp;
//        HashMap<Character, Integer> map=new HashMap<>();
//        char ch1[]=s.toCharArray();
//        for(int i=0;i<ch1.length;i++) {
//            if(map.containsKey(ch1[i])) {
//                map.put(ch1[i], map.get(ch1[i])+1);
//            }else {
//                map.put(ch1[i], 1);
//            }
//        }
//
//        char ch2[]=t.toCharArray();
//        for(int i=0;i<ch2.length;i++) {
//            if(map.containsKey(ch2[i])) {
//                map.put(ch2[i], map.get(ch2[i])-1);
//                if(map.get(ch2[i])==0)
//                    map.remove(ch2[i]);
//            }else
//                return ch2[i];
//        }
//        return 0;

    }

    @Test
    public void findTheDifference() {
        System.out.println(findTheDifference("abcde", "abcdef"));
    }


    /**
     * 401. 二进制手表
     * <p>
     * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
     * <p>
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     * <p>
     * 例如，上面的二进制手表读取 “3:25”。
     * <p>
     * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
     * <p>
     * 案例:
     * <p>
     * 输入: n = 1
     * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        int[][] nums = new int[4][6];
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final int i1 = num - i;
            if (i1 >= 0 && i1 <= 6) {
                System.out.println(i + "-" + i1);
            }
        }
        return strings;
    }

    @Test
    public void readBinaryWatch() {
        readBinaryWatch(4);
        System.out.println(1612321312 >>> 8);
    }

    /**
     * 404. 左叶子之和
     * 计算给定二叉树的所有左叶子之和。
     * <p>
     * 示例：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        return sumOfLeftLeaves(root, sum);
    }

    public int sumOfLeftLeaves(TreeNode root, int sum) {
        if (root == null) return sum;
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        if (left != null && left.left == null && left.right == null) {
            sum += left.val;
        }
        sum = sumOfLeftLeaves(left, sum);
        sum = sumOfLeftLeaves(right, sum);
        return sum;
    }

    @Test
    public void sumOfLeftLeaves() {
        List<Integer> list = Arrays.asList(3, 9, 20, 15, 7);
        final TreeNode treeNode = TreeNodeUtil.fillTreeNode(list);
        System.out.println(sumOfLeftLeaves(treeNode));
    }


    /**
     * 222. 完全二叉树的节点个数
     * <p>
     * 给出一个完全二叉树，求出该树的节点个数。
     * <p>
     * 说明：
     * <p>
     * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * 1
     * / \
     * 2   3
     * / \  /
     * 4  5 6
     * <p>
     * 输出: 6
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return 0;
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            final TreeNode pop = stack.pop();
//            final TreeNode left = pop.left;
//            final TreeNode right = pop.right;
//            if (left!=null){
//                count++;
//                stack.push(left);
//            }
//            if (right!=null){
//                count++;
//                stack.push(right);
//            }
//        }
//        return count;
        count = countNodes(root, count);
        return count;
    }

    public int countNodes(TreeNode root, int count) {
        if (root != null) {
            count++;
        } else {
            return count;
        }
        final TreeNode left = root.left;
        if (left != null) {
            count = countNodes(left, count);
        }
        return count;
    }

    @Test
    public void countNodes() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        final TreeNode treeNode = TreeNodeUtil.fillTreeNode(list);
        System.out.println(countNodes(treeNode));
    }

    public String toHex(int num) {
        char[] digest = new char[]{
                1, 2, 3, 4, 5, 6, 7, 8,
                'a', 'b', 'c', 'd', 'e', 'f'
        };

        return "";
    }

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        final Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int count = 0;
        boolean isAdd = false;
        for (Map.Entry<Character, Integer> entry : entries) {
            final int i = entry.getValue() / 2;
            if (entry.getValue() % 2 != 0 && !isAdd) {
                isAdd = true;
            }
            count += i * 2;
        }
        if (isAdd) {
            count++;
        }
        return count;
    }

    @Test
    public void longestPalindrome() {
//        System.out.println(longestPalindrome("dccaccd"));
        System.out.println(longestPalindrome("bb"));
    }


    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if ((i / 15) * 15 == i) {
                list.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                list.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                list.add("Buzz");
                continue;
            }
            list.add(String.valueOf(i));
        }
        return list;
    }


    public int thirdMax(int[] nums) {
        final int length = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        if (length == 1) return nums[0];
        if (length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 0; i < length; i++) {
            if (list.size() >= 3) {
                break;
            }
            for (int j = i + 1; j <= length - 1; j++) {
                final int num = nums[i];
                final int num1 = nums[j];
                if (num < num1) {
                    nums[i] = num1;
                    nums[j] = num;
                }
            }
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }

        }
        if (list.size() >= 3) {
            return list.pollLast();
        }
        return list.pollFirst();
    }

    @Test
    public void thirdMax() {
//        int[] nums=new int[]{1,2,3,4,5};
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }


    /**
     * 415. 字符串相加
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * <p>
     * 注意：
     * <p>
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        final int len1 = num1.length();
        final int len2 = num2.length();
        final char[] chars1 = num1.toCharArray();
        final char[] chars2 = num2.toCharArray();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < len1; i++) {
            stack1.add(Integer.valueOf(chars1[i] - 48));
        }
        for (int i = 0; i < len2; i++) {
            stack2.add(Integer.valueOf(chars2[i] - 48));
        }
        StringBuilder sb = new StringBuilder();
        boolean isAdd = false;
        int i;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                final Integer pop1 = stack1.pop();
                final Integer pop2 = stack2.pop();
                i = pop2 + pop1;
            } else if (stack1.isEmpty() && !stack2.isEmpty()) {
                i = stack2.pop();
            } else {
                i = stack1.pop();
            }
            if (isAdd) {
                i++;
            }
            if (i >= 10) {
                i = i - 10;
                isAdd = true;
            } else {
                isAdd = false;
            }
            sb.append(i);
        }
        if (isAdd) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    @Test
    public void addStrings() {
        System.out.println(addStrings("123", "45678"));
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
     * 429. N叉树的层序遍历
     * 给定一个N叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * <p>
     * 例如，给定一个 3叉树 :
     * 1
     * 3   2    4
     * 5   6
     * <p>
     * 返回其层序遍历:
     * <p>
     * [
     * [1],
     * [3,2,4],
     * [5,6]
     * ]
     * <p>
     * 说明:
     * <p>
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Stack<Pair<Integer, Node>> stack = new Stack<>();
        Pair<Integer, Node> pair = new Pair<>(1, root);
        stack.push(pair);
        List<List<Integer>> lists = new LinkedList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        while (!stack.isEmpty()) {
            final Pair<Integer, Node> pop = stack.pop();
            final Integer key = pop.getKey();
            final Node value = pop.getValue();
            List<Integer> list1;
            if (hashMap.containsKey(key)) {
                list1 = hashMap.get(key);
                list1.add(value.val);
            } else {
                list1 = new LinkedList<>();
                list1.add(value.val);
            }
            hashMap.put(key, list1);
            final List<Node> children = value.children;
            if (children != null) {
                Collections.reverse(children);
                children.forEach(a -> {
                    stack.push(new Pair<>(key + 1, a));
                });
            }
        }
        final Set<Map.Entry<Integer, List<Integer>>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            lists.add(entry.getValue());
        }
        return lists;
    }

    /**
     * 434. 字符串中的单词数
     * <p>
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * 示例:
     * 输入: "Hello, my name is John"
     * 输出: 5
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        if (s == null || s.equalsIgnoreCase("")) {
            return 0;
        }
        final char[] chars = s.toCharArray();
        final int length = chars.length;
        boolean isT = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] != ' ') {
                sb.append(chars[i]);
                isT = false;
            } else {
                if (i + 1 < length && chars[i + 1] != ' ' && sb.length() != 0) {
                    sb.append(' ');
                }
            }
        }
        if (isT) return 0;
        System.out.println(sb.toString());
        return sb.toString().split(" ").length;
    }

    @Test
    public void countSegments() {
//        String s="a   ,  . b   ac  ads       asd";
//        String s="a, b, c";
        String s = "    foo    bar";
        System.out.println(countSegments(s));
    }

    /**
     * 437. 路径总和 III
     * <p>
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * <p>
     * 找出路径和等于给定数值的路径总数。
     * <p>
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     * 示例：
     * <p>
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * 返回 3。和等于 8 的路径有:
     * <p>
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfsPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int dfsPathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) return count;
        if (root.val == sum) count++;
        count += dfsPathSum(root.left, sum - root.val);
        count += dfsPathSum(root.right, sum - root.val);
        return count;
    }

    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int[] nums = new int[1001];
        int i = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            nums[i] = pop.val;
            i++;
            TreeNode left = pop.left;
            TreeNode right = pop.right;
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }
        }
        Stack<Integer> stack1 = new Stack<>();
        int count = 0;
        int sum1 = populateSubset(nums, 0, i, 0, sum, stack1, count);
        return sum1;
    }


    public int populateSubset(int[] values, int begin, int end,
                              int sumInStack, int expectedSum, Stack<Integer> stack, int count) {

        /*
         * 判断Stack中的数据和是否等于目标值，如果是则输出当前Stack中的数据
         */
        if (sumInStack == expectedSum) {
            count++;
            print(stack, expectedSum);
        }

        for (int currentIndex = begin; currentIndex < end; currentIndex++) {
            /*
             * 如果当前Stack中的和加上当前index的数据小于等于目标值， 那么将当前的index的数据添加到Stack中去，
             * 同时，将当前Stack中所有数据的和加上新添加到Stack中的数值
             */
            if (sumInStack + values[currentIndex] <= expectedSum) {
                stack.push(values[currentIndex]);
                sumInStack += values[currentIndex];
                // 当前index加上1，递归调用本身
                count = populateSubset(values, currentIndex + 1, end, sumInStack,
                        expectedSum, stack, count);

                sumInStack -= stack.pop();
            }
        }
        return count;
    }

    /**
     * 打印符合条件的子集数据 如：15 = 1+2+4+6+2
     *
     * @param stack
     * @param expectedSum
     */
    private void print(Stack<Integer> stack, int expectedSum) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append(expectedSum + " = ");
        for (int element : stack) {
            sb.append(element + "+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }


    @Test
    public void pathSum() {
        List<Integer> list = Arrays.asList(10, 5, -3, 3, 2, 11, 3, -2, 1);
        final TreeNode treeNode = TreeNodeUtil.fillTreeNode(list);
        System.out.println(pathSum(treeNode, 8));
    }

    @Test
    public void excute() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ArrayList<String> child = new ArrayList<>();
        List<ArrayList<String>> result = new ArrayList<>();
        getSubList(list, 0, child, result);
        System.out.println("真子集 " + result.size() + " 个");
        for (List<String> results : result) {
            System.out.println(results);
        }
    }

    /**
     * 递归查找真子集
     *
     * @param resourses 数据源
     * @param nonius    游标
     * @param childs    临时子集
     * @param results   结果集
     */
    public void getSubList(List<String> resourses, int nonius, ArrayList<String> childs, List<ArrayList<String>> results) {
        for (int i = nonius; i < resourses.size(); i++) {
            // 去掉自己本身
            if (childs.size() < resourses.size() - 1) {
                // 将数据源中的每个元素分别拿出来
                childs.add(resourses.get(i));
                // 将每个元素的集合作为元素放入结果集合
                results.add(new ArrayList<>(childs));
                // 递归向后移动
                getSubList(resourses, i + 1, childs, results);
                // 移除
                childs.remove(childs.size() - 1);
            }
        }
    }

    /**
     * 438. 找到字符串中所有字母异位词
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     * 说明：
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     * 输入:
     * s: "cbaebabacd" p: "abc"
     * 输出:
     * [0, 6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     * 示例 2:
     * 输入:
     * s: "abab" p: "ab"
     * 输出:
     * [0, 1, 2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n)
            return list;
        for (int i = 0; i <= m - n; i++) {
            int[] t = new int[26];
            for (int j = 0; j < n; j++) {
                t[s.charAt(i + j) - 'a']++;
                t[p.charAt(j) - 'a']--;
            }
            boolean flag = true;
            for (int j = 0; j < t.length; j++) {
                if (t[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(i);
        }
        return list;
    }


    @Test
    public void findAnagrams() {
//        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    /**
     * 441. 排列硬币
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * <p>
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * <p>
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     * <p>
     * 示例 1:
     * <p>
     * n = 5
     * <p>
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤
     * <p>
     * 因为第三行不完整，所以返回2.
     * 示例 2:
     * <p>
     * n = 8
     * <p>
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     * <p>
     * ¤ ¤ ¤ ¤
     * ¤ ¤ ¤ ¤
     * ¤ ¤ ¤ ¤
     * ¤ ¤ ¤ ¤
     * 因为第四行不完整，所以返回3.
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        if (n <= 1) return n;
        long low = 1, high = n;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid * (mid + 1) / 2 <= n) low = mid + 1;
            else high = mid;
        }
        return Long.valueOf(low - 1).intValue();
    }

    @Test
    public void arrangeCoins() {
//        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(16));
    }

    /**
     * 443. 压缩字符串
     * 给定一组字符，使用原地算法将其压缩。
     * <p>
     * 压缩后的长度必须始终小于或等于原数组长度。
     * <p>
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * <p>
     * 在完成原地修改输入数组后，返回数组的新长度。
     * <p>
     * <p>
     * <p>
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["a","a","b","b","c","c","c"]
     * <p>
     * 输出：
     * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
     * <p>
     * 说明：
     * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
     * 示例 2：
     * <p>
     * 输入：
     * ["a"]
     * <p>
     * 输出：
     * 返回1，输入数组的前1个字符应该是：["a"]
     * <p>
     * 说明：
     * 没有任何字符串被替代。
     * 示例 3：
     * <p>
     * 输入：
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * <p>
     * 输出：
     * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
     * <p>
     * 说明：
     * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
     * 注意每个数字在数组中都有它自己的位置。
     * 注意：
     * <p>
     * 所有字符都有一个ASCII值在[35, 126]区间内。
     * 1 <= len(chars) <= 1000。
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        final int length = chars.length;
        if (length == 1) return 1;
        StringBuilder sb = new StringBuilder();
        int c = 1;
        for (int i = 0; i < length - 1; i++) {
            char aChar = chars[i];
            char bChar = chars[i + 1];
            if (aChar == bChar) {
                c++;
                if (i == length - 2) {
                    sb.append(bChar);
                    sb.append(c);
                }
            } else {
                sb.append(aChar);
                if (c != 1) {
                    sb.append(c);
                    c = 1;
                }
                if (i == length - 2) {
                    sb.append(bChar);
                }
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        System.out.println(chars);
        return sb.toString().length();
    }

    @Test
    public void compress() {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] chars=new char[]{'a','a','c'};
        System.out.println(compress(chars));
    }

    /**
     * 447. 回旋镖的数量
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     * 示例:
     * 输入:
     * [[0,0],[1,0],[2,0]]
     * <p>
     * 输出:
     * 2
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     *
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        /**
         * 1、首先固定一个点，然后求其他点到这个点的距离集合，
         2、在这个距离集合中，相等距离的有m个，则回旋镖数就有组合C(m, 2) * 2个，
         */
        int result = 0;
        for (int[] pointA : points) {
            Map<Integer, Integer> distances = new HashMap<>();
            for (int[] pointB : points) {
                int distance = (pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]);
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            for (int item : distances.values()) {
                result += item * (item - 1);
            }
        }
        return result;
    }

    @Test
    public void numberOfBoomerangs() {
        int[][] points = new int[][]{{1, 0}, {0, 0}, {2, 0}};
        //123 132 321 312
        //1234 1243 1324 1342 1423 1432
        System.out.println(numberOfBoomerangs(points));
    }


    /**
     * 448. 找到所有数组中消失的数字
     * <p>
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * 示例:
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int len = nums.length;
        int c = 0;
        for (int i = 1; i <= len; i++) {
            boolean a = true;
            for (int j = c; j < len; j++) {
                if (i == nums[j]) {
                    a = false;
                    final int num = nums[c];
                    nums[c] = i;
                    c++;
                    nums[j] = num;
                    break;
                }
            }
            if (a) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < len; j++) {
            set.add(nums[j]);
        }
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void findDisappearedNumbers() {
//        int[] nums=new int[]{4,3,2,7,8,2,3,1};
        int[] nums = new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        System.out.println(findDisappearedNumbers(nums));
    }


    /**
     * 453. 最小移动次数使数组元素相等
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
     * 示例:
     * 输入:
     * [1,2,3]
     * 输出:
     * 3
     * 解释:
     * 只需要3次移动（注意每次移动会增加两个元素的值）：
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     * [1,2,3,4]  =>  [2,3,4,4]  =>  [3,4,5,4]  =>  [5,5,5,5]
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }
        return sum - min * nums.length;
    }

    @Test
    public void minMoves() {
        int[] nums = new int[]{83, 86, 77, 15, 93, 35, 86, 92, 49, 21};
        System.out.println(minMoves(nums));
    }

    /**
     * 455. 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * 注意：
     * 你可以假设胃口值为正。
     * 一个小朋友最多只能拥有一块饼干。
     * 示例 1:
     * 输入: [1,2,3], [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     * 输入: [1,2], [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        final int gLen = g.length;
        final int sLen = s.length;
        g = sort(g);
        s = sort(s);
        int c = 0;
        int index = 0;
        for (int j = c; j < sLen; j++) {
            if (s[j] >= g[index]) {
                c++;
                index++;
                if (index >= gLen) {
                    break;
                }
            }

        }
        return c;
    }

    public int[] sort(int nums[]) {
        final int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    int i1 = nums[i];
                    nums[i] = nums[j];
                    nums[j] = i1;
                }
            }
        }
        return nums;
    }


    @Test
    public void findContentChildren() {
//        int[] g=new int[]{1,2,3};
//        int[] s=new int[]{1,1};
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    /**
     * 458. 可怜的小猪
     * 有1000只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在15分钟内死去。
     * 问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
     * 回答这个问题，并为下列的进阶问题编写一个通用算法。
     * 进阶:
     * 假设有 n 只水桶，猪饮水中毒后会在 m 分钟内死亡，你需要多少猪（x）就能在 p 分钟内找出“有毒”水桶？n只水桶里有且仅有一只有毒的桶。
     *
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (minutesToTest < minutesToDie) return 0;
        if (minutesToTest == minutesToDie) return buckets;
        final int i = minutesToTest / minutesToDie;
        return buckets / i;
    }

    @Test
    public void poorPigs() {
        System.out.println(poorPigs(1000, 1, 60));
    }

    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abab"
     * <p>
     * 输出: True
     * <p>
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * 示例 2:
     * <p>
     * 输入: "aba"
     * <p>
     * 输出: False
     * 示例 3:
     * <p>
     * 输入: "abcabcabcabc"
     * <p>
     * 输出: True
     * <p>
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                String tem = s.substring(0, i);//子串
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < len / i; j++) {
                    sb = sb.append(tem);//生成相同长度
                }
                if (sb.toString().equals(s))//验证
                    return true;
            }
        }
        return false;
    }

    @Test
    public void repeatedSubstringPattern() {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
    }

    /**
     * 461. 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 注意：
     * 0 ≤ x, y < 231.
     * 示例:
     * 输入: x = 1, y = 4
     * 输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * <p>
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        final String s = Integer.toBinaryString(x);
        final String d = Integer.toBinaryString(y);
        final int sLen = s.length();
        final int bLen = d.length();
        int max = sLen > bLen ? sLen : bLen;
        int sum = 0;
        int[] a = new int[max];
        int[] b = new int[max];
        final char[] chars = s.toCharArray();
        final char[] chars1 = d.toCharArray();
        if (sLen > bLen) {
            for (int i = 0; i < max; i++) {
                a[i] = chars[i] - 48;
            }
            for (int i = 0; i < bLen; i++) {
                b[max - bLen + i] = chars1[i] - 48;
            }
        } else {
            for (int i = 0; i < sLen; i++) {
                a[max - sLen + i] = chars[i] - 48;
            }
            for (int i = 0; i < max; i++) {
                b[i] = chars1[i] - 48;
            }
        }
        for (int i = 0; i < max; i++) {
            int i1 = a[i] - b[i];
            i1 = i1 >= 0 ? i1 : -i1;
            sum += i1;
        }
        return sum;
    }

    @Test
    public void hammingDistance() {
        System.out.println(hammingDistance(1, 4));
    }


    /**
     * 463. 岛屿的周长
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * <p>
     * 答案: 16
     * 解释: 它的周长是下面图片中的 16 个黄色的边：
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int len = grid.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            final int length = grid[i].length;
            for (int j = 0; j < length; j++) {
                final int i1 = grid[i][j];
                if (i1 == 1) {
                    sum += 4;
                    if (j + 1 < length) {
                        if (grid[i][j + 1] == 1) {
                            sum -= 2;
                        }
                    }
                    if (i + 1 < len) {
                        if (grid[i + 1][j] == 1) {
                            sum -= 2;
                        }
                    }
                }
            }
        }
        return sum;
    }

    @Test
    public void islandPerimeter() {
        int[][] grid=new int[][]{{1},{0}};
        System.out.println(islandPerimeter(grid));
    }


    /**
     * 475. 供暖器
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
     所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
     说明:
     给出的房屋和供暖器的数目是非负数且不会超过 25000。
     给出的房屋和供暖器的位置均是非负数且不会超过10^9。
     只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
     所有供暖器都遵循你的半径标准，加热的半径也一样。
     示例 1:
     输入: [1,2,3],[2]
     输出: 1
     解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     示例 2:
     输入: [1,2,3,4],[1,4]
     输出: 1
     解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        //先将houses和heaters排序，计算每一个house左右的供暖器的距离最小的那个值，然后将所有的这些最小值中取最大的值。
        //因为houses和heaters都是排序好的，所以heater[j]与houses[i]的距离应该越来越小，如果突然间变大了，说明不是最小值了，就break掉。这样就能得知最小值。
        final int hLen = houses.length;
        final int sLen = heaters.length;
        sort(houses);
        sort(heaters);
        int max=0;
        int begin=0;
        for (int i = 0; i < hLen; i++) {
            final int house = houses[i];
            int tempMin= Integer.MAX_VALUE;
            for (int j = begin; j < sLen; j++) {
                final int heater = heaters[j];
                final int abs = Math.abs(house - heater);
                if(abs <= tempMin) {
                    tempMin = abs;
                    begin = j;
                } else {
                    break;
                }
            }
            max=Integer.max(max, tempMin);
        }
        return max;
    }

    @Test
    public void findRadius() {
//        int[] houses=new int[]{1,2,3};
//        int[] heaters=new int[]{2};
        int[] houses=new int[]{1,2,3,4};
        int[] heaters=new int[]{1,4};
        System.out.println(findRadius(houses,heaters));
    }


    /**
     * 476. 数字的补数
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

     注意:

     给定的整数保证在32位带符号整数的范围内。
     你可以假定二进制数不包含前导零位。
     示例 1:

     输入: 5
     输出: 2
     解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
     示例 2:

     输入: 1
     输出: 0
     解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
     * @param num
     * @return
     */
    public int findComplement(int num) {
        final String s = Integer.toBinaryString(num);
        final int length = s.length();
        int sum=0;
        for (int i = length - 1; i >= 0 ; i--) {
            final int i1 = s.charAt(i) - 48;
            int i2 = i1 ^ 1;
            if (i2==1){
                sum+=Math.pow(2,length - 1-i );
            }
        }
        return sum;
    }

    @Test
    public void findComplement() {
        System.out.println(findComplement(5));
    }

    /**
     * 479. 最大回文数乘积
     *
     * 你需要找到由两个 n 位数的乘积组成的最大回文数。
     由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
     示例:
     输入: 2
     输出: 987
     解释: 99 x 91 = 9009, 9009 % 1337 = 987
     说明:
     n 的取值范围为 [1,8]。
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if(1==n) return 9;

        int upBound = (int)Math.pow(10,n) - 1;
        int lowBound = (int)(upBound/10);

        long maxValue = (long)upBound*(long)upBound;
        // left part of multiply(palindrome)
        int leftHalf = (int)(maxValue / (long)Math.pow(10,n));

        long palindrome = 0;
        boolean palindromeFound = false;

        while(false == palindromeFound){
            palindrome = createPalindrome(leftHalf);
            // judge if there are two factors
            // Espacially note: long is different from int
            for(long i=upBound; i>lowBound; i--){
                // find the two factors
                if(0 == palindrome%i){
                    palindromeFound = true;
                    break;
                }
                if(i*i<palindrome){
                    break;
                }
            }
            leftHalf--; // next palindrome
        }
        return (int)(palindrome % 1337);
    }//largestPalindrome

    private long createPalindrome(long left){
        String leftStr = Long.toString(left);
        String rightStr = new StringBuffer(leftStr).reverse().toString();
        return Long.parseLong(leftStr+rightStr);
    }//createPalindrome


    /**
     * 482. 密钥格式化
     * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。

     给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。

     示例 1：

     输入：S = "5F3Z-2e-9-w", K = 4

     输出："5F3Z-2E9W"

     解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     注意，两个额外的破折号需要删掉。
     示例 2：
     输入：S = "2-5g-3-J", K = 2
     输出："2-5G-3J"
     解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     提示:

     S 的长度不超过 12,000，K 为正整数
     S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
     S 非空
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        String s = S.replaceAll("-", "");
        final int length = s.length();
        StringBuilder sb=new StringBuilder();
        final int i1 = length % K;
        if (i1==0){
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                sb.append(String.valueOf(c).toUpperCase());
                if ((i+1) >= K && (i+1) < length && (i+1)%K==0){
                    sb.append("-");
                }
            }
        }else {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                sb.append(String.valueOf(c).toUpperCase());
                if ((i+1)<length && (i-i1+1)%K==0){
                    sb.append("-");
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void licenseKeyFormatting(){
//        String s="5F3Z-2e-9-w";
//        int k= 4;
        String s="2-5g-3-J";
        int k=  2;
        System.out.println(licenseKeyFormatting(s,k));
    }




    /**
     *
     *  485. 最大连续1的个数
     *
     给定一个二进制数组， 计算其中最大连续1的个数。

     示例 1:

     输入: [1,1,0,1,1,1]
     输出: 3
     解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     注意：

     输入的数组只包含 0 和1。
     输入数组的长度是正整数，且不超过 10,000。
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        final int length = nums.length;
        int max = 0,count=0;
        for (int i = 0; i < length; i++) {
             if (nums[i]==1){
                 count++;
             }else {
                 count=0;
             }
            max=max>count?max:count;
        }
        return max;
    }

    @Test
    public void findMaxConsecutiveOnes() {
        int[] nums=new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * 492. 构造矩形
     * 492. 构造矩形
     题目描述提示帮助提交记录社区讨论阅读解答
     作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：

     1. 你设计的矩形页面必须等于给定的目标面积。

     2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。

     3. 长度 L 和宽度 W 之间的差距应当尽可能小。
     你需要按顺序输出你设计的页面的长度 L 和宽度 W。

     示例：

     输入: 4
     输出: [2, 2]
     解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
     但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
     说明:

     给定的面积不大于 10,000,000 且为正整数。
     你设计的页面的长度和宽度必须都是正整数。
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        if (area==1){
            return new int[]{1,1};
        }
        int[] nums=new int[2];
        int min=Integer.MAX_VALUE;
        for (int i = area; i >0 ; i--) {
            for (int j = 0; j<=i; j++) {
                if (i*j>area){
                    break;
                }
                if (i>=j&&i*j==area){
                    if (min>i-j){
                        nums[0]=i;
                        nums[1]=j;
                        min=i-j;
                    }
                }
            }
        }
        return nums;
    }

    @Test
    public void constructRectangle() {
        System.out.println(Arrays.toString(constructRectangle(2)));
    }

    /**
     * 496. 下一个更大元素 I
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

     nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

     示例 1:

     输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     输出: [-1,3,-1]
     解释:
     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     示例 2:

     输入: nums1 = [2,4], nums2 = [1,2,3,4].
     输出: [3,-1]
     解释:
     对于num1中的数字2，第二个数组中的下一个较大数字是3。
     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
     注意:

     nums1和nums2中所有元素是唯一的。
     nums1和nums2 的数组大小都不超过1000。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            final int i1 = nums1[i];
            boolean isa=false;
            for (int j = 0; j < len2; j++) {
                final int i2 = nums2[j];
                if (isa&&i2>i1){
                    nums1[i]=i2;
                    break;
                }else {
                    if (j==len2-1){
                        isa=false;
                    }
                }
                if (j<len2-1 && i1==i2){
                    isa=true;
                }
            }
            if (!isa){
                nums1[i]=-1;
            }
        }
        return nums1;
    }

    @Test
    public void nextGreaterElement(){
        int[] nums1=new int[]{4,1,2};
        int[] nums2=new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }

    /**
     * 500. 键盘行
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。


     American keyboard


     示例1:

     输入: ["Hello", "Alaska", "Dad", "Peace"]
     输出: ["Alaska", "Dad"]
     注意:

     你可以重复使用键盘上同一字符。
     你可以假设输入的字符串将只包含字母。
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        final List<String> list1 = Arrays.asList("q", "w", "e","r","t", "y", "u","i","o", "p");
        final List<String> list2 = Arrays.asList("a", "s", "d","f","g", "h", "j","k","l");
        final List<String> list3 = Arrays.asList("z", "x", "c","v","b", "n", "m");
        final int length = words.length;
        List<String> result=new LinkedList<>();
        for (int i = 0; i < length; i++) {
            final String word = words[i];
            final int length1 = word.length();
            int isa=0;
            boolean isOk=true;
            for (int j = 0; j < length1; j++) {
                if (!isOk){
                    break;
                }
                final String s = String.valueOf(word.charAt(j));
                String s1 = s.toUpperCase();
                String s2 = s.toLowerCase();
                if (list1.contains(s1)||list1.contains(s2)){
                    if (isa==0||isa==1){
                        isa=1;
                    }else {
                        isOk=false;
                        break;
                    }
                }else   if (list2.contains(s1)||list2.contains(s2)){
                    if (isa==0||isa==2){
                        isa=2;
                    }else {
                        isOk=false;
                        break;
                    }
                }else   if (list3.contains(s1)||list3.contains(s2)){
                    if (isa==0||isa==3){
                        isa=3;
                    }else {
                        isOk=false;
                        break;
                    }
                }else {
                    isOk=false;
                    break;
                }
            }
            if (isOk){
                result.add(words[i]);
            }
        }
        String[] s=new String[result.size()];
        final int[] j = {0};
        result.forEach(a -> {
            s[j[0]]=a;
            j[0]++;
        });
        return s;
    }

    @Test
    public void findWords() {
        String[] strings=new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(strings)));
    }

    public int[] findMode(TreeNode root) {
        if (root==null)return new int[0];
        Map<Integer,Integer> map=new TreeMap<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        int max=0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int val = node.val;
            val=map.compute(val,(k,v) ->v==null?1:v+1);
            max=max>val?max:val;
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        final Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        ArrayList<Integer> list =new ArrayList();
        for (Map.Entry<Integer, Integer> entry:entries){
            int key = entry.getKey();
            Integer value = entry.getValue();
            if (max==value){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void findMode() {
        TreeNode root=new TreeNode(23);
//        TreeNode right=new TreeNode(1);
//        TreeNode left=new TreeNode(2);
//        root.right=right;
//        right.left=left;
        System.out.println(Arrays.toString(findMode(root)));
    }

    /**
     * 给定一个整数，将其转化为7进制，并以字符串形式输出。

     示例 1:

     输入: 100
     输出: "202"
     示例 2:

     输入: -7
     输出: "-10"
     注意: 输入范围是 [-1e7, 1e7] 。

     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder builder = new StringBuilder();
        String flag = "";

        if (num < 0) {
            flag = "-";
            num = - num;
        }

        while (num > 0) {
            builder.append(num % 7);
            num /= 7;
        }

        builder.append(flag);

        return builder.reverse().toString();
    }

    @Test
    public void convertToBase7() {
        System.out.println(convertToBase7(100));
        System.out.println(9%10);
    }

    /**
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        double sqrt = Math.sqrt(num);
        int nums=1;
        for (int i = 2; i < sqrt; i++) {
            int n = num / i;
            if (num==n*i){
                nums+=i+num/i;
            }
        }
        return nums==num;
    }

    @Test
    public void checkPerfectNumber(){
        System.out.println(checkPerfectNumber(28));
    }


    /**
     * 520. 检测大写字母
     *
     给定一个单词，你需要判断单词的大写使用是否正确。

     我们定义，在以下情况时，单词的大写用法是正确的：

     全部字母都是大写，比如"USA"。
     单词中所有字母都不是大写，比如"leetcode"。
     如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     否则，我们定义这个单词没有正确使用大写字母。
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char[] letters = word.toCharArray();
        int len = letters.length;
        int value = 0;
        for(int i = 0;i < len;i++){
            if(letters[i] <= 'Z' && letters[i] >= 'A'){
                value = value + 1;
            }
        }
        if(value == len || value == 0)
            return true;
        if(value == 1 && letters[0] <= 'Z' && letters[0] >= 'A')
            return true;
        return false;
    }

    /**
     *  530.二叉搜索树的最小绝对差
     *给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。

     示例 :

     输入:

     1
     \
     3
     /
     2

     输出:
     1

     解释:
     最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        List<Integer> list=new ArrayList<>();
        while (!stack.isEmpty()){
            final TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        int max=Integer.MAX_VALUE;
        final int size = list.size();
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                int abs = Math.abs(list.get(i) - list.get(j));
                max=max<abs?max:abs;
            }
        }
        return max;
    }

    /**
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

     示例 1:

     输入: [3, 1, 4, 1, 5], k = 2
     输出: 2
     解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     尽管数组中有两个1，但我们只应返回不同的数对的数量。
     示例 2:

     输入:[1, 2, 3, 4, 5], k = 1
     输出: 4
     解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     示例 3:

     输入: [1, 3, 1, 5, 4], k = 0
     输出: 1
     解释: 数组中只有一个 0-diff 数对，(1, 1)
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        final int length = nums.length;
        int count=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if (k==abs){
                    boolean isAdd=true;
                    List<Integer> orDefault = map.getOrDefault(nums[i], new LinkedList<>());
                    if (orDefault.contains(nums[j])){
                        isAdd=false;
                    }
                    List<Integer> list = map.getOrDefault(nums[j], new LinkedList<>());
                    if (list.contains(nums[i])){
                        isAdd=false;
                    }
                    orDefault.add(nums[j]);
                    map.put(nums[i],orDefault);
                    if (isAdd){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Test
    public void findPairs() {
        int k = 0;
//        int[] nums=new int[]{3,1,4,1,5};
        int[] nums=new int[]{1,3,6,5,4,7,8};
        System.out.println(findPairs(nums,k));
        System.out.println(0 >>> 16);
        System.out.println( "1".hashCode() ^ (0 >>> 16));
        final int length = nums.length;
        int left=0;
        int right= length-1;
        for(;;){
             int l = nums[left];
             int r = nums[right];
             if (left>=length/2){
                 break;
             }
            if (l%2==0){
                if (r%2==1){
                    int t;
                    t=l;
                    nums[left]=r;
                    nums[right]=t;
                    left++;
                    right--;
                }else {
                    if (right<=length/2){
                        break;
                    }
                    right--;
                }
            }else {
                 left++;
            }
        }
        System.out.println(Arrays.toString(nums));

    }


    @Test
    public void testHashSet(){
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("1");
        hashSet.add("1");
        System.out.println(hashSet);
    }





}
