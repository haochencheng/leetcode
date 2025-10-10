package backtrack;

import java.util.*;

public class LetterCombinations {

    List<String> res = new ArrayList<>();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return res;
        dfs(digits,0,"");
        return res;
    }

    private void dfs(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = phoneMap.get(c);
        for (int i = 0; i < letters.length(); i++) {
            dfs(digits,index+1,s+letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(Arrays.toString(strings.toArray()));
    }

}
