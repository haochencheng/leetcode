package pers.cc.demo.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode1to10 {

	@Test
	public void twoSum() {
		int[] nums = new int[] { 3, 3 };
		int target = 6;
		System.out.println(Arrays.toString(LeetCode1to10.twoSum(nums, target)));

	}

	@Test
	public void test() {
		System.out.println(Integer.parseInt("9999999991"));

	}

	/**
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * Example: Given nums = [2, 7, 11, 15], target = 9,
	 * 
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
					return new int[] { i, j };
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
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(5);
		System.out.println(LeetCode1to10.addTwoNumbers(listNode1, listNode2).toString());
	}

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * Example
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
	 * 465 = 807.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String temp1 = "";
		String temp2 = "";
		while (l1 != null) {
			String str = String.valueOf(l1.val);
			temp1 += str;
			l1 = l1.next;
		}
		while (l2 != null) {
			String str = String.valueOf(l2.val);
			temp2 += str;
			l2 = l2.next;
		}
		StringBuilder sb1 = new StringBuilder(temp1);
		StringBuilder sb2 = new StringBuilder(temp2);
		int x = Integer.parseInt(sb1.reverse().toString());
		int y = Integer.parseInt(sb2.reverse().toString());
		int z = x + y;
		StringBuilder sb3 = new StringBuilder(String.valueOf(z)).reverse();
		ListNode pro = null;
		ListNode head = null;
		for (int i = 0; i < sb3.length(); i++) {
			if (i == 0) {
				ListNode listNode1 = new ListNode(Integer.parseInt(String.valueOf(sb3.charAt(i))));
				pro = listNode1;
				head = pro;
			} else {
				ListNode listNode2 = new ListNode(Integer.parseInt(String.valueOf(sb3.charAt(i))));
				pro.next = listNode2;
				pro = listNode2;
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
	 * 
	 * Given an arbitrary ransom note string and another string containing letters
	 * from all the magazines, write a function that will return true if the ransom
	 * note can be constructed from the magazines ; otherwise, it will return false.
	 * 
	 * Each letter in the magazine string can only be used once in your ransom note.
	 * 
	 * Note: You may assume that both strings contain only lowercase letters.
	 * 
	 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
	 * canConstruct("aa", "aab") -> true
	 * 
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
	 *
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 * 
	 * click to show spoilers.
	 * 
	 * Some hints: Could negative integers be palindromes? (ie, -1)
	 * 
	 * If you are thinking of converting the integer to string, note the restriction
	 * of using extra space.
	 * 
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
