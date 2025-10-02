package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 0. 有效的括号
//已解答
//简单
//相关标签
//premium lock icon
//相关企业
//提示
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。
//
//
//示例 1：
//
//输入：s = "()"
//
//输出：true
//
//示例 2：
//
//输入：s = "()[]{}"
//
//输出：true
//
//示例 3：
//
//输入：s = "(]"
//
//输出：false
//
//示例 4：
//
//输入：s = "([])"
//
//输出：true
//
//示例 5：
//
//输入：s = "([)]"
//
//输出：false
//
//
//
//提示：
//
//1 <= s.length <= 104
//s 仅由括号 '()[]{}' 组成
public class L_20 {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Assert.assertTrue(new L_20().isValid("()"));
        Assert.assertTrue(new L_20().isValid("()[]{}"));
        Assert.assertTrue(new L_20().isValid("([])"));
        Assert.assertFalse(new L_20().isValid("([)]"));
    }

}
