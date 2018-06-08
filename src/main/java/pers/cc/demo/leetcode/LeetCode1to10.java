package pers.cc.demo.leetcode;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.*;

public class LeetCode1to10 {

    @Test
    public void twoSum() {
        int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println(Arrays.toString(LeetCode1to10.twoSum(nums, target)));

    }

    @Test
    public void test() {
        System.out.println(Integer.parseInt("9999999991"));
    }


    /**
     * --------------------------------->01<--------------------------------------
     * Given an array of integers, return indices of the two numbers such that they
     * add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * <p>
     * Example: Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int y = nums[j];
                if (x + y == target) {
                    return new int[]{i, j};
                }
            }

        }
        return result;
    }

    @Test
    public void addTwoNumbers() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(LeetCode1to10.addTwoNumbers(listNode1, listNode4).toString());
    }

    @Test
    public void addTwoNumbers1() {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(5);
        System.out.println(LeetCode1to10.addTwoNumbers(listNode1, listNode2).toString());
    }

    @Test
    public void poolLast() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(1);
        linkedList.push(2);
        System.out.println(linkedList.pollFirst());
    }

    @Test
    public void addFrist() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        System.out.println(linkedList.pollLast());
    }


    /**
     * --------------------------------->02<--------------------------------------
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order and each of their nodes
     * contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     * <p>
     * Example
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
     * 465 = 807.
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        while (l1 != null) {
            linkedList1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            linkedList2.push(l2.val);
            l2 = l2.next;
        }
        LinkedList<Integer> linkedList3 = new LinkedList<>();
        LinkedList<Integer> tempLinkList = linkedList1.size() < linkedList2.size() ? linkedList1 : linkedList2;
        int sum = 0;
        int x = 0;
        while (tempLinkList.size() > 0) {
            x = sum == 0 ? linkedList1.pollLast() + linkedList2.pollLast() : linkedList1.pollLast() + linkedList2.pollLast() + 1;
            if (x >= 10) {
                sum = 1;
                linkedList3.addFirst(x % 10);
            } else {
                sum = 0;
                linkedList3.addFirst(x);
            }
        }
        tempLinkList = linkedList1.size() > linkedList2.size() ? linkedList1 : linkedList2;
        while (tempLinkList.size() > 0) {
            x = tempLinkList.pollLast() + sum;
            if (x >= 10) {
                sum = 1;
                x = x % 10;
            } else {
                sum = 0;
            }
            linkedList3.push(x);
        }
        if (sum > 0) {
            linkedList3.addFirst(1);
        }
        ListNode pro = null;
        ListNode head = null;
        int i = 0;
        while (linkedList3.size() > 0) {
            ListNode listNode1 = new ListNode(linkedList3.pollLast());
            if (i == 0) {
                pro = listNode1;
                head = pro;
                i++;
            } else {
                pro.next = listNode1;
                pro = listNode1;
            }
        }
        return head;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode [val=" + val + ", next=" + next + "]";
        }

    }

    @Test
    public void lengthOfLongestSubstring() {
        // System.out.println( LeetCode1to10.lengthOfLongestSubstring("abcabcbb"));
        //System.out.println( LeetCode1to10.lengthOfLongestSubstring("aab"));
        //System.out.println( LeetCode1to10.lengthOfLongestSubstring("bbb"));
        System.out.println(LeetCode1to10.lengthOfLongestSubstring("xibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsgh"));
    }

    @Test
    public void lengthOfLongestSubstring2() {
//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("abcabcbb"));
//          System.out.println( LeetCode1to10.lengthOfLongestSubstring2("aab"));
        System.out.println(LeetCode1to10.lengthOfLongestSubstring2("biidygcc"));

//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("bbb"));
//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("pwwkew"));
//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("xibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsgh"));
    }


    @Test
    public void isStrRepeat() {
        System.out.println(LeetCode1to10.isStrRepeat("abc"));
    }

    /*
     * Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     *  Given "bbbbb", the answer is "b", with the length of 1.
     *  Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        String[] strs = s.split("");
        LinkedList<String> linkedList = new LinkedList();
        LinkedList<String> linkedListTemp = new LinkedList<String>();
        for (String str : strs) {
            linkedList.add(str);
            linkedListTemp.push(str);
        }
        String tempSub = "";
        String strTemp = "";
        while (linkedList.size() != 0) {
            strTemp = linkedList.poll();
            for (int i = 0; i < linkedList.size(); i++) {
                if (i == 0) {
                    tempSub = strTemp + linkedList.get(i);
                } else {
                    tempSub += linkedList.get(i);
                }
                if (!isStrRepeat(tempSub)) {
                    linkedListTemp.push(tempSub);
                }
            }
        }
        final String[] tempStr = {""};
        linkedListTemp.forEach((c) -> {
            if (c.length() > tempStr[0].length()) {
                tempStr[0] = c;
            }
        });
        return tempStr[0].length();
    }

    public static int lengthOfLongestSubstring2(String s) {
        String[] strings = s.split("");
        LinkedList<String> linkedList = new LinkedList<>();
        if (!isStrRepeat(s)) {
            return s.length();
        }
        return 0;
    }

    public static boolean isStrRepeat(LinkedList<String> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            String str = linkedList.get(i);
            if (linkedList.indexOf(str) != linkedList.lastIndexOf(str)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isStrRepeat(String str) {
        String[] strs = str.split("");
        for (String s : strs) {
            if (str.lastIndexOf(s) != str.indexOf(s)) {
                return true;
            }
        }
        return false;
    }

    public static String getLengSubStr(String s) {

        return "";
    }


    @Test
    public void ransomNote() {
        System.out.println(LeetCode1to10.canConstruct("a", "b"));
        System.out.println(LeetCode1to10.canConstruct("aa", "ab"));
        System.out.println(LeetCode1to10.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
    }

    @Test
    public void isPalindrome() {
        System.out.println(LeetCode1to10.isPalindrome(12321));
        System.out.println(LeetCode1to10.isPalindrome(123));
    }

    /**
     * Ransom Note Difficulty:Easy
     * <p>
     * Given an arbitrary ransom note string and another string containing letters
     * from all the magazines, write a function that will return true if the ransom
     * note can be constructed from the magazines ; otherwise, it will return false.
     * <p>
     * Each letter in the magazine string can only be used once in your ransom note.
     * <p>
     * Note: You may assume that both strings contain only lowercase letters.
     * <p>
     * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        @SuppressWarnings("unused")
        String temp = "";
        StringBuilder sb = new StringBuilder(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            String dump = String.valueOf(ransomNote.toCharArray()[i]);
            if (!sb.toString().contains(dump)) {
                return false;
            } else {
                temp += dump;
                sb.deleteCharAt(sb.indexOf(dump));
            }
        }
        return ransomNote.equals(ransomNote);
    }

    /**
     * Palindrome Number Difficulty:Easy
     * <p>
     * Determine whether an integer is a palindrome. Do this without extra space.
     * <p>
     * click to show spoilers.
     * <p>
     * Some hints: Could negative integers be palindromes? (ie, -1)
     * <p>
     * If you are thinking of converting the integer to string, note the restriction
     * of using extra space.
     * <p>
     * You could also try reversing an integer. However, if you have solved the
     * problem "Reverse Integer", you know that the reversed integer might overflow.
     * How would you handle such case?
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int len = 1;
        while (x / len >= 10) {
            len *= 10;
        }
        // get the head and tail number
        while (x > 0) {
            int left = x / len;
            int right = x % 10;
            if (left != right)
                return false;
            else
                x = (x % len) / 10;
            len /= 100;
        }
        return true;
    }

    /**
     * 7. 反转整数
     * <p>
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
     *
     * @param x
     * @return
     */
    private int swap(int x) {
        try {
            boolean min = false;
            if (x < 0) {
                x = -x;
            } else {
                min = true;
            }
            String[] strings = Integer.valueOf(x).toString().split("");
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = strings.length - 1; j >= 0; j--) {
                stringBuilder.append(strings[j]);
            }
            String result = stringBuilder.toString();
            return min ? Integer.valueOf(result.toString()) : -Integer.valueOf(result.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 8. 字符串转整数 (atoi)
     * 实现 atoi，将字符串转为整数。
     * <p>
     * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
     * <p>
     * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
     * <p>
     * 若函数不能执行有效的转换，返回 0。
     * <p>
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     * 因此返回 INT_MIN (−231) 。
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        char[] value = str.toCharArray();
        int len = value.length;
        char[] val = value;    /* avoid getfield opcode */
        int begin = -1;
        int end = -1;
        String symbol = null;
        boolean next = true;
        if (len == 1) {
            return str.matches("\\d+") ? Integer.valueOf(str) : 0;
        }
        for (int i = 0; i < len - 1; i++) {
            if (String.valueOf(val[i]).matches("\\d+|\\+|-")) {
                if (String.valueOf(val[i]).matches("\\+|-")) {
                    symbol = String.valueOf(val[i]);
                    if (String.valueOf(val[i + 1]).matches("\\d+") && val[i + 1] != '0') {
                        if (begin == -1) {
                            begin = i;
                            end = i + 1;
                        }

                    } else {
                        if (begin == -1) {
                            end = i;
                            next = false;
                        }
                    }
                } else {
                    if (String.valueOf(val[i]).matches("\\d+") && val[i + 1] != '0') {
                        if (begin == -1) {
                            begin = i;
                        }
                        if (next && begin != -1) {
                            end = i + 1;
                        }
                    }
                    if (String.valueOf(val[i + 1]).matches("\\d+")) {
                        if (next && begin != -1) {
                            end = i + 1;
                        }
                    } else {

                        if (next && begin != -1) {
                            end = i;
                        }
                        next = false;
                    }
                }
            } else {
                if (val[i] == ' ') {
                    continue;
                } else {
                    break;
                }
            }
        }
        if (end == -1) {
            return 0;
        }
        String result = str.subSequence(begin, end + 1).toString().replaceAll(" ", "");
        if (symbol != null) {
            if (result.length() == 1) {
                return 0;
            }
            if (result.length() > String.valueOf(Integer.MIN_VALUE).length()) {
                return Integer.MIN_VALUE;
            } else if (result.length() == String.valueOf(Integer.MIN_VALUE).length()) {
                if (result.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0) {
                    return Integer.MIN_VALUE;
                }
            }
            return Integer.valueOf(result.toString());
        }
        if (result.length() > String.valueOf(Integer.MAX_VALUE).length()) {
            return Integer.MAX_VALUE;
        } else if (result.length() == String.valueOf(Integer.MAX_VALUE).length()) {
            if (result.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            }
        }
        return Integer.valueOf(result.toString());

    }

    @Test
    public void myAtoiTest() {
//        String str =  "42";
//        String str =  "   -42";
//        String str =  "-91283472332";
//        String str = "2147483648";
//        String str = "-2147483648";
//        String str = "3.14159";
//        String str = "+-2";
//        String str = "1";
//        String str ="  0000000000012345678";
//        String str = "1a";
//          String str = "   +0 123";
//        String str = "20000000000000000000";
//     String str = "-3147483648";
//     String str = "-   234";
//     String str = "0-1";
//     String str ="4193 with words";
//     String str ="words and 987";
//     String str ="000000000000000000";
        String str = "-000000000000001";
        System.out.println(myAtoi(str));
    }

    /**
     * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     * <p>
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     * <p>
     * 输入: "LVIII"
     * 输出: 58
     * 解释: C = 100, L = 50, XXX = 30, III = 3.
     * 示例 5:
     * <p>
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (chars[i] == 'I') {
                if (i + 1 < len) {
                    if (chars[i + 1] == 'V') {
                        result += 4;
                        i = i + 1;
                        continue;
                    } else if (chars[i + 1] == 'X') {
                        result += 9;
                        i = i + 1;
                        continue;
                    }
                }
            } else if (chars[i] == 'X') {
                if ((i + 1 < len)) {
                    if (chars[i + 1] == 'L') {
                        result += 40;
                        i = i + 1;
                        continue;
                    } else if (chars[i + 1] == 'C') {
                        result += 90;
                        i = i + 1;
                        continue;
                    }
                }
            } else if (chars[i] == 'C') {
                if (i + 1 < len) {
                    if (chars[i + 1] == 'D') {
                        result += 400;
                        i = i + 1;
                        continue;
                    } else if (chars[i + 1] == 'M') {
                        result += 900;
                        i = i + 1;
                        continue;
                    }
                }
            }
            switch (c) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    @Test
    public void romanToInt() {
        System.out.println(romanToInt("IVC"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * ------------------------------------14Longest Common Prefix---------------------------------------------
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     * Example 1:
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * Note:
     * <p>
     * All given inputs are in lowercase letters a-z.
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0].toString();
        }
        int len = strs.length;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            if (strs[i].equals("")) {
                return "";
            }
            if (i == 0) {
                minIndex = strs[i].length() < strs[i + 1].length() ? i : i + 1;
            } else {
                minIndex = strs[minIndex].length() < strs[i].length() ? minIndex : i;
            }

        }

        String str = strs[minIndex];
        char[] chars = str.toCharArray();
        int charsLen = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < charsLen; j++) {
            boolean f = false;
            for (int i = 0; i < len; i++) {
                if (i != minIndex) {
                    if (strs[i].charAt(j) == chars[j]) {
                        f = true;
                    } else {
                        if (sb.toString().length() == 0) {
                            return "";
                        }
                        f = false;
                        break;
                    }
                }
            }
            if (f) {
                sb.append(chars[j]);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    @Test
    public void longestCommonPrefix() {
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("flower","flow","flight").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("dog","racecar","car").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("a").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("caa","","a","acb").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("b","cb","cab").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("c","acc","ccc").toArray()));
//        System.out.println(longestCommonPrefix((String[]) Arrays.asList("abab","aba","").toArray()));
        System.out.println(longestCommonPrefix((String[]) Arrays.asList("acc", "aaa", "aaba").toArray()));
    }

    /**
     * Valid Parentheses
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * <p>
     * Example 1:
     * <p>
     * Input: "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: "{[]}"
     * Output: true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        if (s.contains("{") && !s.contains("}")) {
            return false;
        }
        if (s.contains("(") && !s.contains(")")) {
            return false;
        }
        if (s.contains("[") && !s.contains("]")) {
            return false;
        }
        while (true) {
            String s1 = getStr(s);
            if (s1 == null) {
                return false;
            } else if (s1.equals(0)) {
                return true;
            }
            s = s1;
        }
    }

    private String getStr(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean r = true;
        for (int i = 0; i < len; i++) {
            if (!r) {
                break;
            }
            if (chars[i] == '(' && chars[i + 1] != ')') {
                i = i + 1;
                r = false;
                continue;
            }
            if (chars[i] == '[' && chars[i + 1] != ']') {
                i = i + 1;
                r = false;
                continue;
            }
            if (chars[i] == '{' && chars[i + 1] != '}') {
                i = i + 1;
                r = false;
                continue;
            }
        }
        if (r) {
            return "0";
        }
        if (chars[0] == '(' && chars[len - 1] != ')') {
            return null;
        }
        if (chars[0] == '[' && chars[len - 1] != ']') {
            return null;
        }
        if (chars[0] == '{' && chars[len - 1] != '}') {
            return null;
        }
        return s.subSequence(1, s.length() - 1).toString();
    }

    @Test
    public void isValid() {
        System.out.println(isValid("({"));
//        System.out.println(isValid("()[]"));
//        System.out.println(isValid("{()[]}"));
//        System.out.println("123".subSequence(1, 2).toString());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode result = null;
        //排序
        List<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
       for (int i=0;i<list.size();i++){
            if (listNode == null) {
                listNode = new ListNode(list.get(i));
                result = listNode;
            } else {
                listNode.next = new ListNode(list.get(i));
                listNode=listNode.next;
            }

        }
        return result;
    }

    @Test
    public void mergeTwoLists() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l4;

        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);
        l5.next = l6;
        l6.next = l7;
//
//        ListNode l1 = new ListNode(2);
//        ListNode l5 = new ListNode(1);

        System.out.println(mergeTwoLists(l1, l5));
    }

}
