package pers.cc.demo.leetcode;

import com.sun.org.apache.regexp.internal.RE;
import javafx.util.Pair;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

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
        for (int i = 0; i < list.size(); i++) {
            if (listNode == null) {
                listNode = new ListNode(list.get(i));
                result = listNode;
            } else {
                listNode.next = new ListNode(list.get(i));
                listNode = listNode.next;
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

    /**
     * -----------------------------26. 删除排序数组中的重复项---------------------------
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int del = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = nums[len - del - 1];
                    nums[len - del - 1] = nums[i];
                    del++;
                }
            }
        }
        return len - del;
    }

    @Test
    public void removeDuplicates() {
//        int[] nums=new int[]{1};
//        int[] nums=new int[]{1,1};
//        int[] nums=new int[]{1,1,2};
//        int[] nums=new int[]{1,1,1,1};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

//        int[] nums = new int[]{0, 0, 0, 0,0};
        int len = removeDuplicates(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }


    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int del = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == val && nums[j] != val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                del++;
            }
        }
        return len - del;
    }

    @Test
    public void removeElement() {
        int[] ints = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(ints, 2));
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 实现strStr()
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int len = chars.length;
        int nLen = needles.length;
        int start = -1;
        int r = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == needles[0] && start == -1) {
                if (len - i < nLen) {
                    return -1;
                }
                start = i;
                while (i < start + nLen && i - start < nLen && chars[i] == needles[i - start]) {
                    i++;
                    r++;
                }
                if (r == nLen) {
                    return start;
                }
                r = 0;
                i = start;
                start = -1;
            } else {
                start = -1;
            }
        }
        if (start == -1) {
            return -1;
        }
        return -1;
    }

    @Test
    public void strStr() {
//        System.out.println(strStr("aaaaa","bba"));
//        System.out.println(strStr("aaa","a"));
//        System.out.println(strStr("aaa","aa"));
//        System.out.println("mississippi".indexOf("issip"));
        System.out.println(strStr("mississippi", "pi"));
//        System.out.println(strStr("mississippi","issip"));
//        System.out.println(strStr("a","a"));
//        System.out.println(strStr("hello","ll"));
    }

    /**
     * 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[len - 1]) {
            return len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }

        }
        return 0;
    }

    @Test
    public void searchInsert() {
        int target = 5;
//        int target=2;
//        int target=7;
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(searchInsert(nums, target));
    }

    /**
     * 报数
     * <p>
     * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * 给定一个正整数 n ，输出报数序列的第 n 项。
     * 注意：整数顺序将表示为一个字符串。
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return "没看懂题";
    }

    @Test
    public void countAndSay() {

    }

    /**
     * -----------------------------53---------------------------
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int start;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            start = i;
            while (i < len) {
                sum += nums[i];
                i++;
                maxSum = maxSum > sum ? maxSum : sum;
            }
            i = start;
        }
        return maxSum;
    }

    @Test
    public void maxSubArray() {
//        int[] nums=new int[]{4,-1,2,1,-5};
//        int[] nums=new int[]{-2,-1};
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 最后一个单词的长度
     * <p>
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * 示例:
     * 输入: "Hello World"
     * 输出: 5
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        int len = strings.length;
        if (len == 0) {
            return 0;
        }
        return strings[len - 1].length();
    }

    @Test
    public void lengthOfLastWord() {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    /**
     * ----------------------------------66--------------------------------
     * 加一
     * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = 0;
        int last = digits[len - 1 - i] + 1;
        if (last >= 10) {
            while (last >= 10 && i < len) {
                digits[len - 1 - i] = last - 10;
                i++;
                if (i >= len) {
                    len = len + 1;
                    digits[len - 1 - i] = digits[len - 1 - i] + 1;
                    last = digits[len - 1 - i];
                    digits = Arrays.copyOf(digits, len);
                } else {
                    last = digits[len - 1 - i] + 1;
                    digits[len - 1 - i] = last;
                }
            }
            return digits;
        }
        digits[len - 1 - i] = last;
        return digits;
    }

    @Test
    public void plusOne() {
//        int[] nums = new int[]{9};
//        int[] nums = new int[]{9,9};
        int[] nums = new int[]{5, 6, 2, 0, 0, 4, 6, 2, 4, 9};
//        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    /**
     * -------------------------70. 爬楼梯-------------------------------------
     * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 步 + 1 步
     * 2.  2 步
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 步 + 1 步 + 1 步
     * 2.  1 步 + 2 步
     * 3.  2 步 + 1 步
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastLast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastLast;
            lastLast = last;
            last = now;
        }
        return now;
    }

    @Test
    public void climbStairs() {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(2));
    }

    /**
     * 83 Remove Duplicates from Sorted List
     * <p>
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     * <p>
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        SortedSet<Integer> set = new TreeSet<>();
        while (head != null) {
            set.add(head.val);
            head = head.next;
        }
        Iterator<Integer> iterator = set.iterator();
        ListNode listNode = null;
        while (iterator.hasNext()) {
            if (listNode == null) {
                listNode = new ListNode(iterator.next());
                head = listNode;
            } else {
                listNode.next = new ListNode(iterator.next());
                listNode = listNode.next;
            }
        }
        return head;
    }

    @Test
    public void deleteDuplicates() {

        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(2);
        l5.next = l6;
        l6.next = l7;

        System.out.println(deleteDuplicates(l5));

    }

    /**
     * ------------------------88---------------------------
     * Merge Sorted Array
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int j = 0; j < n; j++) {
            list.add(nums2[j]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }

    @Test
    public void merge() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        int m = nums1.length;
        int n = nums2.length;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
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
     * -----------------100. 相同的树--------------------
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * <p>
     * 示例 1:
     * <p>
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * <p>
     * [1,2,3],   [1,2,3]
     * <p>
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:      1          1
     * /           \
     * 2             2
     * <p>
     * [1,2],     [1,null,2]
     * <p>
     * 输出: false
     * 示例 3:
     * <p>
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * <p>
     * [1,2,1],   [1,1,2]
     * <p>
     * 输出: false
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (q == null && p != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

    @Test
    public void isSameTree() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(3);

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;


        System.out.println(isSameTree(treeNode, treeNode3));
    }


    /**
     * --------------104二叉树的最大深度--------------------
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int i = getDepth(left);
        int j = getDepth(right);
        return i > j ? i + 1 : j + 1;
    }


    @Test
    public void maxDepth() {
        TreeNode treeNode = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        System.out.println(maxDepth(treeNode));
    }

    int depth;

    /**
     * --------------------101. 对称二叉树----------
     * <p>
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     * 说明:
     * <p>
     * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getNodeEntryList(root.left, root.right);
    }

    private boolean getNodeEntryList(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if ((l != null && r == null) || (r != null && l == null)) return false;
        return (l.val == r.val) && getNodeEntryList(l.left, r.right) && getNodeEntryList(l.right, r.left);
    }

    @Test
    public void isSymmetric() {
        TreeNode treeNode = new TreeNode(1);

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        System.out.println(isSymmetric(treeNode));
    }


    /**
     * 二叉树的层次遍历 II
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> integers = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                integers.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            list.add(integers);
        }
        Collections.reverse(list);
        return list;
    }

    @Test
    public void levelOrderBottom() {
        TreeNode treeNode = new TreeNode(1);

        TreeNode treeNode1 = new TreeNode(3);

        treeNode.left = treeNode1;
        System.out.println(levelOrderBottom(treeNode));
    }

    /**
     * ---------------------平衡二叉树-------------
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true 。
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false 。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, 0, 0);
    }


    @Test
    public void isBalanced() {
        TreeNode treeNode = new TreeNode(1);

        TreeNode treeNode1 = new TreeNode(3);

        treeNode.left = treeNode1;
        System.out.println(isBalanced(treeNode));
    }


    public boolean isBalanced(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min <= 1;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return max - min <= 1;
        }
        if (left == null && right != null) {
            return isBalanced(root.right, min, max + 1);
        }
        if (left != null && right == null) {
            return isBalanced(root.left, min, max + 1);
        }
        return isBalanced(root.left, min + 1, max + 1) || isBalanced(root.right, min + 1, max + 1);
    }

    /**
     * ----------------112. 路径总和-----------------
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        sum -= root.val;
        if (root.left == null && root.right != null) {
            return hasPathSum(root.right, sum);
        }
        if (root.right == null && root.left != null) {
            return hasPathSum(root.left, sum);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    @Test
    public void hasPathSum() {
        TreeNode treeNode = new TreeNode(-2);
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(-3);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(hasPathSum(treeNode, -5));
    }

    /**
     * ---------------------------118. 杨辉三角---------------------------
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < i + 1; j++) {
                list.add(0, 1);
                for (int k = 1; k < list.size() - 1; k++) {
                    list.set(k, list.get(k) + list.get(k + 1));
                }
            }
            result.add(list);
        }
        return result;
    }

    @Test
    public void generate() {
        System.out.println(generate(5));
    }


    /**
     * ---------------------------118. 杨辉三角---------------------------
     * 给定一个非负整数 numRows，生成杨辉三角的第 numRows 行。
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        for (int j = 0; j < rowIndex + 1; j++) {
            list.add(0, 1);
            for (int k = 1; k < list.size() - 1; k++) {
                list.set(k, list.get(k) + list.get(k + 1));
            }
        }
        return list;
    }

    /**
     * ----------------------108. 将有序数组转换为二叉搜索树-------------------
     * 将有序数组转换为二叉搜索树
     * <p>
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
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
        TreeNode root = null;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
        return root;
    }


    @Test
    public void sortedArrayToBST() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(sortedArrayToBST(nums));
    }


    /**
     * --------------121. 买卖股票的最佳时机---------------
     *
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

     注意你不能在买入股票前卖出股票。

     示例 1:

     输入: [7,1,5,3,6,4]
     输出: 5
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     示例 2:

     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int max=0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j <len ; j++) {
                int price=prices[j]-prices[i];
                if (price>=0){
                    max=max>price?max:price;
                }
            }
        }
        return max;
    }

    @Test
    public void maxProfit() {
        int[] prices=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * ---------------------买卖股票的最佳时机 II----------------------
     *
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

     示例 1:

     输入: [7,1,5,3,6,4]
     输出: 7
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     示例 2:

     输入: [1,2,3,4,5]
     输出: 4
     解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     示例 3:

     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len=prices.length;
        int max=0;
        for (int i = 0; i <len-1; i++) {
            List<Pair<Integer,Integer>> pairs=new LinkedList<>();
            for (int j = i+1; j <len ; j++) {
                int price=prices[j]-prices[i];
                if (price>=0){
                    i=j-1>=i?j-1:j;
                    max+=price;
                    pairs.add(new Pair<>(i, price));
                }
            }
        }
        return max;
    }

    @Test
    public void maxProfit2() {
//        int[] prices=new int[]{7,1,5,3,6,4};
//        int[] prices=new int[]{1,2,3,4,5};
        int[] prices=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }

    /**
     * ---------------125. 验证回文串--------------
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        return false;
    }

}
