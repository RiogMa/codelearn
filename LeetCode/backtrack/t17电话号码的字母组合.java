package backtrack;

import java.util.ArrayList;
import java.util.List;

public class t17电话号码的字母组合 {
    // 全局列表存储最后结果
    List<String> res = new ArrayList<>();
//    public List<String> letterCombinations(String digits) {
//        if(digits == null || digits.length() == 0){
//            return res;
//        }
//        String[] numString  = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//
//    }
    StringBuffer temp = new StringBuffer();
    public void dfs(String digits, String[] numString, int num){
        if(num == digits.length()){
            res.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
    }
}
