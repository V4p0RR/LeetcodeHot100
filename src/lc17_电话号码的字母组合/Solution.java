package lc17_电话号码的字母组合;

import java.util.*;

public class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {
            "", "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        dfs(0, new StringBuilder(), digits);

        return res;
    }

    void dfs(int index, StringBuilder path, String digits) {

        if (index == digits.length()) {
            // 收集答案;
            res.add(String.valueOf(path));
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            path.append(letter);

            dfs(index + 1, path, digits);

            path.deleteCharAt(path.length() - 1);
        }
    }
}
