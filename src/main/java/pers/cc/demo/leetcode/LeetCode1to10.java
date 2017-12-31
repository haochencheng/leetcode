package pers.cc.demo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TransferQueue;

import org.junit.Test;

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
    public void addTwoNumbers2() {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(8);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        System.out.println(LeetCode1to10.addTwoNumbers(listNode1, listNode3).toString());
    }


    @Test
    public void addTwoNumbers3() {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        System.out.println(LeetCode1to10.addTwoNumbers(listNode3, listNode1).toString());
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
        System.out.println( LeetCode1to10.lengthOfLongestSubstring("xibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsgh"));
    }

    @Test
    public void lengthOfLongestSubstring2() {
//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("abcabcbb"));
//          System.out.println( LeetCode1to10.lengthOfLongestSubstring2("aab"));
        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("biidygcc"));

//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("bbb"));
//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("pwwkew"));
//        System.out.println( LeetCode1to10.lengthOfLongestSubstring2("xibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsgh"));
    }



    @Test
    public void isStrRepeat() {
        System.out.println( LeetCode1to10.isStrRepeat("abc"));
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
        String[] strs=s.split("");
        LinkedList<String> linkedList=new LinkedList();
        LinkedList<String> linkedListTemp=new LinkedList<String>();
        for (String str:strs){
            linkedList.add(str);
            linkedListTemp.push(str);
        }
        String tempSub="";
        String strTemp="";
        while (linkedList.size()!=0){
                strTemp=linkedList.poll();
                for (int i = 0; i < linkedList.size(); i++) {
                    if (i==0){
                        tempSub=strTemp+linkedList.get(i);
                    }else {
                        tempSub+=linkedList.get(i);
                    }
                    if (!isStrRepeat(tempSub)){
                        linkedListTemp.push(tempSub);
                    }
                }
        }
        final String[] tempStr = {""};
        linkedListTemp.forEach((c)->{
            if (c.length()> tempStr[0].length()){
                tempStr[0] =c;
            }
       });
        return tempStr[0].length();
    }

    public static int lengthOfLongestSubstring2(String s) {
        String[] strings=s.split("");
        LinkedList<String> linkedList=new LinkedList<>();
        if (!isStrRepeat(s)){
            return s.length();
        }
        return 0;
    }

    public static boolean isStrRepeat(LinkedList<String> linkedList){
        for (int i = 0; i < linkedList.size(); i++) {
            String str=linkedList.get(i);
            if (linkedList.indexOf(str)!=linkedList.lastIndexOf(str)){
                return true;
            }
        }
        return false;
    }



    public static boolean isStrRepeat(String str){
        String[] strs=str.split("");
        for (String s:strs){
            if (str.lastIndexOf(s)!=str.indexOf(s)){
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

}
