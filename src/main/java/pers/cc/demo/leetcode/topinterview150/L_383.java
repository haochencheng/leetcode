package pers.cc.demo.leetcode.topinterview150;

import org.junit.Assert;

import java.util.HashMap;

public class L_383 {


    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.getOrDefault(c, 0) == 0) {
                return false;
            }
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
        }
        for (char c : map.keySet()) {
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Assert.assertTrue(new L_383().canConstruct("aa", "aab"));
    }

}
